package kuzminki.model.insert


trait Printing {
  
  protected def sql: String

  def renderTo(printer: String => Unit): Unit = {
    printer(sql)
  }
}
