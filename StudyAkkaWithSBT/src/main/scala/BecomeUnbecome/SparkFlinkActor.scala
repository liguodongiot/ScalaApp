package BecomeUnbecome

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
  * Created by liguodong on 2015/12/20.
  */
case class Spark()
case class Flink()

class SparkFlinkActor extends Actor{
  import  context._
  var count = 0
  override def receive: Receive = {
    case Spark =>
      println("Here is Spark!!!")
      count += 1
      Thread.sleep(100)
      self ! Flink  //再发送一个消息给自己
      become{
        case Flink =>
          println("Here is Flink!!!")
          count += 1
          Thread.sleep(100)
          self ! Spark
          unbecome()
      }
      if(count>10) context.stop(self)//停止自己的Actor
  }
}
