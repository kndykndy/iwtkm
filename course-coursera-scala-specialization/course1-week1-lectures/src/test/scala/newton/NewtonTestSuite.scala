package newton

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class NewtonTestSuite extends FunSuite {

  test("basic sqrt of 2") {
    assert(BasicNewton.sqrt(2) === 1.4142156862745097)
  }
  test("basic sqrt of 4") {
    assert(BasicNewton.sqrt(4) === 2.0000000929222947)
  }

  test("improved sqrt of 4") {
    assert(ImprovedNewton.sqrt(4) === 2.0000000929222947)
  }
  test("improved sqrt of 0.001") {
    assert(ImprovedNewton.sqrt(0.001) === 0.03162278245070105)
  }
  test("improved sqrt of 0.1e-20") {
    assert(ImprovedNewton.sqrt(0.1e-20) === 3.1622778383672726E-11)
  }
  test("improved sqrt of 1.0e20") {
    assert(ImprovedNewton.sqrt(1.0e20) === 1.0000021484861237E10)
  }
  test("improved sqrt of 1.0e50") {
    assert(ImprovedNewton.sqrt(1.0e50) === 1.0000003807575104E25)
  }

}
