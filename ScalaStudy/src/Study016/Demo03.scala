package Study016

/**
  * Scala隐式引用
  *
  * import java.lang._  //java.lang包
  * import scala._      //scala包的所有东西
  * import Predef._     //Predef对象的所有东西
  * Created by liguodong on 2015/11/18.
  */

//只引入需要的内容（类）
import java.awt.{color,Font}

//避免scala与java中的命名冲突，取一个别名
import java.util.{HashMap=>JavaHashMap}

//如果不想使用某个类（即将某个类隐藏掉）
import scala.{StringBuilder =>_}

object Demo03 {

}
