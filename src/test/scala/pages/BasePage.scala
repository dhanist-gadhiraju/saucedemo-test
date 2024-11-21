package pages

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.{By, WebElement}
import org.scalatest.AppendedClues
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.matchers.should.Matchers
import utils.StartUpTearDown

import scala.jdk.CollectionConverters.CollectionHasAsScala

trait BasePage extends ScalaDsl with EN with Matchers with StartUpTearDown with ScalaFutures with AppendedClues {

  val url = ""
  val pageTitle = ""

  def goToPage(): Unit = driver.get(url)

  def getPageTitle(): String = driver.getTitle

  def getPageUrl(): String = driver.getCurrentUrl


  def findElementById(value: String): WebElement = driver.findElement(By.id(value))

  def findElementByCssSelector(value: String): WebElement = driver.findElement(By.cssSelector(value))

  def findElementsByCssSelectorName(value: String): Seq[WebElement] = driver.findElements(By.cssSelector(value)).asScala.toList

  def findChildByCssSelector(parent: WebElement, className: String): WebElement =
    parent.findElement(By.cssSelector(className))

  def findChildByTagName(parent: WebElement, tag: String): WebElement =
    parent.findElement(By.tagName(tag))

}
