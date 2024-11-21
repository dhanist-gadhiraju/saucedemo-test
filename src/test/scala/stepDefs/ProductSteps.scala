package stepDefs

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, ScalaDsl}
import org.scalatest.matchers.should.Matchers
import pages.CartPage._

import scala.jdk.CollectionConverters._

class ProductSteps extends EN with ScalaDsl with Matchers {

  Then("""^I should see the following product in cart page$""") { (dataTable: DataTable) =>
    verifyPageUrl()
    val expectedProduct = dataTable.asMaps(classOf[String], classOf[String]).asScala.map { row =>
      row.get("Item label") -> row.get("Price")
    }.toMap

    actualProduct() should be(expectedProduct)
  }
}
