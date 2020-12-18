package kuzminki.model

import scala.reflect.ClassTag
import scala.concurrent.Future
import io.rdbc.sapi._
import kuzminki.model.implicits._


class DummyExecutor extends Executor {
  def run(sections: ModelCollector) = Future.successful(List.empty[Seq[Any]])
}


object TupleCols {
  type ColTuple2 = Tuple2[ModelCol, ModelCol]
  type ColTuple3 = Tuple3[ModelCol, ModelCol, ModelCol]
  type ColTuple4 = Tuple4[ModelCol, ModelCol, ModelCol, ModelCol]
}

object TupledResult {

  import TupleCols._

  def get(col: StringCol, row: Row) = col.get(row)
  def get(col: IntCol, row: Row) = col.get(row)
  def get(col: BooleanCol, row: Row) = col.get(row)

  def tupleRow[A1, A2](row: Row, tup: Tuple2[TypedModelCol[A1], TypedModelCol[A2]]): Tuple2[A1, A2] = {
    tup match {
      case (col1, col2) => (col1.get(row), col2.get(row))
    }
  }

  def tupleRow[A1, A2, A3](row: Row, tup: Tuple3[TypedModelCol[A1], TypedModelCol[A2], TypedModelCol[A3]]): Tuple3[A1, A2, A3] = {
    tup match {
      case (col1, col2, col3) => (col1.get(row), col2.get(row), col3.get(row))
    }
  }

  def tupleRow[A1, A2, A3, A4](row: Row, tup: Tuple4[TypedModelCol[A1], TypedModelCol[A2], TypedModelCol[A3], TypedModelCol[A4]]): Tuple4[A1, A2, A3, A4] = {
    tup match {
      case (col1, col2, col3, col4) => (col1.get(row), col2.get(row), col3.get(row), col4.get(row))
    }
  }
}

object TupledCols {

  import TupleCols._

  def tuple2ToSeq(tup: ColTuple2) = {
    tup match {
      case (col1, col2) => Seq(col1, col2)
    }
  }

  def tuple3ToSeq(tup: ColTuple3) = {
    tup match {
      case (col1, col2, col3) => Seq(col1, col2, col3)
    }
  }

  def tuple4ToSeq(tup: ColTuple4) = {
    tup match {
      case (col1, col2, col3, col4) => Seq(col1, col2, col3, col4)
    }
  }
}


object ModelQuery {

  val exec = new DummyExecutor()

  def select[M <: Model](cols: M => Seq[ModelCol])(implicit tag: ClassTag[M]): ModelSelectStages.Where[M] = {
    ModelSelect[M](Model.from[M], ModelCollector.init, exec).columns(cols)
  }

  def select[A <: Model, B <: Model](cols: Join[A, B] => Seq[ModelCol])
                                    (implicit tagA: ClassTag[A], tagB: ClassTag[B]): ModelJoinStages.JoinOn[A, B] = {
    
    ModelJoin[A, B](Join(Model.from[A], Model.from[B]), ModelCollector.init).columns(cols)
  }
}

/*
class Users extends Model("users") {
  def name = column[String]("name")
  def email = column[String]("email")
  def age = column[Int]("age")
}


object Models {
  val user = Model.from[Users]
}
*/