package Study071

import scala.swing._

/**
 * 界面编程Panel,Layout
 * Created by liguodong on 2015/12/14.
 */

object Main extends SimpleSwingApplication {
  override def top: Frame = new MainFrame{
    title = "GUI界面"
    val button = new Button{ text = "Scala" }
    val label = new Label{ text = "Here is Spark!!!"}

    contents = new BoxPanel(Orientation.Vertical){
      contents += button
      contents += label
      border = Swing.EmptyBorder(50,50,50,50)
    }
  }

}
