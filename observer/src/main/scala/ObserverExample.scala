object ObserverExample {

  def main(args: Array[String]): Unit = {
    val account = new Account()
    val client = new Client("Yo")
    account.addObserver(client.accountChanged)
    account.close()
  }

}