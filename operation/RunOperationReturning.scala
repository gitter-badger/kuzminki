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


class RunOperationReturning[R](coll: OperationCollector, rowConv: RowConv[R]) {
  
  def run() = {
    coll.db.select(coll.statement) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.select(coll.statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def headOpt() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def headOptAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def head() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def headAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def source = {
    coll.db.streamAsSource(coll.statement) { row =>
      rowConv.fromRow(row)
    }
  }

  def render(prefix: Prefix) = coll.render
  
  def args = coll.args
  
  def sql(handler: String => Unit) = {
    handler(coll.render)
    this
  }
}











