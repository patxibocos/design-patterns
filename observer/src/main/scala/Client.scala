class Client(var name: String) {

  def this() = this("")

  def accountChanged(account: Account) = {
    if (account.status == Status.CLOSED) {
      println("Oh my god, account has been closed... shut up and give me my money!")
    }
  }

}
