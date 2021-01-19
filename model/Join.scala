package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


trait Join[A <: Model, B <: Model] {
  val a: A
  val b: B
}

abstract class JoinTypes[A <: Model, B <: Model](implicit aTag: ClassTag[A], bTag: ClassTag[B]) extends Join[A, B] with ModelRead {
  val a = Model.from[A]
  val b = Model.from[B]
}

abstract class JoinModels[A <: Model, B <: Model](val a: A, val b: B) extends Join[A, B] with ModelRead

class AnyJoin[A <: Model, B <: Model](val a: A, val b: B) extends Join[A, B]