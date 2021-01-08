package kuzminki.model

import scala.reflect.{classTag, ClassTag}
import scala.reflect.runtime.universe._


object ReadCache {

  import scala.collection.mutable.Map

  def className[P : ClassTag] = classTag[P].runtimeClass.getName

  val readers = Map.empty[String, RowRead[_]]

  def getReader[P : ClassTag : TypeTag](cols: Seq[ModelCol]): RowRead[P] = {
    readers.get(className[P]) match {
      case Some(reader) => reader.asInstanceOf[RowRead[P]]
      case None =>
        val name = className[P]
        val reader = RowReader.create[P](cols)
        readers += (name -> reader)
        reader
    }
  }
}