package abhishekse2etestsprophecyioteam.rajatcustomgems.gems

import io.prophecy.gems._
import io.prophecy.gems.dataTypes._
import io.prophecy.gems.uiSpec._
import io.prophecy.gems.diagnostics._
import io.prophecy.gems.componentSpec._
import org.apache.spark.sql.{DataFrame, SparkSession}
import io.prophecy.gems.copilot._
import play.api.libs.json.{Format, OFormat, JsResult, JsValue, Json}


class ShiningReformat extends ComponentSpec {

  val name: String = "ShiningReformat"
  val category: String = "Transform"
  type PropertiesType = ShiningReformatProperties
  override def optimizeCode: Boolean = true

  case class ShiningReformatProperties(
    @Property("Property1")
    property1: String = ""
  ) extends ComponentProperties

  implicit val ShiningReformatPropertiesFormat: Format[ShiningReformatProperties] = Json.format

  def dialog: Dialog = Dialog("ShiningReformat")

  def validate(component: Component)(implicit context: WorkflowContext): List[Diagnostic] = Nil

  def onChange(oldState: Component, newState: Component)(implicit context: WorkflowContext): Component = newState

  def deserializeProperty(props: String): ShiningReformatProperties = Json.parse(props).as[ShiningReformatProperties]

  def serializeProperty(props: ShiningReformatProperties): String = Json.toJson(props).toString()

  class ShiningReformatCode(props: PropertiesType) extends ComponentCode {
    def apply(spark: SparkSession, in: DataFrame): DataFrame = {
      val out = in
      println("1")
      out
    }
  }
}
