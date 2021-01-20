package kuzminki.model.aggregate

import kuzminki.model._


class SubqueryNumber[M <: Model](model: M) {

  def cols1(pick: M => AggNumeric) = {
    new WhereSubqueryNumber(
      model,
      StandardSubCollector(
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










