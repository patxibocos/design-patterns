trait Subject[S] { self: S =>

  private var observers: List[S => Unit] = Nil
  def addObserver(observer: S => Unit) = observers ::= observer
  def notifyObservers() = observers.foreach(_.apply(self))

}
