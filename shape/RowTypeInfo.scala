package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._

case class RowTypeInfo[T](cols: Seq[TypeCol[_]], cTag: ClassTag[T], tTag: TypeTag[T])