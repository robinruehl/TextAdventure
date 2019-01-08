package main.Game;

import main.GuiController;
import main.Labyrinth;
import main.Fights.Fights;

public class Game {
	private GuiController GUI;
	private Labyrinth labyrinth;
	private Fights fights;
	public Game(GuiController GUI)
	{
		this.GUI = GUI;
		this.labyrinth = new Labyrinth(GUI);
		main();
	}
 
	private void main()
	{
		GUI.consoleWrite("|.  Der Name des \"Spiels\"  .|");
		labyrinth.changeRoom(labyrinth.getStartRoom());
	}
	
	public void inputHandler(String i)
	{
		//test
		if(i.contains("test"))
		{
			if(i.contains("Fights"))
			{
				fights = new Fights(GUI, labyrinth.getCurrentRoom());
				fights.Fight();
			}
		}
		//fights
		if(i.contains("fight"))
		{
			if(i.contains("attack1"))
			{
				fights.attack1();
			}
			if(i.contains("attack2"))
			{
				fights.attack2();
			}
		}
	}
	
	public GuiController getGUI() {
		return GUI;
	}

	public void setGUI(GuiController gUI) {
		GUI = gUI;
	}

	public Labyrinth getLabyrinth() {
		return labyrinth;
	}

	public void setLabyrinth(Labyrinth labyrinth) {
		this.labyrinth = labyrinth;
	}

	public Fights getFights() {
		return fights;
	}

	public void setFights(Fights fights) {
		this.fights = fights;
	}
}
