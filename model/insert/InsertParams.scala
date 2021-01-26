package kuzminki.model


trait InsertParams[P] {
 
  protected val paramConv: ParamConv[P]
  
  protected def tansformParams(params: P) = {
    paramConv.fromShape(params)
  }
}