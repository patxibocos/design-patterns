object AbstractFactory {

  trait Terminal {
    def parse(command: String)
  }

  class WindowsTerminal extends Terminal{
    override def parse(command: String): Unit = println("Parsing from Windows")
  }

  class MacOSTerminal extends Terminal{
    override def parse(command: String): Unit = println("Parsing from Mac OS")
  }

  trait OS {
    def getTerminal: Terminal
  }

  class Windows extends OS {
    override def getTerminal: Terminal = new WindowsTerminal
  }

  class MacOS extends OS {
    override def getTerminal: Terminal = new MacOSTerminal
  }

  def main(args: Array[String]): Unit = {
    new Windows().getTerminal.parse("ls")
    new MacOS().getTerminal.parse("ls")
  }

}
