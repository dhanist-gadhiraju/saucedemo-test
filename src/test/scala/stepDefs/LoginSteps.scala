package stepDefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import pages.LoginPage.{launchSite, login}
import pages.ProductsListPage._

class LoginSteps extends EN with ScalaDsl with Matchers {

  Given("""^I launch the saucedemo site$""") {
    launchSite()
  }

  And("""^I login with valid credentials$""") {
    login()
    verifyProductsPage()
  }
}
