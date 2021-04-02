trait GenericShow[T]{
  def show(aValue: T): String
}

case class PersonShow(name: String, age:Int)

object GenericShowInstances {
  implicit val personShow = new GenericShow[PersonShow] {
    def show(value: PersonShow): String = {
      s"The person that I am showing has a name ${value.name} and an age ${value.age}"
    }
  }
}

object GenericShowInterfaces {
  def genericShow[T](value: T)(implicit gs: GenericShow[T]): String = {
    gs.show(value)
  }
}