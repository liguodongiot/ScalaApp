package cb005

import java.io.IOException
import javax.sound.sampled.{UnsupportedAudioFileException, LineUnavailableException}

/**
 * Created by liguodong on 2016/7/4.
 */
object DeclareMethodThrowException {


  //To declare that one exception can be thrown
  @throws(classOf[Exception])
  def play {
    // exception throwing code here ...
  }


  //To indicate that a method can throw multiple exceptions
  @throws(classOf[IOException])
  @throws(classOf[LineUnavailableException])
  @throws(classOf[UnsupportedAudioFileException])
  def playSoundFileWithJavaAudio {
    // exception throwing code here ...
  }
}
