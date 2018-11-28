package main;

import java.util.Random;

public class Fights {
	
	private boolean yourTurn = false;
	private Random rand = new Random();
	private float enemyNewMax = 50;
	
	private Room Room;
	private GuiController GUI;
	private NPC enemy;
	private Player player;
	
	private int attack1 = 1;
	private int attack2 = 1;
	
	
	Fights(GuiController GUI, Room Room)
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
	}*/
	
	private void Fight() {
		encounter();
	}
	
	private void slash() {
		yourTurn = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (player.getHitChance() >= acc) {
        	int temp = player.getAttackDamage();
        	enemy.setHealth(enemy.getHealth()-temp);
        	GUI.consoleWrite("Du triffst " + enemy.name + " für " + temp + " Schaden und " + enemy.name + " hat noch " + enemy.health + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.accuracy >= acc) {
    		int temp = rand.nextInt(enemy.maxAttackDMG/2)+enemy.maxAttackDMG/2;
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
		else if (enemy.health<=0) {
			System.out.println("enemy ded");
		}
		else {
			encounter();
		}
	}
    
	private void encounter() {
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner ");
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: ");
		GUI.consoleWrite("\t Gegner Lebenspunkte: ");
		GUI.consoleWrite("\t Was willst du machen? \n");
		yourTurn = true;
	}
	
	public void droppot() {
		int acc;
		acc = rand.nextInt(100);
		if (player.getHitChance() >= acc) {
			player.healthPots ++;
			GUI.consoleWrite("Du has ein Elixir gefunden!");
		}
		
	}
}