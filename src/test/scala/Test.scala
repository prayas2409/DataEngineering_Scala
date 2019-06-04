//import org.


object Test {

  def Tester(x: Int): Int ={
    x*x
  }

  def Tester(x:String): String={
    x+x
  }

  def main(args: Array[String]): Unit = {
    println(Tester(5))
    println(Tester("Hello "))
  }
}
