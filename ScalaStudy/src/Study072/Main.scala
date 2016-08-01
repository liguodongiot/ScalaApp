package Study072

import scala.swing._
import scala.swing.event.ButtonClicked

/**
 * 事件处理
 * Created by liguodong on 2015/12/14.
 */
object Main extends SimpleSwingApplication{
    def top = new MainFrame{
    title = "Scala GUI"
    val button = new Button{ text = "Scala"}
    val label = new Label{text = "Here is Spark!!!"}
    contents = new BoxPanel(Orientation.Vertical){
      contents += button
      contents += label
      border = Swing.EmptyBorder(50,50,50,50)
    }

    listenTo(button) //监听button

    var clicks = 0
    reactions += { //事件处理
      case ButtonClicked(button) =>{
        clicks += 1
        label.text = "Clicked " + clicks + " times."
      }
    }

  }
}
