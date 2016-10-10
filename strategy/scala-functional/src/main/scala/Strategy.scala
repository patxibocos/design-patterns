object Strategy {

  type SayHello = () => String

  def sayHelloImpl1 = () => "Hello1!"
  def sayHelloImpl2 = () => "Hello2!"
  def sayHelloImpl3 = () => "Hello3!"

  abstract class Duck {
    // This will allow us calling greet without a method as a child class could have overwritten this with a default value (PlasticDuck example)
    def greet(sayHello: Option[SayHello]) = sayHello match {
      case Some(callback) => callback()
      case None => None
    }
  }

  case class NormalDuck() extends Duck

  case class PlasticDuck() extends Duck {
    // Call parents with a default function
    override def greet(sayHello: Option[SayHello]) = super.greet(Some(sayHello.getOrElse(sayHelloImpl2)))
  }

  def main(args: Array[String]): Unit = {
    val normalDuck: Duck = NormalDuck()
    System.out.println(normalDuck.greet(Some(sayHelloImpl1)))

    val plasticDuck: Duck = PlasticDuck()
    System.out.println(plasticDuck.greet(None))
    System.out.println(plasticDuck.greet(Some(sayHelloImpl3)))
  }

}