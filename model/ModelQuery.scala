package kuzminki.model

import scala.reflect.ClassTag
import kuzminki.model.implicits._


object ModelQuery {

  def select[M <: Model](cols: M => Seq[ModelCol])(implicit tag: ClassTag[M]): ModelSelectStages.Where[M] = {
    ModelSelect[M](Model.from[M], ModelCollector.init).columns(cols)
  }

  def select[A <: Model, B <: Model](cols: Join[A, B] => Seq[ModelCol])
                                    (implicit tagA: ClassTag[A], tagB: ClassTag[B]): ModelJoinStages.JoinOn[A, B] = {
    
    ModelJoin[A, B](Join(Model.from[A], Model.from[B]), ModelCollector.init).columns(cols)
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