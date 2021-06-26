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


trait NoRender extends Section {
  def render(picker: Prefix) = expression
}

trait SingleArg extends NoRender {
  def arg: Any
  def args = Seq(arg)
}

trait TextOnly extends NoRender with NoArgs

trait SingleRender extends Section {
  val part: Renderable
  def render(prefix: Prefix) = expression.format(part.render(prefix))
  def args = part.args
}

trait MultiRender extends Section {
  val parts: Seq[Renderable]
  def glue: String
  def render(prefix: Prefix) = expression.format(parts.map(_.render(prefix)).mkString(glue))
  def args = parts.map(_.args).flatten
}

// insert

trait FillValues {
  def fillNoBrackets(size: Int) = Vector.fill(size)("?").mkString(", ")
  def fillBrackets(size: Int) = "(%s)".format(fillNoBrackets(size))
}

// validation

abstract class NotEmpty(parts: Seq[Any]) {
  def error: String
  if (parts.isEmpty) {
    throw KuzminkiException(error)
  }
}

// cache

trait CacheCondition extends Section {
  val cacheConds: Seq[Renderable]
  def render(prefix: Prefix) = {
    expression.format(
      cacheConds.map(_.render(prefix)).mkString(" AND ")
    )
  }
  def args = Seq(Done)
}

trait MixedCondition extends Section {
  val conds: Seq[Renderable]
  val cacheConds: Seq[Renderable]
  def render(prefix: Prefix) = {
    val both = conds ++ cacheConds
    expression.format(
      both.map(_.render(prefix)).mkString(" AND ")
    )
  }
  def args = conds.map(_.args).flatten ++ Seq(Done)
}

/*
trait OnlyModelCols {

  def testCols(cols: Seq[AnyCol]): Unit = {
    cols.foreach {
      case col: ModelCol =>
      case _ => throw KuzminkiException("only model columns")
    }
  }
}
*/