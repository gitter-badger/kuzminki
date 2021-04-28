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

// option

trait StringOptColValue extends TypeCol[Option[String]] {
  def conv = StringOptConv
}

trait CharOptColValue extends TypeCol[Option[Char]] {
  def conv = CharOptConv
}

trait BooleanOptColValue extends TypeCol[Option[Boolean]] {
  def conv = BooleanOptConv
}

trait ShortOptColValue extends TypeCol[Option[Short]] {
  def conv = ShortOptConv
}

trait IntOptColValue extends TypeCol[Option[Int]] {
  def conv = IntOptConv
}

trait LongOptColValue extends TypeCol[Option[Long]] {
  def conv = LongOptConv
}

trait FloatOptColValue extends TypeCol[Option[Float]] {
  def conv = FloatOptConv
}

trait DoubleOptColValue extends TypeCol[Option[Double]] {
  def conv = DoubleOptConv
}

trait DecimalNumberOptColValue extends TypeCol[Option[DecimalNumber]] {
  def conv = DecimalNumberOptConv
}

trait BigDecimalOptColValue extends TypeCol[Option[BigDecimal]] {
  def conv = BigDecimalOptConv
}

trait InstantOptColValue extends TypeCol[Option[Instant]] {
  def conv = InstantOptConv
}

trait ZonedDateTimeOptColValue extends TypeCol[Option[ZonedDateTime]] {
  def conv = ZonedDateTimeOptConv
}

trait LocalDateTimeOptColValue extends TypeCol[Option[LocalDateTime]] {
  def conv = LocalDateTimeOptConv
}

trait LocalDateOptColValue extends TypeCol[Option[LocalDate]] {
  def conv = LocalDateOptConv
}

trait UUIDOptColValue extends TypeCol[Option[UUID]] {
  def conv = UUIDOptConv
}
















