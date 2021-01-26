package kuzminki.model


trait InsertPrinting {
  
  protected val template: String

  def render = template

  def renderTo(printer: String => Unit): Unit = {
    printer(template)
  }
}