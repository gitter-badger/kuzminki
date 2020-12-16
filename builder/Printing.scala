package kuzminki.builder


trait Printing {
  
  val sections: Collector

  def print: Unit = {
    sections.renderQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }

  def wrapped: Unit = {
    sections.wrappedQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + " - " + args) 
    }
  }

  def pretty: Unit = {
    sections.prettyQuery match {
      case QueryResult(tmpl, args) =>
        println(tmpl + "\n" + args) 
    }
  }
}