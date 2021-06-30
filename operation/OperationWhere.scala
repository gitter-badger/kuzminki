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


class OperationWhere[M](
      model: M,
      coll: OperationCollector
    ) {

  def all() = new RunOperation(model, coll)

  def whereOne(pick: M => Filter) = {
    new RunOperation(
      model,
      coll.add(
        WhereSec(
          Seq(pick(model))
        )
      )
    )
  }

  def where(pick: M => Seq[Filter]) = {
    pick(model) match {
      case Nil =>
        throw KuzminkiException("WHERE conditions cannot be empty")
      case conds =>
        new RunOperation(
          model,
          coll.add(WhereSec(conds))
        )
    }
  }

  def whereOpts(pick: M => Seq[Option[Filter]]) = {
    pick(model).flatten match {
      case Nil =>
        new RunOperation(model, coll)
      case filters =>
        new RunOperation(
          model,
          coll.add(WhereSec(filters))
        )
    }
  }

  def whereOpt(pick: M => Option[Filter]) = {
    pick(model) match {
      case Some(filter) =>
        new RunOperation(
          model,
          coll.add(
            WhereSec(Seq(filter))
          )
        )
      case None =>
        new RunOperation(model, coll)
    }
  }
}


















