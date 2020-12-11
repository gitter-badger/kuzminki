package kuzminki


case class Condition(name: String) {

  //def samasem(value: Any): Part = Part.create(s"$name = ?", value)

  // written

  def matches(value: Any): Part = Part.create(s"$name = ?", value)

  def not(value: Any): Part = Part.create(s"$name != ?", value)

  def gt(value: Any): Part = Part.create(s"$name > ?", value)

  def gte(value: Any): Part = Part.create(s"$name >= ?", value)

  def lt(value: Any): Part = Part.create(s"$name < ?", value)

  def lte(value: Any): Part = Part.create(s"$name <= ?", value)

  // operators

  def ===(value: Any): Part = matches(value)

  def !==(value: Any): Part = not(value)

  def >(value: Any): Part = gt(value)

  def >=(value: Any): Part = gte(value)

  def <(value: Any): Part = lt(value)

  def <=(value: Any): Part = lte(value)

  // range

  def in(value: Seq[Any]): Part = Part.create(s"$name = ANY(?)", value)

  def between(first: Any, second: Any): Part = Part(s"$name BETWEEN ? AND ?", Seq(first, second))

  // null

  def isNull: Part = Part.create(s"$name IS NULL")

  def isNotNull: Part = Part.create(s"$name IS NOT NULL")

  // pattern

  def like(value: String): Part = Part.create(s"$name LIKE %?%", value)

  def startsWith(value: String): Part = Part.create(s"$name LIKE ?%", value)

  def endsWith(value: String): Part = Part.create(s"$name LIKE %?", value)

  def similarTo(value: String): Part = Part.create(s"$name SIMILAR TO ?", value)

  // re

  def reMatch(value: String): Part = Part.create(s"$name ~ ?", value)

  def reIMatch(value: String): Part = Part.create(s"$name ~* ?", value)

  def reNotMatch(value: String): Part = Part.create(s"$name !~ ?", value)

  def reNotIMatch(value: String): Part = Part.create(s"$name !~* ?", value)

  // re operators

  def ~(value: String): Part = reMatch(value)

  def ~*(value: String): Part = reIMatch(value)

  def !~(value: String): Part = reNotMatch(value)

  def !~*(value: String): Part = reNotIMatch(value)
}























