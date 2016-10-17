import org.mockito.Mockito.verify
import org.scalatest.FunSpec
import org.scalatest.mockito.MockitoSugar

class ObserverExampleTest extends FunSpec with MockitoSugar {

  it("should notify observers when account is closed") {
    val account = new Account()
    val client = mock[Client]
    account.addObserver(client.accountChanged)
    account.close()
    verify(client).accountChanged(account)
  }

}
