package scalacookbook.cb013

import akka.actor.{Actor, ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/13.
  */
object UnderstandActorLifecycle extends App{

  import understandActorLifecycle._

  val system = ActorSystem("LifecycleDemo")

  val kenny = system.actorOf(Props[Kenny], name = "Kenny")

  println("Main:sending kenny a simple String message")
  kenny ! "hello"
  Thread.sleep(1000)

  //重启
  println("Main:make kenny restart")
  kenny ! ForceRestart
  Thread.sleep(1000)

  println("Main:stopping kenny")
  system.stop(kenny)

  println("Main:shutting down system")
  system.shutdown

}

package understandActorLifecycle{

  case object ForceRestart


  class Kenny extends Actor {

    println("Kenny-->entered the Kenny constructor")

    override def preStart { println("kenny: preStart") }

    override def postStop { println("kenny: postStop") }

    override def preRestart(reason: Throwable, message: Option[Any]) {
      println("kenny: preRestart")
      println(s" MESSAGE: ${message.getOrElse("")}")
      println(s" REASON: ${reason.getMessage}")
      super.preRestart(reason, message)
    }

    override def postRestart(reason: Throwable) {
      println("kenny: postRestart")
      println(s" REASON: ${reason.getMessage}")
      super.postRestart(reason)
    }

    def receive = {
      case ForceRestart => throw new Exception("Boom!")
      case _ => println("Kenny received a message")
    }

    //the pre* and post* methods can be used to initialize and close
    //resources that your actor requires.

  }

}
