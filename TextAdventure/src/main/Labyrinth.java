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
	
	private Random r = new Random();
	private int Chance =50;
	
	
	private boolean Luck() {
		if (r.nextInt(100) >= Chance) {
			return false;
		}
		else {
			return true;
		}
			
	}
	//private Random random = new Random();
	//
	//System.out.println(random.nextInt(10));
	
	//maikymaus zieht sein höschen aus!!!
	
	// 
	
	public Labyrinth(GuiController guiController) {
		this.guiController = guiController;
		
		
		
		
		
		newRoom = new Room("w",null,null,null,null,x,y);
		
		dungeon.add(newRoom);
		
		//previousRoom=newRoom;
		//doorAufruf();
		//newRoom = new Room("f",null,null,null,null,x,y);
		doorEastControl();
		
		System.out.println(dungeon.toString());
		
		changeRoom(newRoom);
	}
	//private void doorAufruf(){
		//doorEastControl();
	//}
	
	private void doorEastControl() {
		if(Luck()==true){
		for (Room pRoom : dungeon) {
			if (pRoom.getX() == x++ && pRoom.getY() == y) {//überprüfen ob ein raum auf den koordinaten liegt
				newRoom.setWest(pRoom);
				pRoom.setEast(newRoom);//rÄume verbinden
			}
			else {
				previousRoom=newRoom;
				
				previousRoom.getX();
				x++;
				newRoom.setX(x);;
				
				newRoom = new Room("f",null,null,null,null,x,y);
				dungeon.add(newRoom);
				
				newRoom.setWest(pRoom);
				pRoom.setEast(newRoom);
				
			}
		}
	}
		doorSouthControl();
	}
	private void doorSouthControl() {
		if(Luck()==true){
		for (Room pRoom : dungeon) {
			if (pRoom.getX() == x && pRoom.getY() == y--) {//überprüfen ob ein raum auf den koordinaten liegt
				newRoom.setNorth(pRoom);
				pRoom.setSouth(newRoom);//raume verbinden
			}
			else {
				previousRoom=newRoom;
				
				previousRoom.getY();
				y--;
				newRoom.setY(y);;
				
				newRoom = new Room("f",null,null,null,null,x,y);
				dungeon.add(newRoom);
				
				newRoom.setNorth(pRoom);
				pRoom.setSouth(newRoom);
			}
		}
		}
		doorWestControl();
	}
	private void doorWestControl() {
		if(Luck()==true){
		for (Room pRoom : dungeon) {
			if (pRoom.getX() == x-- && pRoom.getY() == y) {//überprüfen ob ein raum auf den koordinaten liegt
				newRoom.setEast(pRoom);
				pRoom.setWest(newRoom);//raume verbinden
			}
			else {
			previousRoom=newRoom;
			
			
			previousRoom.getX();
			x--;
			newRoom.setX(x);;
			
			newRoom = new Room("f",null,null,null,null,x,y);
			dungeon.add(newRoom);
			
			newRoom.setEast(pRoom);
			pRoom.setWest(newRoom);
			}
		}
		doorNorthControl();
	}
	}
	private void doorNorthControl() {
		if(Luck()==true){
		for (Room pRoom : dungeon) {
			if (pRoom.getX() == x && pRoom.getY() == y++) {//überprüfen ob ein raum auf den koordinaten liegt
				newRoom.setSouth(pRoom);
				pRoom.setNorth(newRoom);//raume verbinden
			}
			else {
				previousRoom=newRoom;
				
				previousRoom.getY();
				y++;
				newRoom.setY(y);;
				
				newRoom = new Room("f",null,null,null,null,x,y);
				dungeon.add(newRoom);
				
				newRoom.setSouth(pRoom);
				pRoom.setNorth(newRoom);
			}
		}
		}
		//doorEastControl();
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
