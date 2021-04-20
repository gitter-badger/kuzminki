package kuzminki.model

import java.time._
import io.rdbc.sapi.{Row, DecimalNumber}


object StringConv extends ValConv[String] {
  def get(row: Row, index: Int) = row.col[String](index)
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



