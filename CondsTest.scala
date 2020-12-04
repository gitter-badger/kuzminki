import scala.concurrent.{Future, Await}

import scala.util.{ Try, Success, Failure }
import scala.concurrent.duration._

import kuzminki.{ Part, PartCollector }


case class WhereCond(name: String) {

  //def samasem(value: Any): Part = Part.create(s"$name = ?", value)

  def matches(value: Any): Part = Part.create(s"$name = ?", value)

  def ===(value: Any): Part = matches(value)

  def gt(value: Any): Part = Part.create(s"$name > ?", value)

  def >(value: Any): Part = gt(value)

  def lt(value: Any): Part = Part.create(s"$name < ?", value)

  def <(value: Any): Part = lt(value)
}


object Filtering {
  def start: FilteringStart = FilteringChain(PartCollector.init)
}


trait Filtering {
  def col(part: Part): Filtering
  def and(part: Part): Filtering
  def andMore(sub: FilteringStart => Filtering): Filtering
  def or(part: Part): Filtering
  def orMore(sub: FilteringStart => Filtering): Filtering
  def parts: PartCollector
}

trait FilteringStart {
  def col(part: Part): Filtering
}



case class FilteringChain(parts: PartCollector) extends Filtering
                                                   with FilteringStart{

  private def next(op: String, part: Part) = {
    FilteringChain(
      parts.extend(
        Seq(Part.create(op), part)
      )
    )
  }

  private def wrapped(sub: FilteringStart => Filtering): Part = {
    sub(Filtering.start).parts.asNested
  }

  def col(part: Part): Filtering = FilteringChain(parts.add(part))

  def and(part: Part): Filtering = next("AND", part)

  def andMore(sub: FilteringStart => Filtering): Filtering = {
    next("AND", wrapped(sub))
  }

  def or(part: Part): Filtering = next("OR", part)

  def orMore(sub: FilteringStart => Filtering): Filtering = {
    next("OR", wrapped(sub))
  }
}


object CondsTest extends App {

  implicit val stringToWhereCond: String => WhereCond = name => WhereCond(name)

  //val init: Part => Filtering = part => Filtering(PartCollector.create(part))

  def where(sub: FilteringStart => Filtering) = {
    sub(Filtering.start)
  }


  print(
    where(
      _.col("id" === 44)
      .and("age" < 35)
    ).parts.toPart.tmpl
  )
  

  /*
  print(
    where(fil =>
      fil.col("id" samasem 44)
      .and("age" lt 35)
      .orMore(fil =>
        fil.col("city" samasem "Moscow")
        .and("country" samasem "Russia")
      )
    ).parts.toPart.tmpl
  )
  */

  /*
  println(
    "id" matches 44
  )
  */
}



























