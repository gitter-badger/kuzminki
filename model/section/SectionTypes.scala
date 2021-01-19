package kuzminki.model


trait NoRender {
  def render = expression
  def prefix(picker: Prefix) = expression
}

trait SingleArg extends Section with NoRender {
  def arg: Any
  def args = Seq(arg)
}

trait TextOnly extends Section with NoRender with NoArgs

trait SinglePart extends Section {
  val part: PrefixRender
  def render = expression.format(part.render)
  def prefix(picker: Prefix) = expression.format(part.prefix(picker))
  def args = part.args
}

trait MultiPart extends Section {
  val parts: Seq[PrefixRender]
  def glue: String
  def render = expression.format(parts.map(_.render).mkString(glue))
  def prefix(picker: Prefix) = expression.format(parts.map(_.prefix(picker)).mkString(glue))
  def args = parts.map(_.args).flatten
}

