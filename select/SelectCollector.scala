/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.model

import akka.Done
import io.rdbc.sapi.SqlWithParams


case class SelectCollector[R](
      db: Conn,
      prefix: Prefix,
      rowShape: RowShape[R],
      sections: Array[Section]
    ) {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cache = new StoredSelect(db, statement, rowShape.conv)

  def cacheWhere[P](condShape: CondShape[P]) = {

    //canUseWhere()
    
    val modifiedSections = sections.map {
      
      case WhereBlankSec =>
        WhereCacheSec(condShape.cols)
      
      case WhereSec(conds) =>
        WhereMixedSec(conds, condShape.cols)
      
      case section: Section =>
        section
    }

    storedConditional(modifiedSections, condShape)
  }

  def cacheHaving[P](condShape: CondShape[P]) = {

    //canUseHaving()
    
    val modifiedSections = sections.map {
      
      case HavingBlankSec =>
        HavingCacheSec(condShape.cols)
      
      case HavingSec(conds) =>
        HavingMixedSec(conds, condShape.cols)
      
      case section: Section =>
        section
    }

    storedConditional(modifiedSections, condShape)
  }

  def storedConditional[P](modifiedSections: Array[Section], condShape: condShape[P]) = {

    val template = modifiedSections.map(_.render(prefix)).mkString(" ")
    val cacheArgs = modifiedSections.map(_.args).flatten.toVector

    val (firstArgs, lastArgs) = cacheArgs.splitAt(cacheArgs.indexOf(Done)) match {
      case (first, last) =>
        (first, last.tail) 
    }

    new StoredSelectWhere(db, template, firstArgs, lastArgs, condShape.conv, rowShape.conv)
  }

  // check

  val isAggrigation: AnyCol => Boolean = {
    case col: Aggregation => true
    case col: AnyCol => false
  }

  def canUseWhere() {
    rowShape.cols.count(isAggrigation) match {
      case 0 =>
      case num: Int if num == rowShape.cols.size =>
      case _ =>
        throw KuzminkiException(
          "WHERE cannot be used here, use HAVING"
        )
    }
  }

  def canUseHaving() {
    rowShape.cols.count(isAggrigation) match {
      case num: Int if num > 0 && num < rowShape.cols.size  =>
      case _ =>
        throw KuzminkiException(
          "HAVING cannot be used here, use WHERE"
        )
    }
  }

  // render

  val notBlank: Section => Boolean = {
    case WhereBlankSec => false
    case HavingBlankSec => false
    case _ => true
  }

  def render = sections.filter(notBlank).map(_.render(prefix)).mkString(" ")

  def args = sections.toSeq.map(_.args).flatten.toVector

  def statement = SqlWithParams(render, args)
}























