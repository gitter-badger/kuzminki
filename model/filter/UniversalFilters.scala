package kuzminki.model


trait UniversalFilters[T] extends SelfRef {
  
  def matches(value: T): Filter = FilterMatches(self, value)
  def ===(value: T): Filter = matches(value)

  def not(value: T): Filter = FilterNot(self, value)
  def !==(value: T): Filter = not(value)
  
  // not optional

  def isNull: Filter = FilterIsNull(self)
  def isNotNull: Filter = FilterIsNotNull(self)

  def in(values: Seq[T]): Filter = FilterIn(self, values)
  def notIn(value: Seq[T]): Filter = FilterNotIn(self, value)

  def in(sub: SelectSubquery[T]): Filter = FilterInSubquery(self, sub)
  def notIn(sub: SelectSubquery[T]): Filter = FilterNotInSubquery(self, sub)

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