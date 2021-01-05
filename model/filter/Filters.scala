package kuzminki.model


trait UniversalFilters[T] extends Ref {
  
  def matches(value: T): Filter = FilterMatches(ref, value)
  def ===(value: T): Filter = matches(value)

  def not(value: T): Filter = FilterNot(ref, value)
  def !==(value: T): Filter = not(value)
  
  // not optional

  def isNull: Filter = FilterIsNull(ref)
  def isNotNull: Filter = FilterIsNotNull(ref)

  def in(values: Seq[T]): Filter = FilterIn(ref, values)
  def notIn(value: Seq[T]): Filter = FilterNotIn(ref, value)

  def in(sub: SubQuery[T]): Filter = FilterInSubquery(ref, sub.untyped)
  def notIn(sub: SubQuery[T]): Filter = FilterNotInSubquery(ref, sub.untyped)

  // optional

  def matches(opt: Option[T]): Option[Filter] = opt.map(matches)
  def ===(opt: Option[T]): Option[Filter] = opt.map(matches)

  def not(opt: Option[T]): Option[Filter] = opt.map(not)
  def !==(opt: Option[T]): Option[Filter] = opt.map(not)

  def isNullSome: Option[Filter] = Some(isNull)
  def isNotNullSome: Option[Filter] = Some(isNotNull)

  def in(opt: Option[Seq[T]]): Option[Filter] = opt.map(in)
  def notIn(opt: Option[Seq[T]]): Option[Filter] = opt.map(notIn)
}


trait ComparativeFilters[T] extends Ref {

  def gt(value: T): Filter = FilterGt(ref, value)
  def >(value: T): Filter = gt(value)

  def gte(value: T): Filter = FilterGte(ref, value)
  def >=(value: T): Filter = gte(value)

  def lt(value: T): Filter = FilterLt(ref, value)
  def <(value: T): Filter = lt(value)

  def lte(value: T): Filter = FilterLte(ref, value)
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
}


trait StringFilters extends Ref {

  def like(value: String): Filter = FilterLike(ref, value)
  def startsWith(value: String): Filter = FilterStartsWith(ref, value)
  def endsWith(value: String): Filter = FilterEndsWith(ref, value)
  def similarTo(value: String): Filter = FilterSimilarTo(ref, value)

  // re

  def reMatch(value: String): Filter = FilterReIMatch(ref, value)
  def ~(value: String): Filter = reMatch(value)

  def reIMatch(value: String): Filter = FilterReIMatch(ref, value)
  def ~*(value: String): Filter = reIMatch(value)

  def reNotMatch(value: String): Filter = FilterReNotMatch(ref, value)
  def !~(value: String): Filter = reNotMatch(value)

  def reNotIMatch(value: String): Filter = FilterReNotImatch(ref, value)
  def !~*(value: String): Filter = reNotIMatch(value)
}














