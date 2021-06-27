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


class OperationWhere[M](model: M, coll: OperationCollector) {

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

/*
  private def cache[P](paramShape: ParamShape[P]) = {
    coll.add(
      WhereSec(paramShape)
    ).cache(paramShape)
  }

  def cacheWhere1[P](pick: M => TypeCol[P]) = {
    cache(new ParamShapeSingle(pick(model)))
  }
  
  def cacheWhere2[P1, P2](pick: M => Tuple2[TypeCol[P1], TypeCol[P2]]) = {
    cache(new ParamShape2(pick(model)))
  }

  def cacheWhere3[P1, P2, P3](pick: M => Tuple3[TypeCol[P1], TypeCol[P2], TypeCol[P3]]) = {
    cache(new ParamShape3(pick(model)))
  }

  def cacheWhere4[P1, P2, P3, P4](pick: M => Tuple4[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4]]) = {
    cache(new ParamShape4(pick(model)))
  }

  def cacheWhere5[P1, P2, P3, P4, P5](pick: M => Tuple5[TypeCol[P1], TypeCol[P2], TypeCol[P3], TypeCol[P4], TypeCol[P5]]) = {
    cache(new ParamShape5(pick(model)))
  }
*/
}


















