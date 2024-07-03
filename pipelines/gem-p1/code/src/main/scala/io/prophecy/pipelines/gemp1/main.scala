package io.prophecy.pipelines.gemp1

import io.prophecy.libs._
import io.prophecy.pipelines.gemp1.config._
import io.prophecy.pipelines.gemp1.functions.UDFs._
import io.prophecy.pipelines.gemp1.functions.PipelineInitCode._
import io.prophecy.pipelines.gemp1.graph._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object Main {

  def apply(context: Context): Unit =
    script_0(context)

  def main(args: Array[String]): Unit = {
    val config = ConfigurationFactoryImpl.getConfig(args)
    val spark: SparkSession = SparkSession
      .builder()
      .appName("gem-p1")
      .config("spark.default.parallelism",             "4")
      .config("spark.sql.legacy.allowUntypedScalaUDF", "true")
      .enableHiveSupport()
      .getOrCreate()
    val context = Context(spark, config)
    spark.conf.set("prophecy.metadata.pipeline.uri", "pipelines/gem-p1")
    registerUDFs(spark)
    MetricsCollector.instrument(spark, "pipelines/gem-p1") {
      apply(context)
    }
  }

}
