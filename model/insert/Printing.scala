package kuzminki.model.insert


trait Printing {
  
  protected def render: String

  def renderTo(printer: String => Unit): Unit = {
    printer(render)
  }
}
