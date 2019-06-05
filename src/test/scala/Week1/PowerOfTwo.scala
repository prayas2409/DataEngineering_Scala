package Week1
import scala.io.StdIn._

object PowerOfTwo {
  def powerofTwoDemo(pow:Int) {
    try {
      var num:Int = 1;
      var counter = 0;
      var power = pow
      /// power is 0
      if (power == 0) {
        System.out.println("2^0 = 1");
        return;
      }
      //// if out of range
      if (power > 31 || power < 0) {
        while (power > 31 || power < 0) {
          System.out.println("Enter the number more than 0 and less than 32 to get power of 2 ")
          power = readLine().toInt
        }
      }
      println()
      //// printing table so from 1 to 10
      for (i <- 1 to 11) {
        //// printing x 1 for all the powers until required one that is counter by counter
        while (counter < power) {
          num = num * 2;
          if (counter < power) {
            System.out.print(num + "x" + i + "=" + num * i + " ");
          }
          counter+=1;
        }
        System.out.println();
        counter = 0;
        num = 1;
      }
    }
    catch {
      case e: Exception =>
        System.out.println("The process is stopped because " + e);
      }
    }

  def main(args: Array[String]): Unit = {
    PowerOfTwo.powerofTwoDemo(6)
  }

  }
