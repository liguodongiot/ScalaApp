package BecomeUnbecome

import akka.actor.{Props, ActorSystem}

/**
  * Created by liguodong on 2015/12/20.
  */
object Main {
  def main(args: Array[String]) {
    val _system = ActorSystem("BecomeUnbecome")
    val sparkFlinkActor = _system.actorOf(Props[SparkFlinkActor])
    sparkFlinkActor ! Spark
    Thread.sleep(2000)
    _system.shutdown()

  }
}
