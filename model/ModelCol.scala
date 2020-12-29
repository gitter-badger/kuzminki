package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class ColConf(name: String, model: Model)

trait ModelCol extends Render {
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

trait TypeCol[T] extends ModelCol {
  def get(row: Row): T
}


case class StringCol(name: String, model: Model) extends TypeCol[String]
                                                    with UniversalFilters[String]
                                                    with StringFilters {

  def get(row: Row): String = row.str(name)
}


case class IntCol(name: String, model: Model) extends TypeCol[Int]
                                                 with UniversalFilters[Int]
                                                 with ComparativeFilters[Int]
                                                 with IncrementUpdate[Int] {
  def get(row: Row): Int = row.int(name)
}


case class BooleanCol(name: String, model: Model) extends TypeCol[Boolean] 
                                                     with UniversalFilters[Boolean]{

  def get(row: Row): Boolean = row.bool(name)
}


case class CharCol(name: String, model: Model) extends TypeCol[Char]
                                                           with UniversalFilters[Char] {

  def get(row: Row): Char = row.char(name)
}


case class ShortCol(name: String, model: Model) extends TypeCol[Short]
                                                            with UniversalFilters[Short]
                                                            with ComparativeFilters[Short]
                                                            with IncrementUpdate[Short] {

  def get(row: Row): Short = row.short(name)
}


case class LongCol(name: String, model: Model) extends TypeCol[Long]
                                                           with UniversalFilters[Long]
                                                           with ComparativeFilters[Long]
                                                           with IncrementUpdate[Long] {

  def get(row: Row): Long = row.long(name)
}


case class BigDecimalCol(name: String, model: Model) extends TypeCol[BigDecimal]
                                                                 with UniversalFilters[BigDecimal]
                                                                 with ComparativeFilters[BigDecimal]
                                                                 with IncrementUpdate[BigDecimal] {

  def get(row: Row): BigDecimal = row.bigDecimal(name)
}


case class DecimalNumberCol(name: String, model: Model) extends TypeCol[DecimalNumber]
                                                                    with UniversalFilters[DecimalNumber]
                                                                    with ComparativeFilters[DecimalNumber]
                                                                    with IncrementUpdate[DecimalNumber] {

  def get(row: Row): DecimalNumber = row.decimal(name)
}


case class DoubleCol(name: String, model: Model) extends TypeCol[Double]
                                                             with UniversalFilters[Double]
                                                             with ComparativeFilters[Double]
                                                             with IncrementUpdate[Double] {

  def get(row: Row): Double = row.double(name)
}


case class FloatCol(name: String, model: Model) extends TypeCol[Float]
                                                            with UniversalFilters[Float]
                                                            with ComparativeFilters[Float]
                                                            with IncrementUpdate[Float] {

  def get(row: Row): Float = row.float(name)
}


case class InstantCol(name: String, model: Model) extends TypeCol[Instant]
                                                              with UniversalFilters[Instant] {

  def get(row: Row): Instant = row.instant(name)
}


case class ZonedDateTimeCol(name: String, model: Model) extends TypeCol[ZonedDateTime]
                                                                    with UniversalFilters[ZonedDateTime]
                                                                    with ComparativeFilters[ZonedDateTime] {

  def get(row: Row): ZonedDateTime = row.zonedDateTime(name)
}


case class LocalDateTimeCol(name: String, model: Model) extends TypeCol[LocalDateTime]
                                                                    with UniversalFilters[LocalDateTime]
                                                                    with ComparativeFilters[LocalDateTime] {

  def get(row: Row): LocalDateTime = row.localDateTime(name)
}


case class LocalDateCol(name: String, model: Model) extends TypeCol[LocalDate]
                                                                with UniversalFilters[LocalDate]
                                                                with ComparativeFilters[LocalDate] {

  def get(row: Row): LocalDate = row.localDate(name)
}


case class UUIDCol(name: String, model: Model) extends TypeCol[UUID]
                                                           with UniversalFilters[UUID]
                                                           with ComparativeFilters[UUID] {

  def get(row: Row): UUID = row.uuid(name)
}























