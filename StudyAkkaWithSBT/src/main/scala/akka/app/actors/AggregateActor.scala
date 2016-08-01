package akka.app.actors

import java.util
import akka.actor.Actor
import akka.app.message.{Result, ReduceData}

/**
  * Created by liguodong on 2015/12/19.
  */
class AggregateActor extends Actor
{
  var finalReducedMap = new util.HashMap[String,Integer]()

  def receive: Receive = {
    case message : ReduceData =>
      aggregateInMemoryReduce(message.reduceDataMap)
    case message : Result =>
      println(finalReducedMap.toString)
  }
  def aggregateInMemoryReduce(reduceList:util.HashMap[String,Integer]): Unit ={
    var count:Integer = 0
    for(keytemp:Object <- reduceList.keySet().toArray){
      val key = keytemp.toString
      if(finalReducedMap.containsKey(key)){
        count = reduceList.get(key)
        count += finalReducedMap.get(key)
        finalReducedMap.put(key,count)
      } else{
        finalReducedMap.put(key,reduceList.get(key))
      }
    }
  }



}
