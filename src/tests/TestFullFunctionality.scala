package tests

import microwave.model.Microwave
import org.scalatest.FunSuite

class TestFullFunctionality extends FunSuite {

  test("Enter Anything"){
    val microwave: Microwave = new Microwave

    microwave.numberPressed(1)
    microwave.numberPressed(5)
    microwave.openDoor()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.closeDoor()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 15 && microwave.currentInstructions().powerLevel == 100)

    microwave.openDoor()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.closeDoor()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 15 && microwave.currentInstructions().powerLevel == 100)

    microwave.openDoor()
    microwave.clearPressed()
    microwave.cookTimePressed()
    microwave.numberPressed(9)
    microwave.numberPressed(5)
    microwave.numberPressed(0)
    microwave.powerLevelPressed()
    microwave.numberPressed(4)
    microwave.numberPressed(8)
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.closeDoor()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 950 && microwave.currentInstructions().powerLevel == 80)

    microwave.openDoor()
    microwave.popcornPressed()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.closeDoor()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 140 && microwave.currentInstructions().powerLevel == 100)

    microwave.clearPressed()
    microwave.popcornPressed()

    assert(microwave.currentInstructions().cookTime == 140 && microwave.currentInstructions().powerLevel == 100)

    microwave.clearPressed()

    assert(microwave.currentInstructions().cookTime == 0 && microwave.currentInstructions().powerLevel == 0)

    microwave.numberPressed(1)
    microwave.numberPressed(1)
    microwave.numberPressed(2)
    microwave.openDoor()
    microwave.clearPressed()

    assert(microwave.doorOpen())

    microwave.numberPressed(1)
    microwave.numberPressed(1)
    microwave.numberPressed(2)
    microwave.closeDoor()
    microwave.startPressed()

    assert(microwave.currentInstructions().cookTime == 112 && microwave.currentInstructions().powerLevel == 100)




  }

}
