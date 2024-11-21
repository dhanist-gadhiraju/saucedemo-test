package pages


object LoginPage extends BasePage {
  override val url = "https://saucedemo.com"

  def launchSite(): Unit = {
    goToPage()
  }

  // Login Details
  def login(): Unit = {
    findElementById("user-name").clear()
    findElementById("user-name").sendKeys("standard_user")
    findElementById("password").clear()
    findElementById("password").sendKeys("secret_sauce")
    findElementById("login-button").click()
  }

}
