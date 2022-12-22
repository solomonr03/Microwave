package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestPowerLevel extends FunSuite {

  test("Enter PowerLevel"){
    val microwave: Microwave = new Microwave()

    microwave.numberPressed(5)
    microwave.numberPressed(5)
    microwave.powerLevelPressed()
    microwave.numberPressed(5)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 55 && microwave.currentInstructions().powerLevel == 50)

    microwave.clearPressed()
    microwave.numberPressed(5)
    microwave.numberPressed(5)
    microwave.powerLevelPressed()
    microwave.numberPressed(2)
    microwave.cookTimePressed()
    microwave.numberPressed(2)
    microwave.numberPressed(5)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 25 && microwave.currentInstructions().powerLevel == 20)

    microwave.clearPressed()
    microwave.numberPressed(2)
    microwave.numberPressed(0)
    microwave.powerLevelPressed()
    microwave.numberPressed(6)
    microwave.numberPressed(8)
    microwave.numberPressed(3)
    microwave.cookTimePressed()
    microwave.numberPressed(5)
    microwave.numberPressed(0)
    microwave.numberPressed(0)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 500 && microwave.currentInstructions().powerLevel == 30)
  }

}
