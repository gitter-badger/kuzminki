package kuzminki.model


trait ComparativeFilters[T] extends SelfRef {

  def gt(value: T): Filter = FilterGt(self, value)
  def >(value: T): Filter = gt(value)

  def gte(value: T): Filter = FilterGte(self, value)
  def >=(value: T): Filter = gte(value)

  def lt(value: T): Filter = FilterLt(self, value)
  def <(value: T): Filter = lt(value)

  def lte(value: T): Filter = FilterLte(self, value)
  def <=(value: T): Filter = lte(value)

  // optional

  def gt(opt: Option[T]): Option[Filter] = opt.map(gt)
  def >(opt: Option[T]): Option[Filter] = opt.map(gt)

  def gte(opt: Option[T]): Option[Filter] = opt.map(gte)
  def >=(opt: Option[T]): Option[Filter] = opt.map(gte)

  def lt(opt: Option[T]): Option[Filter] = opt.map(lt)
  def <(opt: Option[T]): Option[Filter] = opt.map(lt)

  def lte(opt: Option[T]): Option[Filter] = opt.map(lte)
  def <=(opt: Option[T]): Option[Filter] = opt.map(lte)

  // sub agg
  /*
  def matches(sub: AggSubQuery[T]): Filter = FilterAggMatches(ref, sub.untyped)
  def ===(sub: AggSubQuery[T]): Filter = matches(sub)

  def not(sub: AggSubQuery[T]): Filter = FilterAggNot(ref, sub.untyped)
  def !==(sub: AggSubQuery[T]): Filter = not(sub)

  def gt(sub: AggSubQuery[T]): Filter = FilterAggGt(ref, sub.untyped)
  def >(sub: AggSubQuery[T]): Filter = gt(sub)

  def gte(sub: AggSubQuery[T]): Filter = FilterAggGte(ref, sub.untyped)
  def >=(sub: AggSubQuery[T]): Filter = gte(sub)

  def lt(sub: AggSubQuery[T]): Filter = FilterAggLt(ref, sub.untyped)
  def <(sub: AggSubQuery[T]): Filter = lt(sub)

  def lte(sub: AggSubQuery[T]): Filter = FilterLte(ref, sub.untyped)
  def <=(sub: AggSubQuery[T]): Filter = lte(sub)

  // sub agg optional
  
  def matches(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(matches)
  def ===(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(matches)

  def not(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(not)
  def !==(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(not)

  def gt(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(gt)
  def >(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(gt)

  def gte(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(gte)
  def >=(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(gte)

  def lt(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(lt)
  def <(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(lt)

  def lte(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(lte)
  def <=(opt: Option[AggSubQuery[T]]): Option[Filter] = opt.map(lte)
  */
}















