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


trait StringFunction extends ColFunction
                           with StringColValue
                           with UniversalFilters[String]


trait DecimalNumberFunction extends ColFunction
                                  with DecimalNumberColValue
                                  with UniversalFilters[DecimalNumber]
                                  with ComparativeFilters[DecimalNumber]


trait ShortFunction extends ColFunction
                          with ShortColValue
                          with UniversalFilters[Short]
                          with ComparativeFilters[Short]


trait IntFunction extends ColFunction
                        with IntColValue
                        with UniversalFilters[Int]
                        with ComparativeFilters[Int]


trait LongFunction extends ColFunction
                         with LongColValue
                         with UniversalFilters[Long]
                         with ComparativeFilters[Long]


trait FloatFunction extends ColFunction
                          with FloatColValue
                          with UniversalFilters[Float]
                          with ComparativeFilters[Float]


trait DoubleFunction extends ColFunction
                           with DoubleColValue
                           with UniversalFilters[Double]
                           with ComparativeFilters[Double]


trait InstantFunction extends ColFunction
                            with InstantColValue
                            with UniversalFilters[Instant]
                            with ComparativeFilters[Instant]