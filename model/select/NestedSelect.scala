package kuzminki.model.select

import scala.reflect.ClassTag

case class NestedSelect[R](template: String, args: Seq[Any], tag: ClassTag[R])