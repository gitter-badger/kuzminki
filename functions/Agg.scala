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

import io.rdbc.sapi.DecimalNumber


object Agg {

  def count(col: ModelCol) = Count(col)

  def avg(col: ShortCol) = AvgNumber(col)
  def avgShort(col: ShortCol) = AvgCastShort(col)

  def avg(col: IntCol) = AvgNumber(col)
  def avgInt(col: IntCol) = AvgCastInt(col)

  def avg(col: LongCol) = AvgNumber(col)
  def avgLong(col: LongCol) = AvgCastLong(col)

  def avg(col: FloatCol) = AvgFloating(col)
  def avgFloat(col: FloatCol) = AvgCastFloat(col)

  def avg(col: DoubleCol) = AvgFloating(col)

  def sum(col: ShortCol) = SumShort(col)
  def sum(col: IntCol) = SumInt(col)
  def sum(col: LongCol) = SumLong(col)
  def sum(col: FloatCol) = SumFloat(col)
  def sum(col: DoubleCol) = SumDouble(col)

  def max(col: ShortCol) = MaxShort(col)
  def max(col: IntCol) = MaxInt(col)
  def max(col: LongCol) = MaxLong(col)
  def max(col: FloatCol) = MaxFloat(col)
  def max(col: DoubleCol) = MaxDouble(col)

  def min(col: ShortCol) = MinShort(col)
  def min(col: IntCol) = MinInt(col)
  def min(col: LongCol) = MinLong(col)
  def min(col: FloatCol) = MinFloat(col)
  def min(col: DoubleCol) = MinDouble(col)
}