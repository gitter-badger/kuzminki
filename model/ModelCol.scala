package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


case class ColConf(name: String, model: Model)


trait ModelCol extends ModelRender {
  val name: String
  val model: Model

  def col = this
  def asc = ModelAsc(this)
  def desc = ModelDesc(this)

  def render = {
    model.__prefix match {
      case Some(prefix) => s"$prefix.$name"
      case None => name 
    }
  }
  def args = Seq.empty[Any]
}

trait TypedModelCol[T] extends ModelCol {
  def get(row: Row): T
}


case class StringCol(name: String, model: Model) extends TypedModelCol[String]
                                                    with UniversalFilters[String]
                                                    with StringFilters {

  def get(row: Row): String = row.str(name)
}
    
case class IntCol(name: String, model: Model) extends TypedModelCol[Int]
                                                 with UniversalFilters[Int]
                                                 with ComparativeFilters[Int] {
  def get(row: Row): Int = row.int(name)
}

case class BooleanCol(name: String, model: Model) extends TypedModelCol[Boolean] 
                                                     with UniversalFilters[Boolean]{

  def get(row: Row): Boolean = row.bool(name)
}

/*
case class CharCol(name: String)(implicit model: Model) extends ModelColumn[Char] {

  def get(row: Row): Char = row.char(name)
}

case class ShortCol(name: String)(implicit model: Model) extends ModelColumn[Short] {

  def get(row: Row): Short = row.short(name)
}

case class LongCol(name: String)(implicit model: Model) extends ModelColumn[Long] {

  def get(row: Row): Long = row.long(name)
}

case class BigDecimalCol(name: String)(implicit model: Model) extends ModelColumn[BigDecimal] {

  def get(row: Row): BigDecimal = row.bigDecimal(name)
}

case class DecimalNumberCol(name: String)(implicit model: Model) extends ModelColumn[DecimalNumber] {

  def get(row: Row): DecimalNumber = row.decimal(name)
}

case class DoubleCol(name: String)(implicit model: Model) extends ModelColumn[Double] {

  def get(row: Row): Double = row.double(name)
}

case class FloatCol(name: String)(implicit model: Model) extends ModelColumn[Float] {

  def get(row: Row): Float = row.float(name)
}

case class InstantCol(name: String)(implicit model: Model) extends ModelColumn[Instant] {

  def get(row: Row): Instant = row.instant(name)
}

case class ZonedDateTimeCol(name: String)(implicit model: Model) extends ModelColumn[ZonedDateTime] {

  def get(row: Row): ZonedDateTime = row.zonedDateTime(name)
}

case class LocalDateTimeCol(name: String)(implicit model: Model) extends ModelColumn[LocalDateTime] {

  def get(row: Row): LocalDateTime = row.localDateTime(name)
}

case class LocalDateCol(name: String)(implicit model: Model) extends ModelColumn[LocalDate] {

  def get(row: Row): LocalDate = row.localDate(name)
}

case class UUIDCol(name: String)(implicit model: Model) extends ModelColumn[UUID] {

  def get(row: Row): UUID = row.uuid(name)
}
*/






















