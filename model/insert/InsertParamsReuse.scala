package kuzminki.model


trait InsertParamsReuse[P] {
  
  protected val paramConv: ParamConv[P]
  protected val reuse: Reuse
  
  protected def tansformParams(params: P) = {
    reuse.extend(
      paramConv.fromShape(params)
    )
  }
}