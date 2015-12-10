package ru.hse.modern.technologies

import org.apache.spark._
import org.apache.spark.streaming

object Twitter {

  def getConfig(): SparkConfig = {
    new SparkConfig().setMaster("local[*]").setAppName()
  }

  def main(args: Array[String]): Unit = {

  }
}