package main.Game;

import main.GuiController;
import main.Labyrinth;

public class Game {
	private GuiController GUI;
	private Labyrinth labyrinth;
	
	public Game(GuiController GUI)
	{
		this.GUI = GUI;
		this.labyrinth = new Labyrinth(GUI);
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
}
