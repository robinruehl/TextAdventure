package main;

public class Labyrinth {
	private Room startRoom;
	private Room centralRoom;
	private Room northRoom;
	private Room eastRoom;
	private Room southRoom;
	private Room currentRoom;
	private GuiController guiController;

	public Labyrinth(GuiController guiController) {
		this.guiController = guiController;
		
		centralRoom = new Room("Als dudurch die Tür kommst, siehst du einen weiteren leeren und mit Fackeln mäßig erhellten  Raum. Vier  Türen befinden sich an den Wänden.", null, null, null, null);
		northRoom = new Room("Die Wände bestehen aus grob behauenen Sein,Wasser tropft überlaut von der Decke... Ein wildes Grollen ertönt in der Ferne. Doch ansonsten ist der Raum leer...", null, null, centralRoom, null);
		eastRoom = new Room("Ein Kamin in der Ecke könnte Wärme und Licht spenden, doch der Schonstein ist eingestürzt. Es bleibt dunkel und nasskalt...", null, null, null, centralRoom);
		southRoom = new Room("Du spürst einen Luftzug,  als du den Raum betrittst und voller Vorfreude stürmst du hinein... Doch alles, was du entdecken kannst ist ein Spalt in der felsigen Wand. Zu eng, um sich hindurchzuzwängen...", centralRoom,  null,  null,  null);
		startRoom  = new Room("Du befindest dich in einer düsteren Höhle. An den Seitenwänden flackert der Schein zahlloser Fackel. Es gibt nur einen Weg: Und der ist vorwärts.", null, centralRoom,  null, null);
		
		centralRoom.setEast(eastRoom);
		centralRoom.setNorth(northRoom);
		centralRoom.setSouth(southRoom);
		centralRoom.setWest(startRoom);
	}
	
	public Room getStartRoom() {
		return startRoom;
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
