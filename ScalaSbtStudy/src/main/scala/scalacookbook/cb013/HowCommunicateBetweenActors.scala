package scalacookbook.cb013

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

/**
  * Created by liguodong on 2016/8/13.
  */

case object PingMessage
case object PongMessage
case object StartMessage
case object StopMessage

object HowCommunicateBetweenActors extends App{

  val system = ActorSystem("PingPongSystem")
  val pong = system.actorOf(Props[Pong], name = "pong")

  val ping = system.actorOf(Props(new Ping(pong)), name = "ping")

  // start the action
  ping ! StartMessage

  // commented-out so you can see all the output
  //system.shutdown

}

class Ping(pong: ActorRef) extends Actor {

  var count = 0
  def incrementAndPrint { count += 1; println("ping"+count) }

  def receive = {
    case StartMessage =>
      incrementAndPrint
      pong ! PingMessage
    case PongMessage =>
      incrementAndPrint
      if (count > 19) {
        sender ! StopMessage
        println("ping stopped")
        context.stop(self)
      } else {
        sender ! PingMessage
      }
    case _ => println("Ping got something unexpected.")
  }
}

class Pong extends Actor {
  def receive = {
    case PingMessage =>
      println(" pong")
      sender ! PongMessage
    case StopMessage =>
      println("pong stopped")
      context.stop(self)
    case _ => println("Pong got something unexpected.")
  }
}
