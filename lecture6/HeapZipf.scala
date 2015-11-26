package io.crayfis.apps

import org.apache.spark._
import org.apache.spark.rdd._
import org.apache.spark.storage.StorageLevel

object HeapZipf {
  def main(args: Array[String]): Unit = {
    val sconfig = new SparkConf()
    sconfig.setMaster("local[*]")

    val sc = new SparkContext(sconfig)

    val path = "file:///text.txt"

    val lines = sc.textFile(path)

    val words = lines.flatMap { line: String =>
      line.split(" ")
    }

    def wordDictionary(ws: Iterator[String]):
      Iterator[(String, Int)] = {
      Iterator.empty
    }

    val ns = words.mapPartitions(wordDictionary).
      reduceByKey { _ + _ }.map { case (w, freq) => freq }.
    persist(StorageLevel.MEMORY_ONLY)

    val total = ns.sum()

    val freqs = ns.map { n => n.toDouble / total }

    val sortedFreq: RDD[(Double, Long)] =
      freqs.sortBy { f => -f }.zipWithIndex().map {
        case (freq, rank) =>
          (math.log(freq), rank)
      }

    
  }
}
