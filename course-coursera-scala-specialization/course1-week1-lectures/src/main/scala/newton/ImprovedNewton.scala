package newton

/*
* 1. Improved sqrt by normalizing absolute value within isGuessGoodEnough function
* 2. Moved all dependant functions to a block
* 3. Removed unnecessary abs function
* 4. Removed unnecessary x argument within most functions
* */
object ImprovedNewton {

  val INITIAL_GUESS: Double = 1.0
  val GOOD_ENOUGH_THRESHOLD: Double = 0.00001

  def sqrt(x: Double): Double = {

    def isGuessGoodEnough(guess: Double) =
      scala.math.abs(guess * guess - x) / x <= GOOD_ENOUGH_THRESHOLD

    def improveGuess(guess: Double) = (guess + x / guess) / 2

    def sqrtIteration(guess: Double): Double =
      if (isGuessGoodEnough(guess)) guess
      else sqrtIteration(improveGuess(guess))

    sqrtIteration(INITIAL_GUESS)

  }

}
