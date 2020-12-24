package kuzminki.model.select

import kuzminki.model._


object standard {

  class Where[M <: Model](coll: SeqCollector[M]) extends OrderBy(coll) {

    def where(pick: M => Seq[OptionalFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.model))
        )
      )
    }

    def whereOne(pick: M => OptionalFilter) = {
      new OrderBy(
        coll.add(
          WhereAllSec(
            Seq(pick(coll.model))
          )
        )
      )
    }

    def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
      new OrderBy(
        coll.add(
          WhereChainSec(pick(ChainStart(coll.model)).filters)
        )
      )
    }
  }

  class OrderBy[M <: Model](coll: SeqCollector[M]) extends Offset(coll) {

    def orderBy(pick: M => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.model))
        )
      )
    }

    def orderByOne(pick: M => ModelSorting) = {
      new Offset(
        coll.add(
          OrderBySec(
            Seq(pick(coll.model))
          )
        )
      )
    }
  }

  class Offset[M <: Model](coll: SeqCollector[M]) extends Limit(coll) {

    def offset(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[M <: Model](coll: SeqCollector[M]) extends Run(coll) {

    def limit(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }

  class Run[M <: Model](coll: SeqCollector[M]) extends Printing {

    def run = coll.executor
    def render = coll.render
  }
}

// join

object standardJoin {

  class JoinOn[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) {

    def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
      new Where(
        coll.add(
          InnerJoinSec(ModelTable(coll.join.b))
        ).add(
          OnSec(pickLeft(coll.join.a), pickRight(coll.join.b))
        )
      )
    }
  }

  class Where[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends OrderBy(coll) {

    def where(pick: Join[A, B] => Seq[OptionalFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.join))
        )
      )
    }

    def whereOne(pick: Join[A, B] => OptionalFilter) = {
      new OrderBy(
        coll.add(
          WhereAllSec(
            Seq(pick(coll.join))
          )
        )
      )
    }

    def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
      new OrderBy(
        coll.add(
          WhereChainSec(pick(JoinChainStart(coll.join)).filters)
        )
      )
    }
  }

  class OrderBy[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Offset(coll) {

    def orderBy(pick: Join[A, B] => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.join))
        )
      )
    }

    def orderByOne(pick: Join[A, B] => ModelSorting) = {
      new Offset(
        coll.add(
          OrderBySec(
            Seq(pick(coll.join))
          )
        )
      )
    }
  }

  class Offset[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Limit(coll) {

    def offset(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Run(coll) {

    def limit(num: Int) = {
      new Run(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Run[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Printing {

    def run = coll.executor
    def render = coll.render
  }
}

// tupled

object tupled {

  class Where[M <: Model, R](coll: TupleCollector[M, R]) extends OrderBy(coll) {

    def where(pick: M => Seq[OptionalFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.model))
        )
      )
    }

    def whereOne(pick: M => OptionalFilter) = {
      new OrderBy(
        coll.add(
          WhereAllSec(
            Seq(pick(coll.model))
          )
        )
      )
    }

    def whereChain(pick: ChainStart[M] => FilteringChain[M]) = {
      new OrderBy(
        coll.add(
          WhereChainSec(pick(ChainStart(coll.model)).filters)
        )
      )
    }
  }


  class OrderBy[M <: Model, R](coll: TupleCollector[M, R]) extends Offset(coll) {

    def orderBy(pick: M => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.model))
        )
      )
    }

    def orderByOne(pick: M => ModelSorting) = {
      new Offset(
        coll.add(
          OrderBySec(
            Seq(pick(coll.model))
          )
        )
      )
    }
  }


  class Offset[M <: Model, R](coll: TupleCollector[M, R]) extends Limit(coll) {

    def offset(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }


  class Limit[M <: Model, R](coll: TupleCollector[M, R]) extends Run(coll) {

    def limit(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }


  class Run[T <: Model, R](coll: TupleCollector[T, R]) extends Printing {

    def run = coll.executor
    def render = coll.render
  }
}

// tupled join

object tupledJoin {

  class JoinOn[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) {

    def joinOn(pickLeft: A => ModelCol, pickRight: B => ModelCol) = {
      new Where(
        coll.add(
          InnerJoinSec(ModelTable(coll.join.b))
        ).add(
          OnSec(pickLeft(coll.join.a), pickRight(coll.join.b))
        )
      )
    }
  }

  class Where[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends OrderBy(coll) {

    def where(pick: Join[A, B] => Seq[OptionalFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.join))
        )
      )
    }

    def whereOne(pick: Join[A, B] => OptionalFilter) = {
      new OrderBy(
        coll.add(
          WhereAllSec(
            Seq(pick(coll.join))
          )
        )
      )
    }

    def whereChain(pick: JoinChainStart[A, B] => JoinFilteringChain[A, B]) = {
      new OrderBy(
        coll.add(
          WhereChainSec(pick(JoinChainStart(coll.join)).filters)
        )
      )
    }
  }

  class OrderBy[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Offset(coll) {

    def orderBy(pick: Join[A, B] => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.join))
        )
      )
    }

    def orderByOne(pick: Join[A, B] => ModelSorting) = {
      new Offset(
        coll.add(
          OrderBySec(
            Seq(pick(coll.join))
          )
        )
      )
    }
  }

  class Offset[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Limit(coll) {

    def offset(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Run(coll) {

    def limit(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }

  class Run[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Printing {

    def run = coll.executor
    def render = coll.render
  }

}




