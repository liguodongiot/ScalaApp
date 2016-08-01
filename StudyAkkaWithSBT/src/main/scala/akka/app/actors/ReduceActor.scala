package akka.app.actors

import java.util.{ArrayList,HashMap}

import akka.actor.{ActorRef, Actor}
import akka.app.message.{ReduceData, Word, MapDada}



/**
  * Created by liguodong on 2015/12/19.
  */
class ReduceActor(aggregateActor: ActorRef) extends Actor{

  def receive: Receive = {
    case message:MapDada =>
      aggregateActor ! reduce(message.dataList)
    case _ =>
  }

  def reduce(dataList:ArrayList[String]):ReduceData={
    val reduceMap = new HashMap[String,Integer]


    for(wordObj:Object <- dataList.toArray){//依次取出元素
      val word = wordObj.toString
      //val wcs:Word = (Word)wc
      //var word:String = wc.word
      if(reduceMap.containsKey(word)){
        reduceMap.put(word,reduceMap.get(word)+1)
      }else{
        reduceMap.put(word,1)
      }
    }
    return new ReduceData(reduceMap)
  }
}

