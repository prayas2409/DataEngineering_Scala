package Week1
import scala.io.StdIn._

class HeadandTail {

  def headandTailDemo(): Unit = {
    try {
      var mHead = 0
      var num = 0
      var counter = 0
      var mRandom = 0.0
      System.out.println("Enter the number of times the coin is flipped")
      num = readInt()
      var value = 0.5f
      //// flip coins num number of times
      while ( counter < num) {
        //// generate random numbers between 0 and 1
        mRandom = scala.util.Random.nextFloat()
        if (mRandom > value) mHead += 1
        counter += 1
      }
      // The result of int /int will be int hence converting 1 of them to float to get
      // answer in decimals
      value = (mHead.toFloat / counter) * 100
      System.out.println("The Percent of head is " + value + " and the percent of tails is " + (100 - value))
    } catch {
      case e: Exception =>
        System.out.println("The process is stopped because " + e)
    }
  }
}

object demo{
  def main(args: Array[String]): Unit = {
    var hat = new HeadandTail()
    hat.headandTailDemo()
  }
}
