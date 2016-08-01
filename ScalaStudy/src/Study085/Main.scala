package Study085

/**
 * For表达式
 * Created by liguodong on 2015/12/16.
 */

case class Person(name:String, isMale:Boolean, children:Person*)

object Main {
  def main(args: Array[String]) {
    val lauren = Person("Lauren",false)
    val rocky = Person("Rocky",true)
    val vivian = Person("Vivian",false,lauren,rocky)
    val persons = List(lauren,rocky,vivian)

    //filter 过滤
    val result = persons filter (person => !person.isMale) flatMap(person =>
      (person.children map (child => (person.name, child.name))))
    println(result)


    val forResult = for(person <- persons; if !person.isMale; child <- person.children)
      yield (person.name,child.name)

    println(forResult)



  }
}
