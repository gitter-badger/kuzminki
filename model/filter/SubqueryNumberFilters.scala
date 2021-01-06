package kuzminki.model


trait SubqueryNumberFilters extends Ref {

  def matches(sub: SingleNumberSubquery): Filter = FilterAggMatches(ref, sub.untyped)
  def ===(sub: SingleNumberSubquery): Filter = matches(sub)

  def not(sub: SingleNumberSubquery): Filter = FilterAggNot(ref, sub.untyped)
  def !==(sub: SingleNumberSubquery): Filter = not(sub)

  def gt(sub: SingleNumberSubquery): Filter = FilterAggGt(ref, sub.untyped)
  def >(sub: SingleNumberSubquery): Filter = gt(sub)

  def gte(sub: SingleNumberSubquery): Filter = FilterAggGte(ref, sub.untyped)
  def >=(sub: SingleNumberSubquery): Filter = gte(sub)

  def lt(sub: SingleNumberSubquery): Filter = FilterAggLt(ref, sub.untyped)
  def <(sub: SingleNumberSubquery): Filter = lt(sub)

  def lte(sub: SingleNumberSubquery): Filter = FilterAggLte(ref, sub.untyped)
  def <=(sub: SingleNumberSubquery): Filter = lte(sub)

  // optional

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

}