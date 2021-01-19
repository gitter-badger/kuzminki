package kuzminki.model


trait Join[A <: Model, B <: Model] {
  val a: A
  val b: B
}

trait JoinTypes[A <: Model, B <: Model] extends Join[A, B] with ModelRead {
  val a = Model.from[A]
  val b = Model.from[B]
}

abstract class JoinModels[A <: Model, B <: Model](a: A, b: B) extends Join[A, B] with ModelRead

class AnyJoin[A, B] extends JoinTypes[A, B]