package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import scala.annotation.tailrec


object Model {

  import scala.collection.mutable.Map

  private var stored = Set.empty[Model]

  private def find[M <: Model](implicit tag: ClassTag[M]): Option[M] = {
    
    @tailrec
    def loop(instances: List[Model]): Option[M] = {
      instances match {
        case Nil => None
        case head :: tail => 
          head match {
            case model: M => Some(model)
            case _ => loop(tail)
          }
      }
    }

    loop(stored.toList)
  }

  def get[M <: Model](implicit tag: ClassTag[M]): M = {
    find[M] match {
      case Some(model) =>
        model
      case None =>
        val model = noCache[M]
        stored = stored + model
        model 
    }
  }

  def register[M <: Model](implicit tag: ClassTag[M]): Unit = {
    find[M] match {
      case Some(model) =>
      case None =>
        stored = stored + noCache[M]
    }
  }
  
  def noCache[M <: Model](implicit tag: ClassTag[M]): M = {
    tag.runtimeClass.newInstance.asInstanceOf[M]
  }
}

abstract class Model(val __name: String) extends ModelRead {

  def column[T](name: String)(implicit creator: ColInfo => TypeCol[T]) = {
    creator(ColInfo(name, __name))
  }
}


















