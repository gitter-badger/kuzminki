package kuzminki.model.operation

import kuzminki.model._


class Changes[M <: Model](model: M, conn: Connection) {

  def set(pick: M => Seq[Modification]) = {
    new Where(
      Collector.forUpdate(
        model,
        pick(model),
        conn
      )
    )
  }
}


class Where[M <: Model](coll: OperationCollector[M]){

  def whereAll(pick: M => Seq[ModelFilter]) = {
    new Returning(
      coll.add(
        WhereAllSec(pick(coll.model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[ModelFilter]]) = {
    new Returning(
      coll.add(
        WhereAllSec(pick(coll.model).flatten)
      )
    )
  }

  def whereOne(pick: M => ModelFilter) = {
    new Returning(
      coll.add(
        WhereAllSec(
          Seq(pick(coll.model))
        )
      )
    )
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new Returning(
      coll.add(
        WhereChainSec(pick(ChainStart(coll.model)).filters)
      )
    )
  }
}




















