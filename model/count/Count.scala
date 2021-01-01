package kuzminki.model.count

import kuzminki.model._


object Count {

  def from[M <: Model](model: M, db: Conn) = {
    new Where(
      model,
      Collector(
        db,
        Array(
          CountFromSec(ModelTable(model))
        )
      )
    )
  }

  def fromJoin[A <: Model, B <: Model](join: Join[A, B], db: Conn) = {
    new JoinOn(
      join,
      Collector(
        db,
        Array(
          CountFromSec(ModelTable(join.a))
        )
      )
    )
  }
}

class JoinOn[A <: Model, B <: Model](join: Join[A, B], coll: Collector) {

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

class Where[M <: Model](model: M, coll: Collector){

  def all() = new RunCount(coll)

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

class WhereJoin[A <: Model, B <: Model](join: Join[A, B], coll: Collector) {

  def all() = new RunCount(coll)

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


class RunCount(coll: Collector) extends Printing {

  def run() = {
    coll.db.selectHead(coll.statement) { row =>
      row.int("count")
    }
  }

  def render = coll.render
}


