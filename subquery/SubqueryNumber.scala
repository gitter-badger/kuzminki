package kuzminki.model


class SubqueryNumber[M <: Model](model: M) {

  def cols1(pick: M => AggNumeric) = {
    new WhereSubqueryNumber(
      model,
      SubCollector(
        Prefix.forModel,
        Array(
          SelectSec(
            Seq(pick(model))
          ),
          FromSec(ModelTable(model))
        )
      )
    )
  }
}










