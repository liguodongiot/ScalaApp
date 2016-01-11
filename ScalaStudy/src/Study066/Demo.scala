package Study066

import scala.actors.Actor

/**
 * 并发编程
 * Created by liguodong on 2015/12/9.
 */

object First_Actor extends Actor{
  def act(){
    println(Thread.currentThread().getName)
    for(i<- 1 to 10){
      println("Step : "+i)
      Thread.sleep(2000)
    }
  }
}

object Second_Actor extends Actor{
  def act(){
    println(Thread.currentThread().getName)
    for(i <- 1 to 10){
      println("Step Further : "+i)
      Thread.sleep(1000)
    }
  }
}



object Demo {
  def main(args: Array[String]) {
    First_Actor.start()
    Second_Actor.start

  }
}
