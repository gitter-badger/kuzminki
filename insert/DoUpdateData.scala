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


class DoUpdateData[M](
      model: M,
      coll: InsertDataCollector,
      conflictCol: ModelCol
    ) extends ValidateUpsert {

  def doNothing = {
    new RunInsertData(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoNothingSec
      ))
    )
  }

  def doUpdate(pick: M => Seq[SetValue]) = {
    doUpdateApply(
      pick(model)
    )
  }

  def doUpdateOne(pick: M => SetValue) = {
    doUpdateApply(
      Seq(pick(model))
    )
  }

  private def doUpdateApply(changes: Seq[SetValue]) = {
    validate(conflictCol, changes.map(_.col))
    new RunInsertData(
      coll.extend(Array(
        InsertOnConflictColumnSec(conflictCol),
        InsertDoUpdateSec(changes)
      ))
    )
  }
}