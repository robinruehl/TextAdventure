package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labyrinth {
	private Room startRoom;
	private Room centralRoom;
	
	private Room currentRoom;
	private Room previousRoom;
	private Room newRoom;
	
	private int x=0;
	private int y=0;
	private GuiController guiController;
	
	private List<Room> dungeon = new ArrayList<>();
	
	
	
	//private Random random = new Random();
	//
	//System.out.println(random.nextInt(10));
	
	
	
	public Labyrinth(GuiController guiController) {
		this.guiController = guiController;
		
		
		
		
		
		newRoom = new Room("w",null,null,null,null,x,y);
		
		dungeon.add(newRoom);
		
		previousRoom=newRoom;
		
		newRoom = new Room("w",null,null,null,null,x,y);
		
		
		System.out.println(dungeon);
		
	}
	
	private void doorEastControl() {
		for (Room pRoom : dungeon) {
			if (pRoom.getX() == x++ && pRoom.getY() == y) {//überprüfen ob ein raum auf den koordinaten liegt
				newRoom.setEast(pRoom);
				pRoom.setWest(newRoom);//raume verbinden
			}
			
		}
		
		previousRoom.getX();
		x++;
		newRoom.setX(x);;
		
		
			
			
		
		
		
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
