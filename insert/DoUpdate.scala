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

package kuzminki.insert

import kuzminki.column.ModelCol
import kuzminki.assign.SetUpsert
import kuzminki.section.insert._


class DoUpdate[M, P](
      model: M,
      coll: InsertCollector[P],
      conflictCol: ModelCol
    ) extends ValidateUpsert {

  def doNothing = {
    new RunInsertDoNothing(
      model,
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  def doUpdate(pick: M => Seq[ModelCol]) = {
    doUpdateApply(
      pick(model)
    )
  }

  def doUpdateOne(pick: M => ModelCol) = {
    doUpdateApply(
      Seq(pick(model))
    )
  }

  private def doUpdateApply(updateCols: Seq[ModelCol]) = {
    validate(conflictCol, updateCols)
    new RunUpsert(
      model,
      Reuse.fromIndex(coll.paramShape.cols, updateCols),
      coll.extend(Array(
        InsertBlankValuesSec(coll.paramShape.size),
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateNoArgsSec(updateCols.map(SetUpsert(_)))
      ))
    )
  }
}












