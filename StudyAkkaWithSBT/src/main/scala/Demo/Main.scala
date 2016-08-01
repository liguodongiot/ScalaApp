package Demo


import akka.actor.{Kill, PoisonPill, ActorSystem, Props}
import akka.app.actors.MasterActor
import akka.app.message.Result

/**
  * Created by liguodong on 2015/12/18.
  */

object Main {
  def main(args: Array[String]) {
    val system = ActorSystem("HelloAkka")
    //创建具体的MasterActor
    val master = system.actorOf(Props[MasterActor],name = "master")

    println("masterActor:"+master.path)

    //发送信息
    master ! "Hi! My name is Rocky, I'm so so so happy to be here."
    master ! "Today, I'm going to read a news article for you."
    master ! "I hope you'll like it."

    Thread.sleep(500)
    master ! new Result

    Thread.sleep(500)

    //停止MasterActor
    //master ! PoisonPill   //异步方式
    //master ! Kill         //同步方式

    system.shutdown()

  }
}
