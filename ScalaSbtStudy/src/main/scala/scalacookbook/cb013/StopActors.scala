package scalacookbook.cb013

import akka.actor._
import akka.pattern.gracefulStop
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

/**
  * Created by liguodong on 2016/8/13.
  */
object StopActors extends App {

  //There are several ways to stop Akka actors.
  // The most common ways are to call
  // system.stop(actorRef) at the ActorSystem level
  // or context.stop(actorRef) from inside an actor.

  //There are other ways to stop an actor:
  // Send the actor a PoisonPill message.
  // Program a gracefulStop



  //The stop method lets the actor finish
  // processing the current message in its mailbox (if any),
  // and then stops it.

  //The PoisonPill message lets the actors
  // process all messages that are in the mailbox
  // ahead of it before stopping it.

  //Calling actorSystem.stop(actor) and context.stop(actor)
  // are the most common ways to stop an actor.


  /*system.stop and context.stop*/
  val actorSystem1 = ActorSystem("SystemStopExample")
  val actor1 = actorSystem1.actorOf(Props[TestActor1], name = "test1")
  actor1 ! "hello"
  // stop our actor
  actorSystem1.stop(actor1)
  actorSystem1.shutdown

  println("~~~~~~~~~~~~~~~~~~")

  //As mentioned, using context.stop(actorRef) is similar to
  // using actorSystem.stop(actorRef); just use context.stop(actorRef)
  // from within an actor.
  // The context variable is implicitly available inside an Actor.

  /*PoisonPill message*/
  val system2 = ActorSystem("PoisonPillTest")
  val actor2 = system2.actorOf(Props[TestActor2], name = "test2")
  // a simple message
  actor2 ! "before PoisonPill"
  // the PoisonPill
  actor2 ! PoisonPill

  // these messages will not be processed
  actor2 ! "after PoisonPill"
  actor2 ! "hello?!"
  system2.shutdown

  println("~~~~~~~~~~~~~~~~~~")

  /*gracefulStop*/
  val system3 = ActorSystem("GracefulStopTest")
  val testActor3 = system3.actorOf(Props[TestActor3], name = "TestActor3")
  // try to stop the actor gracefully
  try {
    val stopped: Future[Boolean] = gracefulStop(testActor3, 2 seconds)

    Await.result(stopped, 3 seconds)
    println("testActor3 was stopped")
  } catch {
    case e:Exception => e.printStackTrace
  } finally {
    system3.shutdown
  }

  println("~~~~~~~~~~~~~~~~~~")

  /*“Killing” an actor*/
  val system = ActorSystem("KillTestSystem")
  val number5 = system.actorOf(Props[Number5], name = "Number5")
  number5 ! "hello"
  // send the Kill message
  number5 ! Kill
  system.shutdown

}



class TestActor1 extends Actor {
  def receive = {
    case _ => println("a message was received")
  }
}

class TestActor2 extends Actor {
  def receive = {
    case s:String => println("Message Received: " + s)
    case _ => println("TestActor2 got an unknown message")
  }
  override def postStop { println("TestActor2::postStop called") }
}



class TestActor3 extends Actor {
  def receive = {
    case _ => println("TestActor3 got message")
  }
  override def postStop { println("TestActor3: postStop") }
}

class Number5 extends Actor {
  def receive = {
    case _ => println("Number5 got a message")
  }

  override def preStart { println("Number5 is alive") }
  override def postStop { println("Number5::postStop called") }
  override def preRestart(reason: Throwable, message: Option[Any]) {
    println("Number5::preRestart called")
  }
  override def postRestart(reason: Throwable) {
    println("Number5::postRestart called")
  }
}