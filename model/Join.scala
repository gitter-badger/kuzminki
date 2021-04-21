package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


object Join {
  def apply[A <: Model, B <: Model](a: A, b: B) = new Join(a, b)
}

class Join[A <: Model, B <: Model](val a: A, val b: B)

abstract class JoinRead[A <: Model, B <: Model](join: Join[A, B]) extends ModelRead {
  val a = join.a
  val b = join.b
}