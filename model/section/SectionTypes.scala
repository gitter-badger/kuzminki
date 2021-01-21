package kuzminki.model


trait NoRender extends Section {
  def render(picker: Prefix) = expression
}

trait SingleArg extends NoRender {
  def arg: Any
  def args = Seq(arg)
}

trait TextOnly extends NoRender with NoArgs

trait SingleRender extends Section {
  val part: Renderable
  def render(prefix: Prefix) = expression.format(part.render(prefix))
  def args = part.args
}

trait MultiRender extends Section {
  val parts: Seq[Renderable]
  def glue: String
  def render(prefix: Prefix) = expression.format(parts.map(_.render(prefix)).mkString(glue))
  def args = parts.map(_.args).flatten
}

// insert

trait FillValues {
  def fillNoBrackets(size: Int) = Vector.fill(size)("?").mkString(", ")
  def fillBrackets(size: Int) = "(%s)".format(fillNoBrackets(size))
}