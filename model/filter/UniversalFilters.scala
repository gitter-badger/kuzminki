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