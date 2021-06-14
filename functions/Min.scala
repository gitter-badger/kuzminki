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


trait AggMin extends AggNumeric {
  def template = "min(%s)"
}


case class MinShort(col: AnyCol) extends AggMin
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MinInt(col: AnyCol) extends AggMin
                                  with LongColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MinLong(col: AnyCol) extends AggMin
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MinFloat(col: AnyCol) extends AggMin
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MinDouble(col: AnyCol) extends AggMin
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]