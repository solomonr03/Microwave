package microwave.view

import javafx.scene.input.MouseEvent
import microwave.controller._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.control.TextField
import scalafx.scene.layout.GridPane

object Microwave extends JFXApp {

  val microwaveModel = new microwave.model.Microwave()

  var textField: TextField = new TextField {
    editable = false
    style = "-fx-font: 26 ariel;"
    this.text.value = doorString(microwaveModel.doorOpen()) + " - " + microwaveModel.currentInstructions()
  }

  stage = new PrimaryStage {
    title = "Calculator"
    scene = new Scene() {
      content = List(
        new GridPane {
          hgap = 0.0
          vgap = 0.0

          add(textField, 0, 0, 4, 1)
          add(new MicrowaveButton("power level", new PowerLevelAction(microwaveModel)), 0, 1)
          add(new MicrowaveButton("cook time", new CookTimeAction(microwaveModel)), 1, 1)
          add(new MicrowaveButton("start", new StartAction(microwaveModel)), 2, 1)
          add(new MicrowaveButton("clear", new ClearAction(microwaveModel)), 3, 1)
          add(new MicrowaveButton("+30 seconds", new ThirtySecondsAction(microwaveModel), yScale = 2.0), 3, 2, 1, 2)
          add(new MicrowaveButton("popcorn", new PopcornAction(microwaveModel), yScale = 2.0), 3, 4, 1, 2)

          add(new MicrowaveButton("7", new NumberAction(microwaveModel, 7)), 0, 2)
          add(new MicrowaveButton("8", new NumberAction(microwaveModel, 8)), 1, 2)
          add(new MicrowaveButton("9", new NumberAction(microwaveModel, 9)), 2, 2)
          add(new MicrowaveButton("4", new NumberAction(microwaveModel, 4)), 0, 3)
          add(new MicrowaveButton("5", new NumberAction(microwaveModel, 5)), 1, 3)
          add(new MicrowaveButton("6", new NumberAction(microwaveModel, 6)), 2, 3)
          add(new MicrowaveButton("1", new NumberAction(microwaveModel, 1)), 0, 4)
          add(new MicrowaveButton("2", new NumberAction(microwaveModel, 2)), 1, 4)
          add(new MicrowaveButton("3", new NumberAction(microwaveModel, 3)), 2, 4)
          add(new MicrowaveButton("0", new NumberAction(microwaveModel, 0), xScale = 2.0), 0, 5, 2, 1)

          add(new MicrowaveButton("close door", new CloseDoorAction(microwaveModel)), 2, 5)
          add(new MicrowaveButton("open door", new OpenDoorAction(microwaveModel)), 2, 6)
        }
      )
    }

    addEventFilter(MouseEvent.MOUSE_CLICKED, (_: MouseEvent) => {
      textField.text.value = doorString(microwaveModel.doorOpen()) + " - " + microwaveModel.currentInstructions()
    })

  }


  def doorString(doorOpen: Boolean): String = {
    if (doorOpen) {
      "The door is open"
    } else {
      "The door is closed"
    }
  }


}
