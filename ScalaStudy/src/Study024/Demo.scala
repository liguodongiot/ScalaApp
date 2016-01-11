package Study024

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.{JButton, JFrame}

/**
  * SAM转换
  *
  * 在Scala中，要某个函数做某件事时，会传一个函数参数给它。
  * 而在Java中，并不支持传送参数。
  * 通常Java的实现方式是将动作放在一个实现某接口的类中，然后将该类的一个实例传递给另一个方法。
  * 很多时候，这些接口只有单个抽象方法（single abstract method），在Java中被称为SAM类型。
  * Created by liguodong on 2015/11/20.
  */
object Demo {
  def main(args: Array[String]) {

    var data = 0
    val frame = new JFrame("SAM Testing")
    val jButton = new JButton("Counter")
    /*------------*/
    //Java方式
    /*jButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent) {
        data += 1
        println(data)
      }
    })*/

    /*------------*/
    //Scala方式

    //隐式转换就是将一种类型自动转换成另外一种类型，是个函数。
    // 因为在Scala中，函数是头等公民，所以隐式转换的作用也大大放大了。
    implicit def convertedAction(action: (ActionEvent)=>Unit ) =
    new ActionListener {
      override def actionPerformed(event: ActionEvent) {
        action(event)
      }
    }

    //给按钮添加监听器的代码。其实只要给addActionListener传一个 函数参数 ，也就能够实现一样的功能了。
    //为了使这个语法真的生效，需要提供一个隐式转换。
    jButton.addActionListener( (event: ActionEvent) => {data+=1; println(data)} )

    /*------------*/

    frame.setContentPane(jButton)
    frame.pack()
    frame.setVisible(true)


  }
}
