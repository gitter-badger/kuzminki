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


case class InsertCollector[P](
      db: Conn,
      paramShape: ParamShape[P],
      sections: Array[Section]
    ) extends CollectOperation {

  def add(section: Section) = this.copy(sections = sections :+ section)

  def extend(added: Array[Section]) = this.copy(sections = sections ++ added)

  def cacheInsert = {
    new StoredInsert(render, paramShape.conv, db)
  }

  def cacheInsertReturning[R](rowShape: RowShape[R]) = {
    new StoredInsertReturning(render, paramShape.conv, rowShape.conv, db)
  }

  def cacheInsertDoNothing = {
    new StoredInsertDoNothing(render, paramShape.conv, db)
  }

  def cacheInsertDoNothingReturning[R](rowShape: RowShape[R]) = {
    new StoredInsertDoNothingReturning(render, paramShape.conv, rowShape.conv, db)
  }

  def cacheUpsert(reuse: Reuse) = {
    new StoredUpsert(render, paramShape.conv, reuse, db)
  }

  def cacheUpsertReturning[R](rowShape: RowShape[R], reuse: Reuse) = {
    new StoredUpsertReturning(render, paramShape.conv, reuse, rowShape.conv, db)
  }

  def cacheInsertWhereNotExists(reuse: Reuse) = {
    new StoredInsertWhereNotExists(render, paramShape.conv, reuse, db)
  }

  def cacheInsertWhereNotExistsReturning[R](rowShape: RowShape[R], reuse: Reuse) = {
    new StoredInsertWhereNotExistsReturning(render, paramShape.conv, reuse, rowShape.conv, db)
  }

  def cacheInsertSubquery = {
    new StoredInsertSubquery(statement, db)
  }
}