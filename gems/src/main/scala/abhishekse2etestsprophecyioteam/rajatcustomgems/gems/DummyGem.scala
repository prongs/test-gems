package abhishekse2etestsprophecyioteam.rajatcustomgems.gems

import io.prophecy.gems._
import io.prophecy.gems.dataTypes._
import io.prophecy.gems.uiSpec._
import io.prophecy.gems.diagnostics._
import io.prophecy.gems.componentSpec._
import org.apache.spark.sql.{DataFrame, SparkSession}
import io.prophecy.gems.copilot._
import play.api.libs.json.{Format, OFormat, JsResult, JsValue, Json}


class DummyGem extends ComponentSpec {

  val name: String = "DummyGem"
  val category: String = "Transform"
  type PropertiesType = DummyGemProperties
  override def optimizeCode: Boolean = true

  case class DummyGemProperties(
    @Property("Property1")
    property1: String = ""
  ) extends ComponentProperties

  implicit val DummyGemPropertiesFormat: Format[DummyGemProperties] = Json.format

  def dialog: Dialog = Dialog("DummyGem")

  def validate(component: Component)(implicit context: WorkflowContext): List[Diagnostic] = Nil

  def onChange(oldState: Component, newState: Component)(implicit context: WorkflowContext): Component = newState

  def deserializeProperty(props: String): DummyGemProperties = Json.parse(props).as[DummyGemProperties]

  def serializeProperty(props: DummyGemProperties): String = Json.toJson(props).toString()

  class DummyGemCode(props: PropertiesType) extends ComponentCode {
    def apply(spark: SparkSession, in: DataFrame): DataFrame = {
      val out = in
      out
    }
  }
}
