package stepDefs

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import pages.CartPage._
import pages.LoginPage.{launchSite, login}
import pages.ProductsListPage._

import scala.jdk.CollectionConverters._

class ProductSteps extends EN with ScalaDsl with Matchers {

  Given("""^I launch the saucedemo site$""") {
    launchSite()
  }

  And("""^I login with valid credentials$""") {
    login()
    verifyProductsPage()
  }

  When("""^I click on Add to cart button on highest priced product$""") {
    clickOnHighestPricedProduct()
  }

  Then("""^the product should be added to cart$""") {
    checkCounterOnCartIcon()
  }

  When("""^I click on cart icon$""") {
    clickOnCartIcon()
  }

  Then("""^I should see the following product in cart page$""") { (dataTable: DataTable) =>
    verifyPageUrl()
    val expectedProduct = dataTable.asMaps(classOf[String], classOf[String]).asScala.map { row =>
      row.get("Item label") -> row.get("Price")
    }.toMap

    actualProduct() should be(expectedProduct)
  }
}
