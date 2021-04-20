package kuzminki.model


trait ValidateUpsert {

  protected def validate(conflictCol: ModelCol, updateCols: Seq[ModelCol]): Unit = {

    if (updateCols.isEmpty) {
      throw KuzminkiException("no update columns selected")
    }

    if (updateCols.contains(conflictCol)) {
      throw KuzminkiException("cannot update the conflicting column")
    }
  }
}