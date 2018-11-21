package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class GuiController {
	Labyrinth labyrinth;
	
	@FXML
	TextArea labelDiscription;
	@FXML
	Button buttonEast;
	@FXML
	Button buttonSouth;
	@FXML
	Button buttonWest;
	@FXML
	Button buttonNorth;
	
	
	public void initialize() {
		labyrinth = new Labyrinth(this);
	}
	
	public void setDiscription(Room room) {
		labelDiscription.setText(room.getDescprition());
	}
	
	public void goEast() {
		labyrinth.changeRoom(labyrinth.getCurrentRoom().getEastRoom());
	}
	
	public void goSouth() {
		labyrinth.changeRoom(labyrinth.getCurrentRoom().getSouthRoom());
	}
	
	public void goWest() { 
		labyrinth.changeRoom(labyrinth.getCurrentRoom().getWestRoom());

	}
	
	public void goNorth() {
		labyrinth.changeRoom(labyrinth.getCurrentRoom().getNorthRoom());

	}
	
}
