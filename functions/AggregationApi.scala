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


trait ShortAggregations extends SelfRef {
  def avgShort = AvgCastShort(self)
  def avg = AvgNumber(self)
  def sum = SumShort(self)
  def max = MaxShort(self)
  def min = MinShort(self)
}

trait IntAggregations extends SelfRef {
  def avgInt = AvgCastInt(self)
  def avg = AvgNumber(self)
  def sum = SumInt(self)
  def max = MaxInt(self)
  def min = MinInt(self)
}

trait LongAggregations extends SelfRef {
  def avgLong = AvgCastLong(self)
  def avg = AvgNumber(self)
  def sum = SumLong(self)
  def max = MaxLong(self)
  def min = MinLong(self)
}

trait FloatAggregations extends SelfRef {
  def avgFloat = AvgCastFloat(self)
  def avg = AvgFloating(self)
  def sum = SumFloat(self)
  def max = MaxFloat(self)
  def min = MinFloat(self)
}

trait DoubleAggregations extends SelfRef {
  def avg = AvgFloating(self)
  def sum = SumDouble(self)
  def max = MaxDouble(self)
  def min = MinDouble(self)
}