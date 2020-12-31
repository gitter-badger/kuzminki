package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class ColConf(name: String, model: Model)

trait ModelCol extends Render


trait TypeCol[T] extends ModelCol {
  def get(row: Row, index: Int): T
}

trait StringColValue extends TypeCol[String] {
  def get(row: Row, index: Int) = row.str(index)
}

trait BooleanColValue extends TypeCol[Boolean] {
  def get(row: Row, index: Int) = row.bool(index)
}

trait ShortColValue extends TypeCol[Short] {
  def get(row: Row, index: Int) = row.short(index)
}

trait IntColValue extends TypeCol[Int] {
  def get(row: Row, index: Int) = row.int(index)
}

trait LongColValue extends TypeCol[Long] {
  def get(row: Row, index: Int) = row.long(index)
}

trait FloatColValue extends TypeCol[Float] {
  def get(row: Row, index: Int) = row.float(index)
}

trait DoubleColValue extends TypeCol[Double] {
  def get(row: Row, index: Int) = row.double(index)
}

trait DecimalNumberColValue extends TypeCol[DecimalNumber] {
  def get(row: Row, index: Int) = row.decimal(index)
}

trait BigDecimalColValue extends TypeCol[BigDecimal] {
  def get(row: Row, index: Int) = row.bigDecimal(index)
}


trait SortingCol {
  def asc: Asc
  def desc: Desc
}


trait RealCol extends ModelCol with SortingCol {
  val name: String
  val model: Model

  def col = this
  def asc = Asc(this)
  def desc = Desc(this)

  def render = {
    model.__prefix match {
      case Some(prefix) => "%s.%s".format(wrap(prefix), wrap(name))
      case None => wrap(name) 
    }
  }

  def args = Seq.empty[Any]
}


trait AggCol {
  def sum = Agg.sum(this)
  def avg = Agg.avg(this)
  def max = Agg.max(this)
  def min = Agg.min(this)
}


case class StringCol(name: String, model: Model) extends RealCol
                                                    with StringColValue
                                                    with UniversalFilters[String]
                                                    with StringFilters


case class BooleanCol(name: String, model: Model) extends RealCol
                                                     with BooleanColValue
                                                     with UniversalFilters[Boolean]


case class ShortCol(name: String, model: Model) extends RealCol
                                                   with ShortColValue
                                                   with UniversalFilters[Short]
                                                   with ComparativeFilters[Short]
                                                   with IncrementUpdate[Short]


case class IntCol(name: String, model: Model) extends RealCol
                                                 with IntColValue
                                                 with AggCol
                                                 with UniversalFilters[Int]
                                                 with ComparativeFilters[Int]
                                                 with IncrementUpdate[Int]


case class LongCol(name: String, model: Model) extends RealCol
                                                  with LongColValue
                                                  with AggCol
                                                  with UniversalFilters[Long]
                                                  with ComparativeFilters[Long]
                                                  with IncrementUpdate[Long]


case class FloatCol(name: String, model: Model) extends RealCol
                                                   with FloatColValue
                                                   with AggCol
                                                   with UniversalFilters[Float]
                                                   with ComparativeFilters[Float]
                                                   with IncrementUpdate[Float]


case class DoubleCol(name: String, model: Model) extends RealCol
                                                    with DoubleColValue
                                                    with AggCol
                                                    with UniversalFilters[Double]
                                                    with ComparativeFilters[Double]
                                                    with IncrementUpdate[Double]


case class DecimalNumberCol(name: String, model: Model) extends RealCol
                                                           with DecimalNumberColValue
                                                           with AggCol
                                                           with TypeCol[DecimalNumber]
                                                           with UniversalFilters[DecimalNumber]
                                                           with ComparativeFilters[DecimalNumber]
                                                           with IncrementUpdate[DecimalNumber]


case class BigDecimalCol(name: String, model: Model) extends RealCol
                                                        with BigDecimalColValue
                                                        with AggCol
                                                        with TypeCol[BigDecimal]
                                                        with UniversalFilters[BigDecimal]
                                                        with ComparativeFilters[BigDecimal]
                                                        with IncrementUpdate[BigDecimal]

/*
case class CharCol(name: String, model: Model) extends ModelCol
                                                  with TypeCol[Char]
                                                  with UniversalFilters[Char] {

  def get(row: Row): Char = row.char(name)
}


case class InstantCol(name: String, model: Model) extends ModelCol
                                                     with TypeCol[Instant]
                                                     with UniversalFilters[Instant] {

  def get(row: Row): Instant = row.instant(name)
}


case class ZonedDateTimeCol(name: String, model: Model) extends ModelCol
                                                           with TypeCol[ZonedDateTime]
                                                           with UniversalFilters[ZonedDateTime]
                                                           with ComparativeFilters[ZonedDateTime] {

  def get(row: Row): ZonedDateTime = row.zonedDateTime(name)
}


case class LocalDateTimeCol(name: String, model: Model) extends ModelCol
                                                           with TypeCol[LocalDateTime]
                                                           with UniversalFilters[LocalDateTime]
                                                           with ComparativeFilters[LocalDateTime] {

  def get(row: Row): LocalDateTime = row.localDateTime(name)
}


case class LocalDateCol(name: String, model: Model) extends ModelCol
                                                       with TypeCol[LocalDate]
                                                       with UniversalFilters[LocalDate]
                                                       with ComparativeFilters[LocalDate] {

  def get(row: Row): LocalDate = row.localDate(name)
}


case class UUIDCol(name: String, model: Model) extends ModelCol
                                                  with TypeCol[UUID]
                                                  with UniversalFilters[UUID]
                                                  with ComparativeFilters[UUID] {

  def get(row: Row): UUID = row.uuid(name)
}
*/





















