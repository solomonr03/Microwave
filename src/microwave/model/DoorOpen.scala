package microwave.model

class DoorOpen(microwave: Microwave) extends State(microwave) {

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
    microwave.state = new CookTime(microwave)
  }
  def startPressed(): Unit = {
  }
  def powerLevelPressed(): Unit = {
    microwave.state = new PowerLevelOpen(microwave)
  }
  def cookTimePressed(): Unit = {
    microwave.storeCt = "0"
  }
  def thirtySecondsPressed(): Unit = {
    microwave.storeCt = (microwave.storeCt.toInt+30).toString
  }
  def popcornPressed(): Unit = {
    microwave.storeCt = "140"
    microwave.storePL = 100
  }
  def clearPressed(): Unit = {
    microwave.storeCt = "0"
    microwave.storePL = 100
  }
  def numberPressed(number: Int): Unit = {
    microwave.storeCt = microwave.storeCt + number.toString
  }

}
