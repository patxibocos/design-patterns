object Status extends Enumeration {
  val ACTIVE, CLOSED, DELETED = Value
}

class Account extends Subject[Account] {

  var status = Status.ACTIVE

  def close() = {
    status = Status.CLOSED
    notifyObservers()
  }

}
