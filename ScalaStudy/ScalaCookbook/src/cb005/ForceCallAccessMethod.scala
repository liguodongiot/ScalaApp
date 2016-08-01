package cb005

/**
 * Created by liguodong on 2016/7/4.
 */
object ForceCallAccessMethod extends App{


  val p = new part6.Pizza

  // this fails because of the parentheses
  //p.crustSize()

  // this works
  p.crustSize

  //Discussion


}

package part6{
  class Pizza {
    // no parentheses after crustSize
    def crustSize = 12
  }
}
