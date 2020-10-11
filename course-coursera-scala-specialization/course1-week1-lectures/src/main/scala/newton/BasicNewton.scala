package newton

/* This implementation (basic) Newton method has two problems:
 * - bad precision for the small numbers
 * - going into loops for large numbers
 *
 * These problems are fixed in the improved version.
 **/
object BasicNewton {

  val INITIAL_GUESS: Double = 1.0
  val GOOD_ENOUGH_THRESHOLD: Double = 0.001

  private def isGuessGoodEnough(guess: Double, x: Double) =
    scala.math.abs(guess * guess - x) <= GOOD_ENOUGH_THRESHOLD

  private def improveGuess(guess: Double, x: Double) = (guess + x / guess) / 2

  private def sqrtIteration(guess: Double, x: Double): Double =
    if (isGuessGoodEnough(guess, x)) guess
    else sqrtIteration(improveGuess(guess, x), x)

  def sqrt(x: Double): Double = sqrtIteration(INITIAL_GUESS, x)

}
