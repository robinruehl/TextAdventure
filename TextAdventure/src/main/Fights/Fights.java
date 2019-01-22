package main.Fights;

import java.util.Random;

import main.GuiController;
import main.Room;
import main.Game.Abillity;
import main.Game.Game;
import main.c.PC;
import main.c.NPC;

public class Fights {
	
	private boolean yourTurn = false;
	public NPC getEnemy() {
		return enemy;
	}

	public void setEnemy(NPC enemy) {
		this.enemy = enemy;
	}

	private Random rand = new Random();
	private Game game;
	private Room Room;
	private GuiController GUI;
	private NPC enemy;
	private int turn;
	private Abillity abillity1;
	private Abillity abillity2;
	private int attack1 = 1;
	private int attack2 = 1;
	
	
	public Fights(GuiController GUI, Room Room,Game game)
	{
		this.GUI = GUI;
		this.Room = Room;
		this.game = game;
	}
	
	public Abillity getAbillity1() {
		return abillity1;
	}

	public void attack1()
	{
		if(yourTurn==true)
		{
			dmgcalc(abillity1);
		}
	}
	
	public boolean isYourTurn() {
		return yourTurn;
	}

	public void setYourTurn(boolean yourTurn) {
		this.yourTurn = yourTurn;
	}

	public void attack2()
	{
		if(yourTurn==true)
		{
			dmgcalc(abillity2);
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
	
	private void dmgcalc(Abillity a)
	{
		yourTurn = false;
    	System.out.println(a.getName());
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (game.getPlayer().getHitChance() >= acc) {
        	int temp = a.getDamage();
        	enemy.setHealth(enemy.getHealth()-temp);
        	GUI.consoleWrite("Du triffst " + enemy.getName() + " für " + temp + " Schaden und " + enemy.getName() + " hat noch " + enemy.getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.getAccuracy() >= acc) {
    		int temp = rand.nextInt(enemy.getAttackDamage()/2)+enemy.getAttackDamage()/2;
    		game.getPlayer().setHealth(game.getPlayer().getHealth()-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + game.getPlayer().getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	checkFight();
	}
	
	private void slash() {
		yourTurn = false;
    	System.out.println("slash");
    	int acc = rand.nextInt(100);
    	GUI.consoleWrite("Du würfelst " + acc);
    	if (game.getPlayer().getHitChance() >= acc) {
        	int temp = game.getPlayer().getAttackDamage();
        	enemy.setHealth(enemy.getHealth()-temp);
        	GUI.consoleWrite("Du triffst " + enemy.getName() + " für " + temp + " Schaden und " + enemy.getName() + " hat noch " + enemy.getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Du hast den Gegner verfehlt!");
    	}
    	
    	acc = rand.nextInt(100);
    	if (enemy.getAccuracy() >= acc) {
    		int temp = rand.nextInt(enemy.getAttackDamage()/2)+enemy.getAttackDamage()/2;
    		game.getPlayer().setHealth(game.getPlayer().getHealth()-temp);
    		GUI.consoleWrite("Der Gegner trifft dich für " + temp + " Schaden und du hast noch " + game.getPlayer().getHealth() + " Leben!");
    	}
    	else {
    		GUI.consoleWrite("Der Gegner hat dich verfehlt!");
    	}
    	checkFight();
    }
	
    public void checkFight() {
		if (game.getPlayer().getHealth()<=0) {
			System.out.println("you ded");
			GUI.consoleWrite("Du bist gestorben!");
		}
		else if (enemy.getHealth()<=0) {
			System.out.println("enemy ded");
			GUI.consoleWrite("Der Gegner ist gestorben!");
		}
		else {
			encounter();
		}
	}
    
    public void testFight()
    {
    	turn = 0;
    	enemy = new NPC(game.getPlayer());
    	encounter();
    }
    
	private void encounter() {
		turn++;
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite(" Gegner " + enemy.getName());
		GUI.consoleWrite("----------------------------------------------");
		GUI.consoleWrite("\t Spieler Lebenspunkte: " + game.getPlayer().getHealth());
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

	public int getTurn() {
		return turn;
	}
	
	public void setAbillity1(Abillity a)
	{
		if(game.getPlayer().getIntelligence()>=a.getReqInt() & game.getPlayer().getLevel()>=a.getReqLevel() & game.getPlayer().getLuck()>=a.getReqLuck())
		{
			this.abillity1 = a;
		}
		else
		{
			GUI.consoleWrite("Fähigkeit kann nicht verwendet werden");
		}
	}

	public Abillity getAbillity2() {
		return abillity2;
	}

	public void setAbillity2(Abillity abillity2) {
		this.abillity2 = abillity2;
	}
}

