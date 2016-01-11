package Study016


/**
  * 包的嵌套
  * Created by liguodong on 2015/11/17.
  */
object Demo {

}

package hadoop{
  package navigation{
    class Navigator
  }

  package launch{
    class Booster{
      val nav = new navigation.Navigator
    }

  }
}

//包是链式结构，支持包的嵌套。
package spark.navigation{

  abstract class Navigator{
    def act
  }

  //测试包
  package tests{
    //在spark.navigation.tests包里
    class NavigatorSuite
  }

  //实现包
  package impls{
    class Action extends Navigator{
      override def act: Unit = println("哈哈")
    }
  }
}

