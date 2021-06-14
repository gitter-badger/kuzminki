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


class StoredSelectWhere[P, R](
      db: Conn,
      template: String,
      firstArgs: Vector[Any],
      lastArgs: Vector[Any],
      paramConv: ParamConv[P],
      rowConv: RowConv[R]
    ) {

  private def transformParams(params: P) = {
    firstArgs ++ paramConv.fromShape(params) ++ lastArgs
  }

  private def statement(params: P) = {
    SqlWithParams(
      template,
      transformParams(params)
    )
  }
  
  def run(params: P) = {
    db.select(statement(params)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P)(implicit custom: R => T) = {
    db.select(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def headOpt(params: P) = {
    db.selectHeadOption(statement(params)) { row =>
      rowConv.fromRow(row)
    }
  }

  def headOptAs[T](params: P)(implicit custom: R => T) = {
    db.selectHeadOption(statement(params)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def runCount(params: P) = {
    db.count(statement(params))
  }

  def source(params: P) = {
    db.streamAsSource(statement(params)) { row =>
      rowConv.fromRow(row)
    }
  }

  def render(prefix: Prefix) = template
  
  def args = firstArgs ++ lastArgs

  def sql(handler: String => Unit): StoredSelectWhere[P, R] = {
    handler(template)
    this
  }
}





















