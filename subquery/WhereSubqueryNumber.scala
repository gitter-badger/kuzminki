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


class WhereSubqueryNumber[M](model: M, coll: SubCollector) {

  def all = new SingleNumberSubquery(coll)

  def where(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE cannot be empty")
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOne(pick: M => Filter) = {
    new SingleNumberSubquery(
      coll.add(
        WhereSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereOpts(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new SingleNumberSubquery(coll)
      case conds =>
        new SingleNumberSubquery(
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOpt(pick: M => Option[Filter]) = {
    pick(model) match {
      case Some(filter) =>
        WhereSec(Seq(filter))
      case None =>
        new SingleNumberSubquery(coll)
    }
  }
}















