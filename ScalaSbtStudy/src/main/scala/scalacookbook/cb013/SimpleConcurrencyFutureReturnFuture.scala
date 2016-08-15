package scalacookbook.cb013

import scala.concurrent.{Await, Future, future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

/**
  * Creating a method to return a Future[T]
  *
  * Created by liguodong on 2016/8/14.
  */
object SimpleConcurrencyFutureReturnFuture extends App{

  implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = future {
    sleep(100)
    i + 1
  }

  // this does not block
  longRunningComputation(11).onComplete {
    case Success(result) => println(s"result = $result")
    case Failure(e) => e.printStackTrace
  }

  // keep the jvm from shutting down
  sleep(1000)

  println("End...")


  //The future method shown in this example is another way to create a future.
  // It starts the computation asynchronously and returns a Future[T]
  // that will hold the result of the computation.

  def sleep(time: Long) { Thread.sleep(time) }
}
