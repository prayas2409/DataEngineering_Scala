package Week1
import scala.io.StdIn._

object Leapyear {

  def main(args: Array[String]): Unit ={

    var year : Int = 0
    do{
      println("Enter the year as 4 digit number")
      year = readLine().toInt
    }while(!(year > 999 && year<10000))

    if (year % 100==0){
      if(year%400==0){
        println("The year is prime")
        return
      }
      else println("year is not prime")
    }else if(year % 4 ==0 ){
      print("year is prime")
      return
    }
    else println("year is not prime")
  }
}
