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


import java.time._
import io.rdbc.sapi.DecimalNumber


trait StringColDefaults extends Aggregation
                           with StringColValue
                           with UniversalFilters[String]


trait NumericColDefaults extends Aggregation
                                  with NumericColValue
                                  with UniversalFilters[DecimalNumber]
                                  with ComparativeFilters[DecimalNumber]


trait ShortColDefaults extends Aggregation
                          with ShortColValue
                          with UniversalFilters[Short]
                          with ComparativeFilters[Short]


trait IntColDefaults extends Aggregation
                        with IntColValue
                        with UniversalFilters[Int]
                        with ComparativeFilters[Int]


trait LongColDefaults extends Aggregation
                         with LongColValue
                         with UniversalFilters[Long]
                         with ComparativeFilters[Long]


trait FloatColDefaults extends Aggregation
                          with FloatColValue
                          with UniversalFilters[Float]
                          with ComparativeFilters[Float]


trait DoubleColDefaults extends Aggregation
                           with DoubleColValue
                           with UniversalFilters[Double]
                           with ComparativeFilters[Double]


trait InstantColDefaults extends Aggregation
                            with InstantColValue
                            with UniversalFilters[Instant]
                            with ComparativeFilters[Instant]







































