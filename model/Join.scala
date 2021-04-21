package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


trait Join[A <: Model, B <: Model] {
  val a: A
  val b: B
}

//object BasicJoin {
//  def apply[A <: Model, B <: Model](a: A, b: B) = new Join(a, b)
//}

case class DefaultJoin[A <: Model, B <: Model](a: A, b: B) extends Join[A, B]

trait ExtendedJoin[A <: Model, B <: Model] extends Join[A, B] with ModelRead