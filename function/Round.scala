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


object Round {

  def decimalNumber(col: AnyCol) = RoundAllDecimalNumber(col)
  def decimalNumber(col: AnyCol, prec: Int) = RoundDecimalNumber(col, prec)

  def float(col: AnyCol) = RoundAllFloat(col)
  def float(col: AnyCol, prec: Int) = RoundFloat(col, prec)

  def double(col: AnyCol) = RoundAllDouble(col)
  def double(col: AnyCol, prec: Int) = RoundDouble(col, prec)
}


trait RoundAll extends AnyCol with PassArgs {
  val template = "round(%s)"
  def asString = Cast.asString(this)
}

case class RoundAllDecimalNumber(col: AnyCol) extends DecimalNumberFunction with RoundAll

case class RoundAllFloat(col: AnyCol) extends FloatFunction with RoundAll

case class RoundAllDouble(col: AnyCol) extends DoubleFunction with RoundAll


trait RoundPrec extends AnyCol {
  val prec: Int
  val template = "round(%s, ?)"
  def args = col.args ++ Seq(prec)
  def asString = Cast.asString(this)
}

case class RoundDecimalNumber(col: AnyCol, prec: Int) extends DecimalNumberFunction with RoundPrec

case class RoundFloat(col: AnyCol, prec: Int) extends FloatFunction with RoundPrec

case class RoundDouble(col: AnyCol, prec: Int) extends DoubleFunction with RoundPrec




















