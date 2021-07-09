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

package kuzminki.operation

import kuzminki.rdbc.Driver
import kuzminki.render.{RenderCollector, Prefix}
import kuzminki.section.Section
import kuzminki.shape.PartShape


case class OperationCollector(
      db: Driver,
      sections: Array[Section]
    ) extends RenderCollector {

  val prefix = Prefix.forModel

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cacheOperation[M, P](model: M, filters: PartShape[P]) = {
    new StoredOperation(render, args.toVector, filters.conv, db)
  }

  def cacheUpdate[M, P1, P2](model: M, changes: PartShape[P1], filters: PartShape[P2]) = {
    new StoredUpdate(render, changes.conv, filters.conv, db)
  }
}