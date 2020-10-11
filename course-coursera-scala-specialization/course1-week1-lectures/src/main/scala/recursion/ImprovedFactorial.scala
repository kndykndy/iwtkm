package recursion

object ImprovedFactorial {

  def exec(n: Int): Int = {

    def execIntl(product: Int, n: Int): Int = {
      if (n == 0) product * 1 else execIntl(product * n, n - 1)
    }

    execIntl(1, n)

  }

}
