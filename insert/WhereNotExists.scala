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


trait WhereNotExists[M <: Model, S] {

  protected val model: M
  protected val coll: InsertCollector[S]

  def whereNotExistsOne[T](pick: M => TypeCol[T]) = {
    whereNotExistsApply(
      Seq(pick(model))
    )
  }

  def whereNotExists(pick: M => Seq[TypeCol[_]]) = {
    whereNotExistsApply(pick(model))
  }

  private def whereNotExistsApply(uniqueCols: Seq[TypeCol[_]]) = {

    if (uniqueCols.isEmpty) {
      throw KuzminkiException("whereNotExists")
    }

    new RunInsertWhereNotExists(
      model,
      Reuse.fromIndex(coll.paramShape.cols, uniqueCols),
      coll.add(
        InsertBlankWhereNotExistsSec(
          coll.paramShape.size,
          ModelTable(model),
          WhereSec(
            uniqueCols.map(FilterMatchesNoArg(_))
          )
        )
      )
    )
  }
}