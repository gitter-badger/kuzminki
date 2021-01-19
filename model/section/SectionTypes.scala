package kuzminki.model


trait NoRender extends Section {
  def render = expression
  def prefix(picker: Prefix) = expression
}

trait SingleArg extends NoRender {
  def arg: Any
  def args = Seq(arg)
}

trait TextOnly extends NoRender with NoArgs

trait SinglePart extends Section {
  val part: Renderable
  def render = expression.format(part.render)
  def prefix(picker: Prefix) = expression.format(part.prefix(picker))
  def args = part.args
}

trait MultiPart extends Section {
  val parts: Seq[Renderable]
  def glue: String
  def render = expression.format(parts.map(_.render).mkString(glue))
  def prefix(picker: Prefix) = expression.format(parts.map(_.prefix(picker)).mkString(glue))
  def args = parts.map(_.args).flatten
}

