package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {

  import Main.pascal

  test("pascal(0, 0) is 1") {
    assert(pascal(0, 0) === 1)
  }

  test("pascal: col=0,row=2") {
    assert(pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1, 3) === 3)
  }

  test("pascal(0, 4) from row 1 4 6 4 1 is 1") {
    assert(pascal(2, 4) === 6)
  }
  test("pascal(1, 4) from row 1 4 6 4 1 is 4") {
    assert(pascal(2, 4) === 6)
  }
  test("pascal(2, 4) from row 1 4 6 4 1 is 6") {
    assert(pascal(2, 4) === 6)
  }
  test("pascal(3, 4) from row 1 4 6 4 1 is 4") {
    assert(pascal(2, 4) === 6)
  }
  test("pascal(4, 4) from row 1 4 6 4 1 is 1") {
    assert(pascal(2, 4) === 6)
  }

}
