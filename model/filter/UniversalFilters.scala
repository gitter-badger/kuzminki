package kuzminki.model


trait UniversalFilters[T] extends ColRef {
  
  def matches(value: T): Filter = FilterMatches(col, value)
  def ===(value: T): Filter = matches(value)

  def not(value: T): Filter = FilterNot(col, value)
  def !==(value: T): Filter = not(value)
  
  // not optional

  def isNull: Filter = FilterIsNull(col)
  def isNotNull: Filter = FilterIsNotNull(col)

  def in(values: Seq[T]): Filter = FilterIn(col, values)
  def notIn(value: Seq[T]): Filter = FilterNotIn(col, value)

  def in(sub: SelectSubquery[T]): Filter = FilterInSubquery(col, sub)
  def notIn(sub: SelectSubquery[T]): Filter = FilterNotInSubquery(col, sub)

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