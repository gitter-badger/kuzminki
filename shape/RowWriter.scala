package kuzminki.model


object RowWriter extends RowTypeNames {

  def create[T](rti: RowTypeInfo[T]) = {
    validate(rti)
    new ParamShapeWrite(rti.cols, rti.cTag)
  }
}


