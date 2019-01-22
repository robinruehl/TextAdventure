package main.Game;

import main.GuiController;
import main.Labyrinth;
import main.Fights.AbillityTree;
import main.Fights.Fights;
import main.c.PC;

public class Game {
	private GuiController GUI;
	private Labyrinth labyrinth;
	private Fights fights;
	private PC player;
	private AbillityTree ATree;
	public Game(GuiController GUI)
	{
		this.ATree = new AbillityTree();
		this.GUI = GUI;
		this.player = new PC();
		this.labyrinth = new Labyrinth(GUI);
		this.fights = new Fights(GUI, labyrinth.getCurrentRoom(), this);
		fights.setAbillity1(ATree.getStomp());
		fights.setAbillity2(ATree.getFireBurst());
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
			if(i.contains("set"))
			{
				if(i.contains("1"))
				{
					if(i.contains("stomp"))
					{
						fights.setAbillity1(ATree.getStomp());
						GUI.consoleWrite("stomp set");
					}
					if(i.contains("fireburst"))
					{
						fights.setAbillity1(ATree.getFireBurst());
						GUI.consoleWrite("fireburst set");
					}
				}
			}
		}
		if(i.contains("skill"))
		{
			if(i.contains("inc"))
			{
				if(i.contains("1"))
				{
					player.getSkills().skillincr(1, player);
					GUI.consoleWrite("Leben erhöht auf " + player.getMaxHealth());
					GUI.consoleWrite("Skill Punkte " + player.getPerkpoints());
				}
				if(i.contains("2"))
				{
					player.getSkills().skillincr(2, player);
					GUI.consoleWrite("Schaden erhöht auf " + player.getAttackDamage());
					GUI.consoleWrite("Skill Punkte " + player.getPerkpoints());
					}
				if(i.contains("3"))
				{
					player.getSkills().skillincr(3, player);
					GUI.consoleWrite("Glück erhöht auf " + player.getLuck());
					GUI.consoleWrite("Skill Punkte " + player.getPerkpoints());
				}
				if(i.contains("4"))
				{
					player.getSkills().skillincr(4, player);
					GUI.consoleWrite("Intelligenz erhöht auf " + player.getIntelligence());
					GUI.consoleWrite("Skill Punkte " + player.getPerkpoints());
				}
			}
		}
	}
	
	public PC getPlayer() {
		return player;
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
