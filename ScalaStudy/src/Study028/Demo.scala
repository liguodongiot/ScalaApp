package Study028

/**
  * 提取器Extractor
  * Created by liguodong on 2015/11/20.
  */
object Demo {
  def main(args: Array[String]) {

    val pattern = "([0-9]+) ([a-z]+)".r

    "203040 spark" match{
      case pattern(num, item) => println(num+" : "+item) //查看源码
    }


    /*  spark源码
      def unapplySeq(s: CharSequence): Option[List[String]] = s match {
        case null => None
        case _    =>
          val m = pattern matcher s
          if (runMatcher(m)) Some((1 to m.groupCount).toList map m.group)
          else None
      }
     */

    val p1 = "ab*c".r
    val p1Matches = "abbbc" match {
      case p1() => true               // no groups
      case _    => false
    }
    println(p1Matches)


    val p2 = "a(b*)c".r
    val p2Matches = "abbbc" match {
      //case p2(_*) => true             // any groups
      case p2(_*) => true
      case _      => false
    }
    println(p2Matches)

    val numberOfB = "abbbc" match {
      //case p2(b) => Some(b.length)    // one group
      case p2(b) => Some(b)
      case _     => None
    }
    println("numberOfB:"+numberOfB)

    val p3 = "b*".r.unanchored
    val p3Matches = "abbbc" match {
      case p3() => true               // find the b's
      //case p3() => Some(b)
      case _    => false
    }
    println(p3Matches)

    val p4 = "a(b*)(c+)".r
    val p4Matches = "abbbcc" match {
      case p4(_*) => true             // multiple groups
      case _      => false
    }
    println(p4Matches)

    val allGroups = "abbbcc" match {
      case p4(all @ _*) => all mkString "/" // "bbb/cc"
      case _            => ""
    }
    println(allGroups)

    val cGroup = "abbbcc" match {
      case p4(_, c) => c
      case _        => ""
    }
    println(cGroup)

  }

  def match_array(arr:Any) = arr match{
    case Array(0) => println("Array：[" + "0]")
    case Array(x,y) => println("Array：[" + x + " " + y + "]")
    case Array(0,_*) => println("Array：" + "[0 ...]") //有1个或者多个元素，并且元素开头为0
    case _ => println("something else")
  }

}
