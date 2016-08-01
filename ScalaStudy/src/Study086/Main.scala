package Study086

/**
 * For表达式的生成器，定义和过滤器
 * Created by liguodong on 2015/12/16.
 */
case class Person(name:String, isMale:Boolean, children:Person*)

object Main {
  def main(args: Array[String]) {
    val lauren = Person("Lauren",false)
    val rocky = Person("Rocky",true)
    val jason = Person("Jason",true)
    val vivian = Person("Vivian",false,lauren,rocky)
    val koko = Person("Vivian",false,jason)

    val persons = List(lauren,rocky,vivian,koko)

    /**
     * person <- persons; 生成器
     * name= person.name; 定义
     * if !person.isMale; 过滤器
     */
    val forResult = for(person <- persons; name= person.name; if !person.isMale; child <- person.children)
      yield (name,child.name)

    println(forResult)


    val content = for(x <- List(1,2,3); y <- List("Hadoop","Spark","Flink")) yield (x,y)
    println(content)


  }
}
