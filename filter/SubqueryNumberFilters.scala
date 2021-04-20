package kuzminki.model


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
}