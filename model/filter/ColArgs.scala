package kuzminki.model


trait ColArgs {
  val col: AnyCol
  def args = col.args
}