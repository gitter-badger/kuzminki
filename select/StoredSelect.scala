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


import scala.concurrent.Future
import akka.stream.scaladsl._
import akka.Done
import io.rdbc.sapi.SqlWithParams


class StoredSelect[R](
      db: Conn,
      statement: SqlWithParams,
      rowConv: RowConv[R]
    ) {
  
  def run() = {
    db.select(statement) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](implicit custom: R => T) = {
    db.select(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def headOpt() = {
    db.selectHeadOption(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def headOptAs[T](implicit custom: R => T) = {
    db.selectHeadOption(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def head() = {
    db.selectHead(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def headAs[T](implicit custom: R => T) = {
    db.selectHead(statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def runCount() = {
    db.count(statement)
  }

  def source = {
    db.streamAsSource(statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def render(prefix: Prefix) = statement.sql
  
  def args = statement.params.toSeq
  
  def sql(handler: String => Unit) = {
    handler(statement.sql)
    this
  }
}





















