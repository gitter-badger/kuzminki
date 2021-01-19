package kuzminki.model


trait StringFilters extends RealColRef {

  def like(value: String): Filter = FilterLike(ref, value)
  def startsWith(value: String): Filter = FilterStartsWith(ref, value)
  def endsWith(value: String): Filter = FilterEndsWith(ref, value)
  def similarTo(value: String): Filter = FilterSimilarTo(ref, value)

  def reMatch(value: String): Filter = FilterReIMatch(ref, value)
  def ~(value: String): Filter = reMatch(value)

  def reIMatch(value: String): Filter = FilterReIMatch(ref, value)
  def ~*(value: String): Filter = reIMatch(value)

  def reNotMatch(value: String): Filter = FilterReNotMatch(ref, value)
  def !~(value: String): Filter = reNotMatch(value)

  def reNotIMatch(value: String): Filter = FilterReNotImatch(ref, value)
  def !~*(value: String): Filter = reNotIMatch(value)

  // optional

  def like(opt: Option[String]): Option[Filter] = opt.map(like)
  def startsWith(opt: Option[String]): Option[Filter] = opt.map(startsWith)
  def endsWith(opt: Option[String]): Option[Filter] = opt.map(endsWith)
  def similarTo(opt: Option[String]): Option[Filter] = opt.map(similarTo)

  def reMatch(opt: Option[String]): Option[Filter] = opt.map(reMatch)
  def ~(opt: Option[String]): Option[Filter] = opt.map(reMatch)

  def reIMatch(opt: Option[String]): Option[Filter] = opt.map(reIMatch)
  def ~*(opt: Option[String]): Option[Filter] = opt.map(reMatch)

  def reNotMatch(opt: Option[String]): Option[Filter] = opt.map(reNotMatch)
  def !~(opt: Option[String]): Option[Filter] = opt.map(reMatch)

  def reNotIMatch(opt: Option[String]): Option[Filter] = opt.map(reNotIMatch)
  def !~*(opt: Option[String]): Option[Filter] = opt.map(reMatch)
}