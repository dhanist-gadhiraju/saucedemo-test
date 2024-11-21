package pages

import org.openqa.selenium.By

object ProductsListPage extends BasePage {

  override val url = "https://www.saucedemo.com/inventory.html"
  val expectedHeading = "Products"

  def getHeading(): String = findElementByCssSelector(".header_secondary_container span").getText

  def verifyProductsPage(): Unit = {
    getPageUrl() should be (url)
    getHeading() should be (expectedHeading)
  }

  def clickOnHighestPricedProduct(): Unit = {
    val products = findElementsByCssSelectorName(".inventory_item")

    val pricesAndCartButtons = products.map { product =>
      val price = findChildByCssSelector(product, ".inventory_item_price").getText.replace("$", "").toDouble
      val addToCartButton = findChildByTagName(product, "button").getAttribute("id")
      (price, addToCartButton)
    }

    val highestPricedItem = pricesAndCartButtons.maxBy(_._1)
    findElementById(highestPricedItem._2).click()
  }

  def checkCounterOnCartIcon(): Unit = {
    val cartCounter = findElementByCssSelector(".shopping_cart_badge").getText.toInt
    cartCounter should be (1)
  }

}
