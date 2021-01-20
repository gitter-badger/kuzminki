package kuzminki.model


trait ColArgs {
  val col: RenderableCol
  def args = col.args
}