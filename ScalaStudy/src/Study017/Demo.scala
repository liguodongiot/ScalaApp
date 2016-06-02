package Study017

/**
  * 包，类，对象，成员的访问权限
  * 伴生类和伴生对象的访问权限
  * Created by liguodong on 2015/11/18.
  */
object Demo {

}


package spark{

  package navigation{
    //private限定Navigator的可见度，可以扩展为spark这个包

    //Navigator类对包含在spark包及其子包下面的类和对象可见

    //在spark包及其子包下面的类和对象都可以访问Navigator
    private[spark] class Navigator{

      protected[navigation] def useStarChart(){}

      class LegOfJourney{
        private[Navigator] val distance = 100
      }
      //规定在Navigator类内部，只能有当前对象访问自己
      private[this] var speed = 200
    }
  }

  package  launch{
    import navigation._
    object Vehicle{
      //launch下面的所有内容都可以去访问guide
      private[launch] val guide = new Navigator
    }
  }

  //伴生类与伴生对象
  //伴生对象可以随便访问伴生类
  object PackageOps_Advanced{
    private def power = 10000

    def makeItTrue(p: PackageOps_Advanced): Boolean ={
      val result = p.canMakeItTrue
      result
    }
  }

  //伴生类也可以随便访问伴生对象
  class PackageOps_Advanced{
    import PackageOps_Advanced.power

    private def canMakeItTrue = power > 10001

  }

}

