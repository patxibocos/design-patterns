object Decorator {

  trait PizzaCost {
    def cost(): Int
  }

  class Pizza extends PizzaCost {
    override def cost(): Int = 100
  }

  trait Cheese extends PizzaCost {
    abstract override def cost(): Int = super.cost() + 20
  }

  trait Gorka extends PizzaCost {
    abstract override def cost(): Int = super.cost() + 999
  }

  trait Pineapple extends PizzaCost { self: Gorka => // Only an object with a Gorka ( ;) ) can also include this Pineapple trait
    abstract override def cost(): Int = super.cost() + 30
  }

  def main(args: Array[String]): Unit = {
    // Line below would not compile as Pineapple trait requires the object being a Gorka in this case
    // val pizza = new Pizza() with Cheese with Pineapple
    val pizza = new Pizza() with Cheese with Gorka with Pineapple
    println(pizza.cost())
  }

}
