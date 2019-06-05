package Week1
import scala.concurrent.duration._

object Stopwatch {

    def stopwatch_demo(): Unit ={
      var start: Float = System.nanoTime()
      for (i <-1 to 10 ){
        print(" "+i)
      }
      println()
      var stop = System.nanoTime()
      println(stop - start)
      println((stop-start).nanos)
    }

  def main(args: Array[String]): Unit = {
    stopwatch_demo()
  }
}
