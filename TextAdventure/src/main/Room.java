package main;

public class Room {
	private String description;
	private Room north;
	private Room east;
	private Room south;
	private Room west;
	
	public Room() {
		description = "Dieser Raum ist öde und leer.";
	}
	
	public Room(String description, Room north, Room east, Room south, Room west) {
		this.description = description;
		this.north = north;
		this.east = east;
		this.south = south;
		this.west = west;
	}
	
	public String getDescprition() {
		return description;
	}
	
	public void setNorth(Room north) {
		this.north = north;
	}
	
	public void setSouth(Room south) {
		this.south = south;
	}
	
	public void setEast(Room east) {
		this.east = east;
	}
	
	public void setWest(Room west) {
		this.west = west;
	}

	public Room getEastRoom() {
		return east;
	}
	
	public Room getSouthRoom() {
		return south;
	}
	
	public Room getWestRoom() {
		return west;
	}
	
	public Room getNorthRoom() {
		return north;
	}
}
