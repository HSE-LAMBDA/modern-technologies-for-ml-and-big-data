package ru.hse.modern.technologies

import org.apache.spark._
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.twitter._

object Twitter {
  def getConfig: SparkConf = {
    val sconf = new SparkConf()
    sconf.setMaster("local[8]").setAppName("Twitter example")
    sconf
  }

  def main(args: Array[String]): Unit = {
    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)
    val filters = args.takeRight(args.length - 4)

    val ssc = new StreamingContext(getConfig, Seconds(5))

    System.setProperty("twitter4j.oauth.consumerKey", consumerKey)
    System.setProperty("twitter4j.oauth.consumerSecret", consumerSecret)
    System.setProperty("twitter4j.oauth.accessToken", accessToken)
    System.setProperty("twitter4j.oauth.accessTokenSecret", accessTokenSecret)

    val stream = TwitterUtils.createStream(ssc, None, filters, StorageLevel.MEMORY_ONLY)

    val texts = stream.map(status => status.getText)

    texts.count().print()

    ssc.start()

    ssc.awaitTerminationOrTimeout(60000l)
  }
}