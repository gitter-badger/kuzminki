package kuzminki.model.count

import kuzminki.model._


object Count {

  def from[M <: Model](model: M, conn: Connection) = {
    new Where(
      model,
      CountCollector(
        conn,
        Array(
          CountFromSec(ModelTable(model))
        )
      )
    )
  }

  def fromJoin[A <: Model, B <: Model](join: Join[A, B], conn: Connection) = {
    new JoinOn(
      join,
      CountCollector(
        conn,
        Array(
          CountFromSec(ModelTable(join.a))
        )
      )
    )
  }
}

class JoinOn[A <: Model, B <: Model](join: Join[A, B], coll: CountCollector) {

  def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
    new WhereJoin(
      join,
      coll.extend(Array(
        InnerJoinSec(ModelTable(join.b)),
        OnSec(pickLeft(join.a), pickRight(join.b))
      ))
    )
  }
}

class Where[M <: Model](model: M, coll: CountCollector){

  def whereAll(pick: M => Seq[Filter]) = {
    new RunCount(
      coll.add(
        WhereAllSec(pick(model))
      )
    )
  }

  def whereOpt(pick: M => Seq[Option[Filter]]) = {
    new RunCount(
      coll.add(
        WhereAllSec(pick(model).flatten)
      )
    )
  }

  def whereOne(pick: M => Filter) = {
    new RunCount(
      coll.add(
        WhereAllSec(
          Seq(pick(model))
        )
      )
    )
  }

  def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
    new RunCount(
      coll.add(
        WhereChainSec(pick(ChainStart(model)).filters)
      )
    )
  }
}

class WhereJoin[A <: Model, B <: Model](join: Join[A, B], coll: CountCollector) {

  def whereAll(pick: Join[A, B] => Seq[Filter]) = {
    new RunCount(
      coll.add(
        WhereAllSec(pick(join))
      )
    )
  }

  def whereOpt(pick: Join[A, B] => Seq[Option[Filter]]) = {
    new RunCount(
      coll.add(
        WhereAllSec(pick(join).flatten)
      )
    )
  }

  def whereOne(pick: Join[A, B] => Filter) = {
    new RunCount(
      coll.add(
        WhereAllSec(
          Seq(pick(join))
        )
      )
    )
  }

  def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
    new RunCount(
      coll.add(
        WhereChainSec(pick(JoinChainStart(join)).filters)
      )
    )
  }
}


class RunCount[M <: Model](coll: CountCollector) extends Printing {

  def run = coll.executor
  def render = coll.render
}


