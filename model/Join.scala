package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import scala.annotation.tailrec


sealed trait CustomJoin

trait Join[A <: Model, B <: Model] {
  val a: A
  val b: B
}

object Join {

  import scala.collection.mutable.Map

  def default[A <: Model, B <: Model](implicit tagA: ClassTag[A], tagB: ClassTag[B]) = {
   DefaultJoin(Model.get[A], Model.get[B])
  }

  private var stored = Set.empty[CustomJoin]

  private def find[J <: CustomJoin](implicit tag: ClassTag[J]): Option[J] = {
    
    @tailrec
    def loop(instances: List[CustomJoin]): Option[J] = {
      instances match {
        case Nil => None
        case head :: tail => 
          head match {
            case join: J => Some(join)
            case _ => loop(tail)
          }
      }
    }

    loop(stored.toList)
  }

  def get[J <: CustomJoin](implicit tag: ClassTag[J]): J = {
    find[J] match {
      case Some(join) =>
        join
      case None =>
        val join = noCache[J]
        stored = stored + join
        join
    }
  }

  def register[J <: CustomJoin, A <: Model, B <: Model](implicit tag: ClassTag[J]): Join[A, B] => J = {
    val join = get[J]
    val conv: Join[A, B] => J = _ => join
    conv
  }
  
  def noCache[J <: CustomJoin](implicit tag: ClassTag[J]): J = {
    tag.runtimeClass.newInstance.asInstanceOf[J]
  }
}

case class DefaultJoin[A <: Model, B <: Model](a: A, b: B) extends Join[A, B]

abstract class ExtendedJoin[A <: Model, B <: Model](
      implicit tagA: ClassTag[A],
               tagB: ClassTag[B]
    ) extends Join[A, B]
      with CustomJoin
      with ModelRead {

  val a = Model.get[A]
  val b = Model.get[B]
}

















