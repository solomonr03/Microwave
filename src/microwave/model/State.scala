package microwave.model

abstract class State(microwave: Microwave) {

  def currentInstructions(): Instructions
  def doorOpen(): Boolean
  def openDoor()
  def closeDoor()
  def startPressed()
  def powerLevelPressed()
  def cookTimePressed()
  def thirtySecondsPressed()
  def popcornPressed()
  def clearPressed()
  def numberPressed(number: Int)

}
