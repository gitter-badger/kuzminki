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


trait AggMax extends AggNumeric {
  def template = "max(%s)"
}


case class MaxShort(col: AnyCol) extends AggMax
                                    with ShortColValue
                                    with UniversalFilters[Long]
                                    with ComparativeFilters[Long]


case class MaxInt(col: AnyCol) extends AggMax
                                  with IntColValue
                                  with UniversalFilters[Long]
                                  with ComparativeFilters[Long]


case class MaxLong(col: AnyCol) extends AggMax
                                   with LongColValue
                                   with UniversalFilters[Long]
                                   with ComparativeFilters[Long]


case class MaxFloat(col: AnyCol) extends AggMax
                                    with FloatColValue
                                    with UniversalFilters[Double]
                                    with ComparativeFilters[Double]


case class MaxDouble(col: AnyCol) extends AggMax
                                     with DoubleColValue
                                     with UniversalFilters[Double]
                                     with ComparativeFilters[Double]



































