package kuzminki.model


trait RealCol extends Renderable
                 with ModelCol
                 with SortingCol
                 with Wrap {
                  
  val model: Model
  def name: String

  def real = this

  def render = wrap(name)
  def prefix(picker: PrefixPicker) = "%s.%s".format(picker.wrap(model), wrap(name))

  def args = Seq.empty[Any]
}