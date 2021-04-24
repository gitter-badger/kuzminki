package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi.DecimalNumber


trait TypeCol[T] extends AnyCol {
  def conv: ValConv[T]
}

trait StringColValue extends TypeCol[String] {
  def conv = StringConv
}

trait CharColValue extends TypeCol[Char] {
  def conv = CharConv
}

trait BooleanColValue extends TypeCol[Boolean] {
  def conv = BooleanConv
}

trait ShortColValue extends TypeCol[Short] {
  def conv = ShortConv
}

trait IntColValue extends TypeCol[Int] {
  def conv = IntConv
}

trait LongColValue extends TypeCol[Long] {
  def conv = LongConv
}

trait FloatColValue extends TypeCol[Float] {
  def conv = FloatConv
}

trait DoubleColValue extends TypeCol[Double] {
  def conv = DoubleConv
}

trait DecimalNumberColValue extends TypeCol[DecimalNumber] {
  def conv = DecimalNumberConv
}

trait BigDecimalColValue extends TypeCol[BigDecimal] {
  def conv = BigDecimalConv
}

trait InstantColValue extends TypeCol[Instant] {
  def conv = InstantConv
}

trait ZonedDateTimeColValue extends TypeCol[ZonedDateTime] {
  def conv = ZonedDateTimeConv
}

trait LocalDateTimeColValue extends TypeCol[LocalDateTime] {
  def conv = LocalDateTimeConv
}

trait LocalDateColValue extends TypeCol[LocalDate] {
  def conv = LocalDateConv
}

trait UUIDColValue extends TypeCol[UUID] {
  def conv = UUIDConv
}























