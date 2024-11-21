package pages

object CartPage extends BasePage {

  override val url = "https://www.saucedemo.com/cart.html"

  def clickOnCartIcon(): Unit = findElementByCssSelector(".shopping_cart_link").click()

  def verifyPageUrl(): Unit = {
    getPageUrl() should be (url)
  }

  def actualProduct(): Map[String, String] = {
    val product = findElementByCssSelector(".cart_item")
    val label = findChildByCssSelector(product, ".inventory_item_name").getText
    val price = findChildByCssSelector(product, ".inventory_item_price").getText.replace("$", "")
    Map(label -> price)
  }
}
