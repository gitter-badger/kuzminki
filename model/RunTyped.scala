package kuzminki.model


class RunTyped[R](coll: TypedCollector[R]) extends Printing {
  
  def run() = {
    coll.db.select(coll.statement) { row =>
      coll.transformer.transform(row)
    }  
  }

  def headOption() = {
    coll.db.selectHeadOption(coll.statement) { row =>
      coll.transformer.transform(row)
    }
  }

  def runAs[T](implicit custom: R => T) = {
    coll.db.select(coll.statement) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }  
  }

  def headOptionAs[T](implicit custom: R => T) = {
    coll.db.selectHeadOption(coll.statement) { row =>
      custom(
        coll.transformer.transform(row)
      )
    }  
  }

  def render = coll.render
  
  def asSub = new SubQuery(coll)
}