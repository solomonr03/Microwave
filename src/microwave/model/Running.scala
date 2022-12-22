package microwave.model

class Running(microwave: Microwave) extends State(microwave) {

  def currentInstructions(): Instructions = {
    new Instructions(microwave.storeCt.toInt,microwave.storePL)
  }
  def doorOpen(): Boolean = {
    microwave.storeBool
  }
  def openDoor(): Unit = {
    microwave.state = new DoorOpen(microwave)
    microwave.storeBool = true
  }
  def closeDoor(): Unit = {
    microwave.state = new DoorClosed(microwave)
    microwave.storeBool = false
  }
  def startPressed(): Unit = {
  }
  def powerLevelPressed(): Unit = {
  }
  def cookTimePressed(): Unit = {
  }
  def thirtySecondsPressed(): Unit = {
    microwave.storeCt = (microwave.storeCt.toInt+30).toString
  }
  def popcornPressed(): Unit = {
  }
  def clearPressed(): Unit = {
    microwave.storeCt = "0"
    microwave.storePL = 100
    microwave.state = new CookTime(microwave)
  }
  def numberPressed(number: Int): Unit = {
  }

}
