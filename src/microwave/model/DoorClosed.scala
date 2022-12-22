package microwave.model

class DoorClosed(microwave: Microwave) extends State(microwave){


  def currentInstructions(): Instructions = {
    new Instructions(0,0)
  }
  def doorOpen(): Boolean = {
    microwave.storeBool
  }
  def openDoor(): Unit = {
    microwave.storeBool = true
    microwave.state = new DoorOpen(microwave)
  }
  def closeDoor(): Unit = {
    microwave.storeBool = false
    microwave.state = new DoorClosed(microwave)
  }
  def startPressed(): Unit = {
    microwave.state = new Running(microwave)
  }
  def powerLevelPressed(): Unit = {
    microwave.state = new PowerLevel(microwave)
  }
  def cookTimePressed(): Unit = {
    microwave.storeCt = "0"
    microwave.state = new CookTime(microwave)
  }
  def thirtySecondsPressed(): Unit = {
    microwave.storeCt = "30"
    microwave.state = new Running(microwave)
  }
  def popcornPressed(): Unit = {
    microwave.storeCt = "140"
    microwave.storePL = 100
    microwave.state = new Running(microwave)
  }
  def clearPressed(): Unit = {
    microwave.storeCt = "0"
    microwave.storePL = 100
    microwave.state = new CookTime(microwave)
  }
  def numberPressed(number: Int): Unit = {
    microwave.storeCt = microwave.storeCt + number.toString
    microwave.state = new CookTime(microwave)
  }

}
