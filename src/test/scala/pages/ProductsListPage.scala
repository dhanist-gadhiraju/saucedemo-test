package pages

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

    // Map each product element to a tuple containing its price and the ID of its "Add to Cart" button
    val pricesAndCartButtons = products.map { product =>
      val price = findChildByCssSelector(product, ".inventory_item_price").getText.replace("$", "").toDouble
      val addToCartButton = findChildByTagName(product, "button").getAttribute("id")
      (price, addToCartButton)
    }

    // Find the product with the highest price
    val highestPricedItem = pricesAndCartButtons.maxBy(_._1)

    // Add highest price item to the cart
    findElementById(highestPricedItem._2).click()
  }

  def checkCounterOnCartIcon(): Unit = {
    val cartCounter = findElementByCssSelector(".shopping_cart_badge").getText.toInt
    cartCounter should be (1)
  }

}
