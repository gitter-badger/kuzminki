package kuzminki.model

import java.time._
import java.util.UUID
import io.rdbc.sapi._


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