package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import kuzminki.builder._
import kuzminki.model.implicits._


object ModelQuery {

  def select[M <: Model](cols: M => Seq[ModelCol])(implicit tag: ClassTag[M]): ModelSelectStages.Where[M] = {
    ModelSelect[M](Model.from[M], Collector.init).columns(cols)
  }
}

/*
class Users extends Model("users") {
  def name = column[String]("name")
  def email = column[String]("email")
  def age = column[Int]("age")
}


object Models {
  val user = Model.from[Users]
}
*/