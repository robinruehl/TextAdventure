package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {
	private Room startRoom;
	private Room centralRoom;
	
	private Room currentRoom;
	
	
	private GuiController guiController;
	
	private List<Room> dungeon = new ArrayList<>();
	
	
	private Random random = new Random();
	
	
	private void Door() {
		if random < 7 ) {
			newRoom = new Room("Neuer Raum!!!", null, null, null, null, x++, y++);
		}
	}
	
	
	
	public Labyrinth(GuiController guiController) {
		this.guiController = guiController;
		
		
		System.out.println(random.nextInt(10));
		
		
		
		
		centralRoom = new Room("Als dudurch die Tür kommst, siehst du einen weiteren leeren und mit Fackeln mäßig erhellten  Raum. Vier  Türen befinden sich an den Wänden.", null, null, null, null, 0, 0);
		
		
		centralRoom.setWest(startRoom);
		
		changeRoom(centralRoom);
	}
	
	public void changeRoom(Room room) {
		currentRoom = room;
		guiController.setDiscription(currentRoom);
		
		if(currentRoom.getEastRoom() == null) {
			guiController.getButtonEast().setDisable(true);
		} else {
			guiController.getButtonEast().setDisable(false);
		}
		
		if(currentRoom.getSouthRoom() == null) {
			guiController.getButtonSouth().setDisable(true);
		} else {
			guiController.getButtonSouth().setDisable(false);
		}
		
		if(currentRoom.getWestRoom() == null) {
			guiController.getButtonWest().setDisable(true);
		} else {
			guiController.getButtonWest().setDisable(false);
		}
		
		if(currentRoom.getNorthRoom() == null) {
			guiController.getButtonNorth().setDisable(true);
		} else {
			guiController.getButtonNorth().setDisable(false);
		}
	}
	
	public Room getCurrentRoom() {
		return currentRoom;
	}
}
