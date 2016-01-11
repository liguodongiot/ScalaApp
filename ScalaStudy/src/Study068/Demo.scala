package Study068

import scala.actors.Actor._
import scala.actors.Actor

/**
 * 并发编程原生线程Actor、Case Class下的消息传递和偏函数
 * Created by liguodong on 2015/12/14.
 */

case class Person(name: String, arg: Int)

class HelloActor extends Actor{
  override def act(): Unit ={
    while(true){
      receive{
        case Person(name,age) => {
          println("Name: " + name + " : " + "Age: " + age)
          sender ! "Echo!!!" //给发送者返回一个消息
        }
        case _ => println("Something else ...")
      }
    }
  }
}


object Demo {
  def main(args: Array[String]) {

    val hiActor = new HelloActor
    hiActor.start()
    hiActor ! Person("Spark",6)

    self.receive{case msg => println(msg)} //默认情况下是阻塞的，等待接收消息

    //self.reactWithin(1000){case msg => println(msg)} //指定了默认的超时时间为1s
  }
}
