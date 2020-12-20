package kuzminki.model

import scala.reflect.ClassTag
import scala.concurrent.Future
import io.rdbc.sapi._
import kuzminki.model.select.Columns
import kuzminki.model.implicits._

/*
class DummyExecutor extends Executor {
  def run(template: String, args: Seq[Any]) = Future.successful(List.empty[Row])
}
*/

object ModelQuery {

  //val exec = new DummyExecutor()

  //def select[M <: Model](implicit tag: ClassTag[M]) = new Columns(Model.from[M], exec)

  //def select[M <: Model](cols: M => Seq[ModelCol])(implicit tag: ClassTag[M]): ModelSelectStages.Where[M] = {
  //  ModelSelect[M](Model.from[M], ModelCollector.init, exec).columns(cols)
  //}
  /*
  def select[A <: Model, B <: Model](cols: Join[A, B] => Seq[ModelCol])
                                    (implicit tagA: ClassTag[A], tagB: ClassTag[B]): ModelJoinStages.JoinOn[A, B] = {
    
    ModelJoin[A, B](Join(Model.from[A], Model.from[B]), ModelCollector.init).columns(cols)
  }
  */
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