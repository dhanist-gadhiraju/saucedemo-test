package utils

import java.util.Properties
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeDriverService, ChromeOptions}

object Driver {

  val systemProperties: Properties = System.getProperties

  lazy val ifMac: Boolean = systemProperties.getProperty("os.name").startsWith("Mac")

  if (ifMac) {
    systemProperties.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"/usr/local/bin/chromedriver")
  } else {
    systemProperties.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,"./chrome/chromedriver")
  }

  val instance: WebDriver = newWebDriver()

  def newWebDriver(): WebDriver = {
    val browserProperty = systemProperties.getProperty("browser", "chrome")
    val driver = createDriver(browserProperty)
    driver
  }

  private def createDriver(browserProperty: String): WebDriver = {
    browserProperty match {
      case "chrome" => createChromeBrowser()
      case _ => throw new IllegalArgumentException(s"browser type $browserProperty not recognised ")
    }
  }

  private def createChromeBrowser(): WebDriver = {
    val options = new ChromeOptions()
      .addArguments("--start-maximized")
      .addArguments("--remote-allow-origins=*")
    val driver = new ChromeDriver(options)
    driver
  }

  sys addShutdownHook instance.quit()

}
