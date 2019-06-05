package Week1

object Distance {

  def distanceDemo(x: Int, y: Int): Unit = {
    try //// int x,y
    //System.out.println("Enter the vales of x and y");
    System.out.println("The distance from 0,0 to the current point is " + scala.math.sqrt(x * x + y * y))
    catch {
      case e: Exception =>
        System.out.println("The process is stopped because " + e)
    }
  }
  def main(args: Array[String]): Unit ={
    distanceDemo(3,4)
  }
}
