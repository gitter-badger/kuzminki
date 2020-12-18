package kuzminki.model


trait Printing {
  
  val sections: ModelCollector

  def print: Unit = {
    println(sections.render + " - " + sections.args) 
  }

  def pretty: Unit = {
    println(sections.pretty + "\n" + sections.args)
  }
}