package io.prophecy.pipelines.gemp1.graph

import io.prophecy.libs._
import io.prophecy.pipelines.gemp1.config.Context
import io.prophecy.pipelines.gemp1.functions.UDFs._
import io.prophecy.pipelines.gemp1.functions.PipelineInitCode._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.sql.expressions._
import java.time._

object script_0 {
  def apply(context: Context): Unit = {
    val spark = context.spark
    val Config = context.config
    println("hi")
  }

}
