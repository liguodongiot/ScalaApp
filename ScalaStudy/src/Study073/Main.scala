package Study073

import java.io.File

import scala.swing._
import scala.swing.event.ButtonClicked


/**
 * Scala界面和事件处理编程
 * Created by liguodong on 2015/12/15.
 */
object Main extends SimpleSwingApplication {


  val fileChooser = new FileChooser(new File(".")) //文件选择
  fileChooser.title = "File Chooser"
  val button = new Button{ text = "Choose a file from local"}

  val label = new Label{ text = "No any File from local"}

  val mainPanel = new FlowPanel{
    contents += button
    contents += label
  }

  override def top = new MainFrame{
    title = "Scala GUI Programing advanced!!!"
    contents = mainPanel

    listenTo(button) //监听button

    reactions += {
      case ButtonClicked(b) => { //事件处理
        val result = fileChooser.showOpenDialog(mainPanel) //打开一个对话框
        if(result == FileChooser.Result.Approve){
          label.text = fileChooser.selectedFile.getPath //选择一个文件中将会显示该文件的路径
        }
      }
    }

  }

}
