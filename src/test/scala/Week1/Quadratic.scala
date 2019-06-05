package Week1

class Quadratic {

   def quadraticDemo(a: Int, b:Int, c:Int) {
    try {
      var delta: Double = 0
      var srt : Double = 0
      var sign: String = ""
      var rt1: Float = 0
      var rt2: Float = 0
      System.out.println("The equation is " + a + "x^2+" + b + "x+" + c + "=0");

      delta = b * b - 4 * a * c;
      //// printing delta
      System.out.println("delta is " + delta);
      srt = Math.sqrt(delta);
      //// if the squre root is imaginary
      if ((Math.sqrt(delta).isNaN)) {
        //// if the sqrt is imaginary root
        delta = -delta;
        srt = scala.math.sqrt(delta)
        rt1 = (srt / 2 * a).toFloat
        rt2 = (-srt / 2 * a).toFloat
        //// to check the sign that has to be used as + - should be - else +
        if (rt2 > 0)
          sign = "-";
        else
          sign = "";

        System.out.printf("The roots of the equations are " + (-b / 2 * a) + "+" + rt1 + "i and" + (-b / 2 * a)
          + sign + rt2 + "i");
      } else {
        //// For real roots
        srt = Math.sqrt(delta);
        rt1 = ((srt - b) / 2 * a).toFloat
        rt2 = ((-srt - b) / 2 * a).toFloat
        System.out.printf("The roots of the equations are " + rt1 + " and " + rt2);
      }
    }
    catch {
      case e :Exception =>
        System.out.println("The process is stopped because " + e);
      }
    }
  }

object quad_demo{

  def main(args: Array[String]): Unit = {
    var quad = new Quadratic()
    quad.quadraticDemo(8,9,10)
  }
}

