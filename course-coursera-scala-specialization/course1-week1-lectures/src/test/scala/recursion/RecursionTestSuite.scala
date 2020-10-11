package recursion

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RecursionTestSuite extends FunSuite {

  test("Tail-recursive factorial of 1 is 1") {
    assert(ImprovedFactorial.exec(1) === 1)
  }
  test("Tail-recursive factorial of 2 is 2") {
    assert(ImprovedFactorial.exec(2) === 2)
  }
  test("Tail-recursive factorial of 3 is 6") {
    assert(ImprovedFactorial.exec(3) === 6)
  }
  test("Tail-recursive factorial of 4 is 24") {
    assert(ImprovedFactorial.exec(4) === 24)
  }

}
