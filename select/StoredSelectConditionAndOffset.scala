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

package kuzminki.select

import io.rdbc.sapi.SqlWithParams
import io.rdbc.sapi.SqlWithParams
import kuzminki.rdbc.Driver
import kuzminki.render.Prefix
import kuzminki.shape.ParamConv
import kuzminki.shape.RowConv


class StoredSelectConditionAndOffset[P, R](
      db: Driver,
      template: String,
      cacheArgs: Tuple3[Vector[Any], Vector[Any], Vector[Any]],
      paramConv: ParamConv[P],
      rowConv: RowConv[R]
    ) {

  private val (args1, args2, args3) = cacheArgs

  private def transformParams(params: P, offset: Int) = {
    args1 ++ paramConv.fromShape(params) ++ args2 ++ Vector(offset) ++ args3
  }

  private def statement(params: P, offset: Int) = {
    SqlWithParams(
      template,
      transformParams(params, offset)
    )
  }
  
  def run(params: P, offset: Int) = {
    db.select(statement(params, offset)) { row =>
      rowConv.fromRow(row)
    }  
  }

  def runAs[T](params: P, offset: Int)(implicit custom: R => T) = {
    db.select(statement(params, offset)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def headOpt(params: P, offset: Int) = {
    db.selectHeadOption(statement(params, offset)) { row =>
      rowConv.fromRow(row)
    }
  }

  def headOptAs[T](params: P, offset: Int)(implicit custom: R => T) = {
    db.selectHeadOption(statement(params, offset)) { row =>
      custom(
        rowConv.fromRow(row)
      )
    }  
  }

  def runCount(params: P, offset: Int) = {
    db.count(statement(params, offset))
  }

  def source(params: P, offset: Int) = {
    db.streamAsSource(statement(params, offset)) { row =>
      rowConv.fromRow(row)
    }
  }

  def render(prefix: Prefix) = template
  
  def args = args1 ++ args2 ++ args3

  def sql(handler: String => Unit): StoredSelectConditionAndOffset[P, R] = {
    handler(template)
    this
  }
}





















