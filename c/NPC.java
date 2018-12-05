package main.c;

import java.util.Random;

public class NPC extends C {
	private Random rand = new Random();
	private String[] enemies = {"Max", "Sven der Ackermann", "ein Krieger", "ein Ork", "lange Lange", "rachsüchtiger Koppens", "ein Slav", "eine große Banane"};
	private String name;
	private int NBR;
	private boolean looted = false;
	public NPC(PC player) {
		//Generieren von Lebenspunkten und Schaden, sowie den Namen. Dannach dem level dem des Spielers gleichsetzten. Ich wollte Leben und Schaden später davon abhängig machen.
		this.health = (rand.nextInt(100));
		this.name = enemies[rand.nextInt(enemies.length)];
		this.accuracy = rand.nextInt(40) + 30;
		this.attackDamage = rand.nextInt(25) + 20 + 5;
	}
	public Random getRand()
	{
		return rand;
	}
	public void setRand(Random rand)
	{
		this.rand = rand;
	}
	public String[] getEnemies()
	{
		return enemies;
	}
	public void setEnemies(String[] enemies)
	{
		this.enemies = enemies;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getNBR()
	{
		return NBR;
	}
	public void setNBR(int nBR)
	{
		NBR = nBR;
	}
	public boolean isLooted()
	{
		return looted;
	}
	public void setLooted(boolean looted)
	{
		this.looted = looted;
	}
}
