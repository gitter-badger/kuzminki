package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi.{Row, DecimalNumber}


object StringConv extends ValConv[String] {
  def get(row: Row, index: Int) = row.col[String](index)
}

object CharConv extends ValConv[Char] {
  def get(row: Row, index: Int) = row.col[Char](index)
}

object BooleanConv extends ValConv[Boolean] {
  def get(row: Row, index: Int) = row.col[Boolean](index)
}

object ShortConv extends ValConv[Short] {
  def get(row: Row, index: Int) = row.col[Short](index)
}

object IntConv extends ValConv[Int] {
  def get(row: Row, index: Int) = row.col[Int](index)
}

object LongConv extends ValConv[Long] {
  def get(row: Row, index: Int) = row.col[Long](index)
}

object FloatConv extends ValConv[Float] {
  def get(row: Row, index: Int) = row.col[Float](index)
}

object DoubleConv extends ValConv[Double] {
  def get(row: Row, index: Int) = row.col[Double](index)
}

object DecimalNumberConv extends ValConv[DecimalNumber] {
  def get(row: Row, index: Int) = row.col[DecimalNumber](index)
}

object BigDecimalConv extends ValConv[BigDecimal] {
  def get(row: Row, index: Int) = row.col[BigDecimal](index)
}

object InstantConv extends ValConv[Instant] {
  def get(row: Row, index: Int) = row.col[Instant](index)
}

object ZonedDateTimeConv extends ValConv[ZonedDateTime] {
  def get(row: Row, index: Int) = row.col[ZonedDateTime](index)
}

object LocalDateTimeConv extends ValConv[LocalDateTime] {
  def get(row: Row, index: Int) = row.col[LocalDateTime](index)
}

object LocalDateConv extends ValConv[LocalDate] {
  def get(row: Row, index: Int) = row.col[LocalDate](index)
}

object UUIDConv extends ValConv[UUID] {
  def get(row: Row, index: Int) = row.col[UUID](index)
}









