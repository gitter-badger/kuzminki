package kuzminki.model


trait Printing {
  
  def render: String

  def renderTo(printer: String => Unit): Unit = {
    printer(render)
  }
}
