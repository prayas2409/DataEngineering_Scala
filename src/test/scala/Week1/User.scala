package Week1
import scala.io.StdIn._

object User {
  var sentence = "Hello <<UserName>>, How are you?"

  def main(args: Array[String]): Unit = {
    println("please enter your name")
    var name = readLine()
    sentence = sentence.replace("<<UserName>>",name)
    println(sentence)
  }

}
