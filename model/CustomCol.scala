/*package kuzminki.model

import io.rdbc.sapi._

trait CustomCol extends AnyCol {
  val arg: Any
  def render = "?"
  def args = Seq(arg)
}


case class CustomString(arg: String) extends CustomCol
                                        with TypeCol[String] {

  def get(row: Row) = arg
}


case class CustomInt(arg: Int) extends CustomCol
                                        with TypeCol[Int] {

  def get(row: Row) = arg
}


case class CustomLong(arg: Long) extends CustomCol
                                        with TypeCol[Long] {

  def get(row: Row) = arg
}


case class CustomBoolean(arg: Boolean) extends CustomCol
                                        with TypeCol[Boolean] {

  def get(row: Row) = arg
}
*/