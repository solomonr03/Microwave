package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestCookTime extends FunSuite {

  // Example test case
  test("Enter Time Cook") {
    val microwave: Microwave = new Microwave()

    microwave.numberPressed(3)
    microwave.numberPressed(0)

    assert(microwave.currentInstructions().cookTime == 0)

    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 30)

  }

}
