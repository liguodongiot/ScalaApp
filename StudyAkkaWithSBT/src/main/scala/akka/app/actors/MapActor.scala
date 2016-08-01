package akka.app.actors

import java.util.{StringTokenizer, ArrayList}

import akka.actor.{ActorRef, Actor}
import akka.app.message.{Word, MapDada}

/**
  * Created by liguodong on 2015/12/19.
  */
class MapActor(reduceActor:ActorRef) extends Actor{

  val STOP_WORDS_LIST = List("a","is")

  def receive: Receive = {
    case message:String =>
      reduceActor ! evaluateExpression(message) //发送给reduceActor
    case _ =>
  }

  //数据切分
  def evaluateExpression(line:String):MapDada = {

    var dataList = new ArrayList[String]


    var parser:StringTokenizer = new StringTokenizer(line)//单词切分

    var defaultCount:Integer = 1
    while(parser.hasMoreTokens){
      var word:String = parser.nextToken().toLowerCase()
      if(!STOP_WORDS_LIST.contains(word)){
        //dataList.add(new Word(word,defaultCount))
        dataList.add(word)
      }
    }
    return new MapDada(dataList)
  }
}

