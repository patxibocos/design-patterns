object FactoryMethod {

  trait Animal {
    def sayHi
  }

  object Animal {

    private class Cat extends Animal {
      override def sayHi = println("Miau!")
    }

    private class Cow extends Animal {
      override def sayHi = println("Muuu!")
    }

    // Factory method Scala way :P
    def apply(a: String): Animal = {
      a match {
        case "cat" => new Cat
        case "cow" => new Cow
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val cow = Animal("cow")
    cow.sayHi
  }

}
