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

package kuzminki.fn

import kuzminki.column._
import kuzminki.function.Aggregation
import kuzminki.function.types._


object Avg {
  import avg._
  def numeric(col: NumericCol) = AvgNumeric(col)
  def float(col: FloatCol) = AvgDouble(col)
  def double(col: DoubleCol) = AvgDouble(col)
  def short(col: ShortCol) = AvgNumeric(col)
  def int(col: IntCol) = AvgNumeric(col)
  def long(col: LongCol) = AvgNumeric(col)
}


package object avg {

  trait AvgTemplate {
    val template = "avg(%s)"
  }
  
  case class AvgNumeric(underlying: AnyCol) extends NumericFunctionSingle
                                               with Aggregation
                                               with AvgTemplate {

    def asString = Cast.asString(this)
    def round = Round.numeric(this)
    def round(prec: Int) = Round.numeric(this, prec)
  }

  case class AvgDouble(underlying: AnyCol) extends DoubleFunctionSingle
                                              with Aggregation
                                              with AvgTemplate {

    def asString = Cast.asString(this)
    def round = Round.double(this)
  }
}







