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

/*
trait SubqueryNumberFilters extends SelfRef {

  def matches(sub: SingleNumberSubquery): Filter = FilterAggMatches(self, sub)
  def ===(sub: SingleNumberSubquery): Filter = matches(sub)

  def not(sub: SingleNumberSubquery): Filter = FilterAggNot(self, sub)
  def !==(sub: SingleNumberSubquery): Filter = not(sub)

  def gt(sub: SingleNumberSubquery): Filter = FilterAggGt(self, sub)
  def >(sub: SingleNumberSubquery): Filter = gt(sub)

  def gte(sub: SingleNumberSubquery): Filter = FilterAggGte(self, sub)
  def >=(sub: SingleNumberSubquery): Filter = gte(sub)

  def lt(sub: SingleNumberSubquery): Filter = FilterAggLt(self, sub)
  def <(sub: SingleNumberSubquery): Filter = lt(sub)

  def lte(sub: SingleNumberSubquery): Filter = FilterAggLte(self, sub)
  def <=(sub: SingleNumberSubquery): Filter = lte(sub)
*/
  // optional

  /*

  conflicts with regular optional filter

  def matches(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(matches)
  def ===(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(matches)

  def not(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(not)
  def !==(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(not)

  def gt(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(gt)
  def >(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(gt)

  def gte(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(gte)
  def >=(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(gte)

  def lt(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(lt)
  def <(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(lt)

  def lte(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(lte)
  def <=(opt: Option[SingleNumberSubquery]): Option[Filter] = opt.map(lte)
  */
//}

