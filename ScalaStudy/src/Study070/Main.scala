package Study070

import scala.swing.{Button, MainFrame, Frame, SimpleSwingApplication}


/**
 * Scala界面GUI编程
 * Created by liguodong on 2015/12/14.
 */


object Main extends SimpleSwingApplication{
  override def top = new MainFrame{
    title = "Hello GUI"
    contents = new Button{text = "Scala => Spark!!!"}
  }
}