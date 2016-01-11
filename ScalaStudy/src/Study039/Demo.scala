package Study039

import scala.collection.mutable


/**
 * ListBuffer ArrayBuffer Queue Stack
 *
 * Created by liguodong on 2015/11/30.
 */
object Demo {

  def main(args: Array[String]) {
    //可变
    import scala.collection.mutable.ListBuffer
    val listBuffer = new ListBuffer[Int]
    listBuffer += 1
    listBuffer += 2
    println(listBuffer)

    //可变
    import scala.collection.mutable.ArrayBuffer
    val arrayBuffer = new ArrayBuffer[Int]
    arrayBuffer += 1
    arrayBuffer += 2
    println(arrayBuffer)

    //不可变
    import scala.collection.immutable
    val empty = immutable.Queue[Int]()
    val queue1 = empty.enqueue(1)
    val queue2 = queue1.enqueue(List(2,3,4,5))
    println(queue2)

    val (element,left) = queue2.dequeue
    println(element+" : "+left)


    import scala.collection.mutable.Queue
    val queue = Queue[String]()
    queue += "Scala"
    queue ++= List("Spark","Hadoop")
    println(queue)
    println(queue.dequeue())
    println(queue)


    import scala.collection.mutable.Stack
    val stack = new Stack[Int]()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println(stack.top)
    println(stack)
    println(stack.pop)
    println(stack)



  }

}
