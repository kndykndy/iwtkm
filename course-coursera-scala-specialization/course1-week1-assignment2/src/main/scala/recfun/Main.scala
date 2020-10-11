package recfun

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Main {

  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  // Pascal block

  def pascal(c: Int, r: Int): Int = {

    def getNextRow(prevRow: ListBuffer[Int]): ListBuffer[Int] = {
      if (prevRow == null || prevRow.isEmpty)
        ListBuffer[Int](1)
      else if (prevRow.length == 1)
        ListBuffer[Int](1, 1)
      else {
        val result: ListBuffer[Int] = ListBuffer[Int](1)
        for (i <- 0 to prevRow.length - 2)
          result += (prevRow.apply(i) + prevRow.apply(i + 1))
        result += 1
        result
      }
    }

    // Function written not in functional style
    def getRowNonFunctional(r: Int): ListBuffer[Int] = {
      var i: Int = 0
      var prevRow: ListBuffer[Int] = null

      while (i <= r) {
        prevRow = getNextRow(prevRow)
        i = i + 1
      }

      prevRow
    }

    def getRow(currentRow: ListBuffer[Int], currentRowIdx: Int, targetRowIdx: Int): ListBuffer[Int] = {
      if (currentRowIdx == targetRowIdx - 1)
        getNextRow(currentRow)
      else
        getRow(getNextRow(currentRow), currentRowIdx + 1, targetRowIdx)
    }

    getRow(null, -1, r) apply c
  }

  // Function written not in functional style
  def balanceWithoutRecursion(chars: List[Char]): Boolean = {

    var parCnt: Int = 0

    for (i <- chars.indices) {
      if (chars.apply(i) == '(') parCnt = parCnt + 1
      if (chars.apply(i) == ')') parCnt = parCnt - 1

      if (parCnt < 0) return false
    }

    parCnt == 0

  }

  // Parenthesis balance block

  def balance(chars: List[Char]): Boolean = {

    @tailrec
    def balanceSub(parCnt: Int, chars: List[Char]): Boolean = {
      if (parCnt < 0) return false
      if (chars == null || chars.isEmpty) return parCnt == 0

      balanceSub(
        if (chars.head == '(') parCnt + 1 else if (chars.head == ')') parCnt - 1 else parCnt,
        chars.tail)
    }

    balanceSub(0, chars)

  }

  // Money coin change problem block

  def countChangeWithoutTailRecursion(money: Int, coins: List[Int]): Int = {

    val sortedCoins = coins.sorted

    def countChangeSub(money: Int, coinIdx: Int): Int = {
      if (money == 0) return 1
      if (money < 0 || coins.isEmpty) return 0

      var combosCnt: Int = 0
      for (coin <- coinIdx until sortedCoins.length) {
        combosCnt = combosCnt + countChangeSub(money - sortedCoins.apply(coin), coin)
      }

      combosCnt
    }

    countChangeSub(money, 0)

  }

  def countChange(money: Int, coins: List[Int]): Int = {

    def countChangeSub(money: Int, coins: List[Int]): Int = {
      if (money < 0 || coins.isEmpty) 0
      else if (money == 0) 1
      else countChangeSub(money, coins.tail) + countChangeSub(money - coins.head, coins)

    }

    countChangeSub(money, coins.sorted)

  }

}
