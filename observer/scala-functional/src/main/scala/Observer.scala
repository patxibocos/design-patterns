object Observer {

  trait Subject[S] {
    this: S =>
    private var observers: List[S => Unit] = Nil
    def addObserver(observer: S => Unit) = observers ::= observer
    def notifyObservers() = observers.foreach(_.apply(this))
  }

  class Client(var name: String) {
    def accountChanged(account: Account) = { println ("Oh, something change on account...") }
  }

  class Account extends Subject[Account] {
    object Status extends Enumeration {
      val ACTIVE, CLOSED, DELETED = Value
    }

    var status = Status.ACTIVE
    def close() = {
      status = Status.CLOSED
      notifyObservers()
    }
  }

  def main(args: Array[String]): Unit = {
    val account = new Account()
    val client = new Client("Yo")
    account.addObserver(client.accountChanged)
    account.close()
  }

}