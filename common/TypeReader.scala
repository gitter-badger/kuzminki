/*
* Copyright 2021 Kári Magnússon
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package kuzminki.model

import java.time._
import java.util.UUID

import scala.language.implicitConversions
import scala.util.{ Try, Success, Failure }
import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._
import io.rdbc.sapi._


trait AnyMember {
  def resolve(row: Row, index: Int): Any
}

class TypedMember[T : ClassTag] extends AnyMember {
  def resolve(row: Row, index: Int): T = row.col[T](index)
}

object TypeReader {

  private val stringToMember: String => AnyMember = {
    case "String" => new TypedMember[String]
    case "Int" => new TypedMember[Int]
    case "Boolean" => new TypedMember[Boolean]
    case "Char" => new TypedMember[Char]
    case "Short" => new TypedMember[Short]
    case "Long" => new TypedMember[Long]
    case "BigDecimal" => new TypedMember[BigDecimal]
    case "DecimalNumber" => new TypedMember[DecimalNumber]
    case "Double" => new TypedMember[Double]
    case "Float" => new TypedMember[Float]
    case "java.time.Instant" => new TypedMember[Instant]
    case "java.time.ZonedDateTime" => new TypedMember[ZonedDateTime]
    case "java.time.LocalDateTime" => new TypedMember[LocalDateTime]
    case "java.time.LocalDate" => new TypedMember[LocalDate]
    case "java.util.UUID" => new TypedMember[UUID]
    case name => throw KuzminkiException(s"Unsupported type: $name")
  }
  
  def create[T : ClassTag : TypeTag]: TypeReader[T] = {

    val members = typeOf[T].members
             .sorted
             .collect { case m: MethodSymbol if m.isCaseAccessor => m }
             .map(_.returnType.toString)
             .toSeq
             .map(stringToMember)

    new CustomTypeReader[T](members.zipWithIndex)
  }
}

trait TypeReader[T] {
  def read(row: Row): T
}

class CustomTypeReader[T : ClassTag](members: Seq[Tuple2[AnyMember, Int]]) extends TypeReader[T] {

  private def args(row: Row): Seq[AnyRef] = {
    members.map {
      case (member, index) =>
        member.resolve(row, index).asInstanceOf[AnyRef]
    }
  }

  def read(row: Row): T = {
    Try {
      
      classTag[T]
        .runtimeClass
        .getConstructors
        .head
        .newInstance(args(row): _*)
        .asInstanceOf[T]
    
    } match {
      case Success(res) => res
      case Failure(ex) =>
        val name = classTag[T].runtimeClass.getName
        val message = ex.getMessage
        throw KuzminkiException(s"Failed to read ($name) $message")
    }
  }
}



/*

  private val standardName: String => String = {
    case "java.time.Instant" => "Instant"
    case "java.time.ZonedDateTime" => "ZonedDateTime"
    case "java.time.LocalDateTime" => "LocalDateTime"
    case "java.time.LocalDate" => "LocalDate"
    case "java.util.UUID" => "UUID"
    case name => name
  }  

  private val stringToMember: String => AnyMember = {
    case "String" => new TypedMember[String]
    case "Int" => new TypedMember[Int]
    case "Boolean" => new TypedMember[Boolean]
    case "Char" => new TypedMember[Char]
    case "Short" => new TypedMember[Short]
    case "Long" => new TypedMember[Long]
    case "BigDecimal" => new TypedMember[BigDecimal]
    case "DecimalNumber" => new TypedMember[DecimalNumber]
    case "Double" => new TypedMember[Double]
    case "Float" => new TypedMember[Float]
    case "java.time.Instant" => new TypedMember[Instant]
    case "java.time.ZonedDateTime" => new TypedMember[ZonedDateTime]
    case "java.time.LocalDateTime" => new TypedMember[LocalDateTime]
    case "java.time.LocalDate" => new TypedMember[LocalDate]
    case "java.util.UUID" => new TypedMember[UUID]
    case name => throw KuzminkiModelException(s"Unsupported type: $name")
  }

  private val modelColTypeName: ModelCol => String = {
    case c: StringColValue => "String"
    case c: BooleanColValue => "Boolean"
    case c: ShortColValue => "Short"
    case c: IntColValue => "Int"
    case c: LongColValue => "Long"
    case c: FloatColValue => "Float"
    case c: DoubleColValue => "Double"
    case c: DecimalNumberColValue => "DecimalNumber"
    case c: BigDecimalColValue => "BigDecimal"
    case c => throw KuzminkiModelException("Unsupported column (%s)".format(c.getClass.getName))
  }

*/


























