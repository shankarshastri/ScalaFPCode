package csv

import java.io.File

import scala.annotation.tailrec


case class Log(timestamp: Long, ip: String, campaignid: String, placementid: String, siteid: String,
               adunittype: String, creativeid:String, jvxsessionid: String,
               jvxuid: String,
               eventid: String, deviceid: String, ap_datasignal: String, c_params: String, cachemacro: String, clickmacro: String,
               pageurl: String, useragent: String, es_segname: String, date: String, _col19: String)

object CSVParseUniq  extends App {

    val header = List("timestamp", "ip", "campaignid", "placementid", "siteid", "adunittype", "creativeid",
        "jvxsessionid", "jvxuid", "eventid", "deviceid", "ap_datasignal", "c_params", "cachemacro",
    "clickmacro", "pageurl", "useragent", "es_segname", "date", "_col19").toSeq

    implicit class DistinctFunctionSeq[A](val list: List[A]) extends AnyVal {
        def distinctOn[B](f: A => B): List[A] = list.foldLeft(List.empty[A]) { (acc, elem) =>
            val value = f(elem)
            acc.find(item => f(item) == value) match {
                case Some(_) => acc
                case None    => elem :: acc
            }
        }
    }


    def filterByJvxId(l: List[Log]): List[Log] = {
        @tailrec
        def filterHelper(l: List[Log], startTimeStamp: Long,
                         lastTimeStamp: Long, res: List[List[Log]] = List.empty[List[Log]]): List[Log] = {
            if(startTimeStamp > lastTimeStamp || l.isEmpty) res.flatten.sortBy(_.timestamp)
            else {
                val (l1, l2) = l.partition(e => e.timestamp >= startTimeStamp && e.timestamp <= startTimeStamp +
                  60000)
                println(l1.length, l2.length)
                println(startTimeStamp, lastTimeStamp)
                filterHelper(l2, startTimeStamp + 60000, lastTimeStamp, res :+ l1.distinctOn(_.jvxuid))
            }
        }
        val sortedList = l.sortBy(_.timestamp)
        val startTimeStamp = sortedList.head.timestamp
        val lastTimeStamp = sortedList.last.timestamp
        filterHelper(sortedList, startTimeStamp, lastTimeStamp)
    }

    import purecsv.unsafe._
    val l = CSVReader[Log].readCSVFromFile(new File("src/main/resources/dummyTest.csv"), skipHeader=true)
    println(l.length)
    println("$$$$$")
    val r = filterByJvxId(l)
    println(r.length)
    r.writeCSVToFile(new File("src/main/resources/dummyUnique.csv"), header = Some(header))

    val l1 =  CSVReader[Log].readCSVFromFile(new File("src/main/resources/dummyUnique.csv"),
        skipHeader = true)
    l.foreach(println)
    l1.foreach(println)

    println(l.length)
    println(l1.length)
}
