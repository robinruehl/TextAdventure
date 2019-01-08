package main.Fights;

import java.util.Random;

import main.GuiController;
import main.Room;
import main.c.PC;
import main.c.NPC;

public class Fights {
	
	private boolean yourTurn = false;
	private Random rand = new Random();
	
	private Room Room;
	private GuiController GUI;
	private NPC enemy;
	private PC player;
	
	private int attack1 = 1;
	private int attack2 = 1;
	
	
	public Fights(GuiController GUI, Room Room)
	{
		this.GUI = GUI;
		this.Room = Room;
	}
	
	public void attack1()
	{
		if (attack1==1)
		{
			slash();
		}
		else
		{
			slash();
		}
	}
	
	public void attack2()
	{
		if (attack2==1)
		{
			slash();
		}
		else
		{
			slash();
		}
	}
	/*
	public void isFight(Room Room) {
		if (Room.isEnemy()) 
		{
			System.out.println("n gegner oh nee!");
			Fight();
			}
		}
		else 
		{
			System.out.println("kein gegner o jaaa!");
		}
	}
	*/
	
	public void Fight() {
		testFight();
		//encounter();
		System.out.println("fights");
	}
	
	private void slash() {
		yourTurn = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (player.getHitChance() >= acc) {
        	int temp = player.getAttackDamage();
        	enemy.setHealth(enemy.getHealth()-temp);
        	GUI.consoleWrite("Du triffst " + enemy.getName() + " für " + temp + " Schaden und " + enemy.getName() + " hat noch " + enemy.getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.getAccuracy() >= acc) {
    		int temp = rand.nextInt(enemy.getAttackDamage()/2)+enemy.getAttackDamage()/2;
    		player.setHealth(player.getHealth()-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + player.getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	checkFight();
    }
	
    public void checkFight() {
		if (player.getHealth()<=0) {
			System.out.println("you ded");
		}
		else if (enemy.getHealth()<=0) {
			System.out.println("enemy ded");
		}
		else {
			encounter();
		}
	}
    
    public void testFight()
    {
    	enemy = new NPC(player);
    	player = new PC();
    	encounter();
    }
    
	private void encounter() {
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner " + enemy.getName());
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: " + player.getHealth());
		GUI.consoleWrite("\t Gegner Lebenspunkte: " + enemy.getHealth());
		GUI.consoleWrite("\t Was willst du machen? \n");
		GUI.consoleWrite("\t fight attack1, fight attack2");
		yourTurn = true;
	}
	/*
	public void droppot() {
		int acc;
		acc = rand.nextInt(100);
		if (player.getHitChance() >= acc) {
			player.setHealthPots(player.getHealthPots()+1);
			GUI.consoleWrite("Du has ein Elixir gefunden!");
		}
		
	}*/
}