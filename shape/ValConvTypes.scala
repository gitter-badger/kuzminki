package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi.{Row, DecimalNumber}


object SpecialConv {
  
  val toChar: String => Char = {
    case str: String if str.size == 0 => str.charAt(0)
    case str: String => throw KuzminkiException(s"Cannot be converted to char: $str")
  }

  val toCharOpt: Option[String] => Option[Char] = {
    case Some(str) => Some(toChar(str))
    case None => None
  }
}

object StringConv extends ValConv[String] {
  def get(row: Row, index: Int) = row.col[String](index)
}

object CharConv extends ValConv[Char] {
  def get(row: Row, index: Int) = SpecialConv.toChar(row.col[String](index))
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

// option

object StringOptConv extends ValConv[Option[String]] {
  def get(row: Row, index: Int) = row.colOpt[String](index)
}

object CharOptConv extends ValConv[Option[Char]] {
  def get(row: Row, index: Int) = SpecialConv.toCharOpt(row.colOpt[String](index))
}

object BooleanOptConv extends ValConv[Option[Boolean]] {
  def get(row: Row, index: Int) = row.colOpt[Boolean](index)
}

object ShortOptConv extends ValConv[Option[Short]] {
  def get(row: Row, index: Int) = row.colOpt[Short](index)
}

object IntOptConv extends ValConv[Option[Int]] {
  def get(row: Row, index: Int) = row.colOpt[Int](index)
}

object LongOptConv extends ValConv[Option[Long]] {
  def get(row: Row, index: Int) = row.colOpt[Long](index)
}

object FloatOptConv extends ValConv[Option[Float]] {
  def get(row: Row, index: Int) = row.colOpt[Float](index)
}

object DoubleOptConv extends ValConv[Option[Double]] {
  def get(row: Row, index: Int) = row.colOpt[Double](index)
}

object DecimalNumberOptConv extends ValConv[Option[DecimalNumber]] {
  def get(row: Row, index: Int) = row.colOpt[DecimalNumber](index)
}

object BigDecimalOptConv extends ValConv[Option[BigDecimal]] {
  def get(row: Row, index: Int) = row.colOpt[BigDecimal](index)
}

object InstantOptConv extends ValConv[Option[Instant]] {
  def get(row: Row, index: Int) = row.colOpt[Instant](index)
}

object ZonedDateTimeOptConv extends ValConv[Option[ZonedDateTime]] {
  def get(row: Row, index: Int) = row.colOpt[ZonedDateTime](index)
}

object LocalDateTimeOptConv extends ValConv[Option[LocalDateTime]] {
  def get(row: Row, index: Int) = row.colOpt[LocalDateTime](index)
}

object LocalDateOptConv extends ValConv[Option[LocalDate]] {
  def get(row: Row, index: Int) = row.colOpt[LocalDate](index)
}

object UUIDOptConv extends ValConv[Option[UUID]] {
  def get(row: Row, index: Int) = row.colOpt[UUID](index)
}






