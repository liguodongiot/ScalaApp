package cb007

/**
  * Created by liguodong on 2016/7/17.
  */
object UseImportStatementsAnywhere extends App{

}

package foo{
  //import members inside a class
  import java.util

  import scala.util.Random
  class ImportTests {
    def printRandom {
      val r = new Random
    }


    def getRandomWaitTimeInMinutes: Int = {
      //limit the scope of an import to a method
      import java.util.ArrayList
      val p = new ArrayList
      p.size()
    }
  }



}
