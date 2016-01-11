package akka.app.message

import java.util._

import scala.collection.mutable.ArrayBuffer

/**
  * Created by liguodong on 2015/12/19.
  */
/*
class Messages {
}
*/

//对每个单词进行计数
class Word(val word:String,val count:Integer)

//对传进来的字符串进行单词切分
class MapDada(val dataList:ArrayList[String])

//一个单词在当前的字符串中出现的总的次数
class ReduceData(val reduceDataMap:HashMap[String,Integer])

//只是给Aggregate发送一个消息说我们想要一个结果
case class Result()


