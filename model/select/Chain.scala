package kuzminki.model.select


import kuzminki.model._

object standard {

  class Where[M <: Model](coll: SeqCollector[M]) {

    def where(pick: M => Seq[ModelFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.model))
        )
      )
    }
  }

  class OrderBy[M <: Model](coll: SeqCollector[M]) extends Offset[M](coll) {

    def orderBy(pick: M => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.model))
        )
      )
    }
  }

  class Offset[M <: Model](coll: SeqCollector[M]) extends Limit[M](coll) {

    def limit(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[M <: Model](coll: SeqCollector[M]) extends Run[M](coll) {

    def offset(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }

  class Run[M <: Model](coll: SeqCollector[M]) {

    def run = coll.executor
  }
}

// join

object standardJoin {

  class Where[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) {

    def where(pick: Join[A, B] => Seq[ModelFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.join))
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
  }

  class Offset[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Limit(coll) {

    def limit(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) extends Run(coll) {

    def offset(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }

  class Run[A <: Model, B <: Model](coll: SeqJoinCollector[A, B]) {

    def run = coll.executor
  }
}

// tupled

object tupled {

  class Where[M <: Model, R](coll: TupleCollector[M, R]) {

    def where(pick: M => Seq[ModelFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.model))
        )
      )
    }
  }


  class OrderBy[M <: Model, R](coll: TupleCollector[M, R]) extends Offset[M, R](coll) {

    def orderBy(pick: M => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.model))
        )
      )
    }
  }


  class Offset[M <: Model, R](coll: TupleCollector[M, R]) extends Limit[M, R](coll) {

    def limit(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }


  class Limit[M <: Model, R](coll: TupleCollector[M, R]) extends Run[M, R](coll) {

    def offset(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }


  class Run[T <: Model, R](coll: TupleCollector[T, R]) {

    def run = coll.executor
  }
}

// tupled join

object tupledJoin {

  class Where[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) {

    def where(pick: Join[A, B] => Seq[ModelFilter]) = {
      new OrderBy(
        coll.add(
          WhereAllSec(pick(coll.join))
        )
      )
    }
  }

  class OrderBy[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Offset[A, B, R](coll) {

    def orderBy(pick: Join[A, B] => Seq[ModelSorting]) = {
      new Offset(
        coll.add(
          OrderBySec(pick(coll.join))
        )
      )
    }
  }

  class Offset[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Limit[A, B, R](coll) {

    def limit(num: Int) = {
      new Limit(
        coll.add(
          OffsetSec(num)
        )
      )
    }
  }

  class Limit[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) extends Run[A, B, R](coll) {

    def offset(num: Int) = {
      new Run(
        coll.add(
          LimitSec(num)
        )
      )
    }
  }

  class Run[A <: Model, B <: Model, R](coll: TupleJoinCollector[A, B, R]) {

    def run = coll.executor
  }
}




