package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestCookTime extends FunSuite {

  test("Enter Time Cook") {
    val microwave: Microwave = new Microwave()

    microwave.thirtySecondsPressed()

    assert(microwave.currentInstructions().cookTime == 30)

    microwave.clearPressed()
    microwave.numberPressed(3)
    microwave.numberPressed(0)

    assert(microwave.currentInstructions().cookTime == 0)

    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 30)

    microwave.clearPressed()
    microwave.thirtySecondsPressed()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 30)

    microwave.thirtySecondsPressed()

    assert(microwave.currentInstructions().cookTime == 60)

    microwave.clearPressed()

    microwave.clearPressed()
    microwave.numberPressed(1)
    microwave.numberPressed(0)
    microwave.numberPressed(2)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 102)

    microwave.clearPressed()
    microwave.numberPressed(3)
    microwave.numberPressed(4)
    microwave.numberPressed(5)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 345)

    microwave.clearPressed()
    microwave.numberPressed(6)
    microwave.numberPressed(7)
    microwave.numberPressed(8)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 678)

    microwave.clearPressed()
    microwave.numberPressed(9)
    microwave.numberPressed(0)
    microwave.numberPressed(0)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 900)








  }

}
