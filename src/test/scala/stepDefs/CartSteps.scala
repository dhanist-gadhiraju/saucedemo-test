package stepDefs

import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import pages.CartPage._
import pages.ProductsListPage._

class CartSteps extends EN with ScalaDsl with Matchers {

  When("""^I click on Add to cart button on highest priced product$""") {
    clickOnHighestPricedProduct()
  }

  Then("""^the product should be added to cart$""") {
    checkCounterOnCartIcon()
  }

  When("""^I click on cart icon$""") {
    clickOnCartIcon()
  }
}
