package Week1

trait Gambler {

  def gamblerGameDemo(stake:Int,goal: Int,games:Int)
}
  class GamblerGame extends Gambler {

    def gamblerGameDemo(stak:Int, goal: Int, games:Int) {
      try {
        //// counter to count till number of games
        var stake : Int = stak
        var counter:Int = 0
        var win:Int  = 0
        var bets:Int  = 0
        //// to generate the random value
        var n:Float = 0

        while ((counter < games) && (stake > 0 && stake < goal)) {
          bets +=1
          n = scala.util.Random.nextFloat()
          //// if random value is > 0.5 we call it as win
          if (n > 0.5) {
            stake += 1
            win +=1
            //// System.out.println(n+" win ");
          } else {
            stake -= 1
            //// System.out.println(n+" loss ");
          }
          counter +=1
        }
        println("The number of wins are: " + win + ", percentage of wins: "
          + (win * 100 / bets + ", bets: " + bets));
      }
      catch {
        case e: Exception =>
          println("The process is stopped because " + e);
        }
      }
  }

object gamblerdemo{
  def main(args: Array[String]){
    var gambler = new GamblerGame()
    gambler.gamblerGameDemo(60,100,50)
//    println("HI")
  }
}