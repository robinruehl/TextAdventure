package main;

import javafx.scene.control.Button;

public class InventarButton extends Button {
	private Integer buttonID;

	public int getButtonID() {
		return buttonID;
	}

	public void setButtonID(int buttonID) {
		this.buttonID = buttonID;
	}
	
	public String toString() {
		return buttonID.toString();
	}

}
