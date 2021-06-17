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


trait Filter extends Renderable {
  def template: String
}

trait SingleFilter extends Filter {
  val col: AnyCol
  def render(prefix: Prefix) = template.format(col.render(prefix))
}

trait SingleArgFilter extends SingleFilter {
  val arg: Any
  def args = col.args ++ Seq(arg)
}

trait NoArgFilter extends SingleFilter with ColArgs

trait SubqueryFilter extends Filter {
  val col: AnyCol
  val sub: Renderable
  def render(prefix: Prefix) = template.format(col.render(prefix), sub.render(prefix))
  def args = col.args ++ sub.args
}

trait ArrayFilter extends Filter {
  val col: AnyCol
  val argSeq: Seq[Any]
  def render(prefix: Prefix) = template.format(col.render(prefix), Vector.fill(args.size)("?").mkString(", "))
  def args = col.args ++ argSeq
}

case class FilterMatches(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s = ?"
}

case class FilterNot(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s != ?"
}

case class FilterGt(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s > ?"
}

case class FilterGte(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s >= ?"
}

case class FilterLt(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s < ?"
}

case class FilterLte(col: AnyCol, arg: Any) extends SingleArgFilter {
  def template = "%s <= ?"
}

case class FilterIn(col: AnyCol, argSeq: Seq[Any]) extends ArrayFilter {
  def template = "%s = ANY(ARRAY[%s])"
}

case class FilterNotIn(col: AnyCol, argSeq: Seq[Any]) extends ArrayFilter {
  def template = "%s != ANY(ARRAY[%s])"
}

case class FilterBetween(col: AnyCol, argSeq: Seq[Any]) extends SingleFilter {
  def template = "%s = BETWEEN ? AND ?"
  def args = col.args ++ argSeq
}

case class FilterIsNull(col: AnyCol) extends NoArgFilter {
  def template = "%s IS NULL"
}

case class FilterIsNotNull(col: AnyCol) extends NoArgFilter {
  def template = "%s IS NOT NULL"
}

case class FilterLike(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE concat('%%', ?, '%%')"
}

case class FilterStartsWith(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE concat(?, '%%')"
}

case class FilterEndsWith(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s LIKE concat('%%', ?)"
}

case class FilterSimilarTo(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReMatch(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReIMatch(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotMatch(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

case class FilterReNotImatch(col: AnyCol, arg: String) extends SingleArgFilter {
  def template = "%s SIMILAR TO ?"
}

// sub query

case class FilterInSubquery(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s = ANY(%s)"
}

case class FilterNotInSubquery(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s != ANY(%s)"
}

case class FilterAggMatches(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s = (%s)"
}

case class FilterAggNot(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s != (%s)"
}

case class FilterAggGt(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s > (%s)"
}

case class FilterAggGte(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s >= (%s)"
}

case class FilterAggLt(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s < (%s)"
}

case class FilterAggLte(col: AnyCol, sub: Renderable) extends SubqueryFilter {
  def template = "%s <= (%s)"
}

// where not exists

case class FilterMatchesNoArg(col: AnyCol) extends NoArgFilter {
  def template = "%s = ?"
}
























