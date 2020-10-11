package recursion

object BasicFactorial {

  def exec(n: Int): Int = {
    if (n == 0) 1 else n * exec(n - 1)
  }

}
