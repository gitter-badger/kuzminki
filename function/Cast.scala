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


object Cast {
  def asString(col: UsableCol) = CastString(col)
  def asNumeric(col: UsableCol) = CastNumeric(col)
  def asFloat(col: UsableCol) = CastFloat(col)
  def asDouble(col: UsableCol) = CastDouble(col)
  def asShort(col: UsableCol) = CastShort(col)
  def asInt(col: UsableCol) = CastInt(col)
  def asLong(col: UsableCol) = CastLong(col)
}


case class CastString(underlying: UsableCol) extends StringFunction with UnderlyingArgs {
  val template = "%s::text"
}

case class CastNumeric(underlying: UsableCol) extends NumericFunction with UnderlyingArgs {
  val template = "%s::numeric"
}

case class CastFloat(underlying: UsableCol) extends FloatFunction with UnderlyingArgs {
  val template = "%s::real"
}

case class CastDouble(underlying: UsableCol) extends DoubleFunction with UnderlyingArgs {
  val template = "%s::float8"
}

case class CastShort(underlying: UsableCol) extends ShortFunction with UnderlyingArgs {
  val template = "%s::smallint"
}

case class CastInt(underlying: UsableCol) extends IntFunction with UnderlyingArgs {
  val template = "%s::int"
}

case class CastLong(underlying: UsableCol) extends LongFunction with UnderlyingArgs {
  val template = "%s::text"
}




