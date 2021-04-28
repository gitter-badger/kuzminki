package kuzminki.model

import scala.reflect.{classTag, ClassTag}


class ParamShapeWrite[P](val cols: Seq[TypeCol[_]], tag: ClassTag[P]) extends ParamShape[P] {
  def size = cols.size
  def conv = new ParamConvWrite(tag) 
}