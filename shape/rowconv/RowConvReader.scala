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

package kuzminki.shape

import scala.language.implicitConversions
import scala.util.{Try, Success, Failure}
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi.Row
import kuzminki.api.KuzminkiException
import kuzminki.conv.ValConv


class RowConvReader[R](val cols: Seq[ValConv[_]])(implicit tag: ClassTag[R]) extends RowConv[R] {

  private val indexedCols = cols.zipWithIndex

  private def read(row: Row): Seq[AnyRef] = {
    indexedCols.map {
      case (col, index) =>
        col.get(row, index).asInstanceOf[AnyRef]
    }
  }

  def fromRow(row: Row) = {
    Try {
      
      classTag[R]
        .runtimeClass
        .getConstructors
        .head
        .newInstance(read(row): _*)
        .asInstanceOf[R]
    
    } match {
      case Success(res) => res
      case Failure(ex) =>
        val name = classTag[R].runtimeClass.getName
        val message = ex.getMessage
        throw KuzminkiException(
          s"Failed to read ($name) $message"
        )
    }
  }
}