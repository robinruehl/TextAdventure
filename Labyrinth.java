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
		
		centralRoom = new Room("Als dudurch die T�r kommst, siehst du einen weiteren leeren und mit Fackeln m��ig erhellten  Raum. Vier  T�ren befinden sich an den W�nden.", null, null, null, null);
		northRoom = new Room("Die W�nde bestehen aus grob behauenen Sein,Wasser tropft �berlaut von der Decke... Ein wildes Grollen ert�nt in der Ferne. Doch ansonsten ist der Raum leer...", null, null, centralRoom, null);
		eastRoom = new Room("Ein Kamin in der Ecke k�nnte W�rme und Licht spenden, doch der Schonstein ist eingest�rzt. Es bleibt dunkel und nasskalt...", null, null, null, centralRoom);
		southRoom = new Room("Du sp�rst einen Luftzug,  als du den Raum betrittst und voller Vorfreude st�rmst du hinein... Doch alles, was du entdecken kannst ist ein Spalt in der felsigen Wand. Zu eng, um sich hindurchzuzw�ngen...", centralRoom,  null,  null,  null);
		startRoom  = new Room("Du befindest dich in einer d�steren H�hle. An den Seitenw�nden flackert der Schein zahlloser Fackel. Es gibt nur einen Weg: Und der ist vorw�rts.", null, centralRoom,  null, null);
		
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
