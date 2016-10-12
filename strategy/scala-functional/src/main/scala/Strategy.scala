object Strategy {

  type Ability = () => String

  def flyability: Ability = () => "I can fly like a bird"
  def invulnerability: Ability = () => "I´m invulnerable, try to hurt me!"
  def invisibility: Ability = () => "Can you see me?"

  abstract class SuperHero {
    // This will allow us calling greet without a method as a child class could have overwritten this with a default value (Venom example)
    def performAbility(ability: Option[Ability]) = ability match {
      case Some(callback) => println(s"${this.getClass.getSimpleName} says: ${callback()}")
      case None => None
    }
  }

  case class Superman() extends SuperHero

  case class Venom() extends SuperHero {
    // Call parents with a default function
    override def performAbility(ability: Option[Ability]) = super.performAbility(Some(ability.getOrElse(invisibility)))
  }

  def main(args: Array[String]): Unit = {
    val superman: SuperHero = Superman()
    superman.performAbility(Some(flyability))

    val venom: SuperHero = Venom()
    venom.performAbility(None)
    venom.performAbility(Some(invulnerability))
  }

}