package cb005


/**
 * Created by liguodong on 2016/7/4.
 */
object UseParamNameCallMethod extends App{


  val p = new part4.Pizza

  p.update(crustSize = 16, crustType = "Thick")
  println(p)

  p.update(crustType = "Pan", crustSize = 14)
  println(p)

}

package part4{

  class Pizza {
    var crustSize = 12
    var crustType = "Thin"
    def update(crustSize: Int, crustType: String) {
      this.crustSize = crustSize
      this.crustType = crustType
    }
    override def toString = {
      "A %d inch %s crust pizza.".format(crustSize, crustType)
    }
  }
}

