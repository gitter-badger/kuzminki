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


case class AvgNumber(col: AnyCol) extends AggNumeric
                                     with DecimalNumberColValue
                                     with UniversalFilters[Long]
                                     with ComparativeFilters[Long] {

  def template = "avg(%s)"
}


case class AvgFloating(col: AnyCol) extends AggNumeric
                                       with DoubleColValue
                                       with UniversalFilters[Double]
                                       with ComparativeFilters[Double] {

  def template = "avg(%s)"
}


case class AvgCastShort(col: AnyCol) extends AggNumeric
                                        with ShortColValue
                                        with UniversalFilters[Long]
                                        with ComparativeFilters[Long] {

  def template = "avg(%s)::smallint"
}


case class AvgCastInt(col: AnyCol) extends AggNumeric
                                      with IntColValue
                                      with UniversalFilters[Long]
                                      with ComparativeFilters[Long] {

  def template = "avg(%s)::int"
}


case class AvgCastLong(col: AnyCol) extends AggNumeric
                                       with DecimalNumberColValue
                                       with UniversalFilters[Long]
                                       with ComparativeFilters[Long] {

  def template = "avg(%s)::bigint"
}


case class AvgCastFloat(col: AnyCol) extends AggNumeric
                                        with DoubleColValue
                                        with UniversalFilters[Double]
                                        with ComparativeFilters[Double] {

  def template = "avg(%s)::real"
}






































