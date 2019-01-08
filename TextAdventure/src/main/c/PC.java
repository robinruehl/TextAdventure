package main.c;

import java.util.Random;

import main.Game.Skills;

public class PC extends C {
	private Random rand = new Random();
	private float money;
	private int attackDamage;
	private int healthPots;
	private float experience;
	private int perkpoints;
	private float healthPotsHeal;
	private int healthPotDropChance = 50; //in %
	private Skills skills;
	
	public PC() {
		this.luck = 10;
		this.money = 0;
		this.health = 100;
		this.maxHealth = 100;
		this.attackDamage = 50;
		this.accuracy = 25;
		this.healthPots = 10;
		this.intelligence = 10;
		this.experience = 0;
		this.level = 1;
		this.perkpoints = 25;
		this.healthPotsHeal  = 8;
		this.skills = new Skills();
		}
	 
	 
	//Die bentigte xp zum hochleveln abrufen
	public int getXpToMax() {
		int xptomax = 50+level*50;
		return xptomax;
	}
	
	//Die Trefferwarscheinlichkeit berechnen
	public float getHitChance() {
		float temp = luck;
		float temp2 = 1;
		float hitchance = accuracy;
		while(temp>0) {
			hitchance = hitchance+100/(8*temp2);
			temp--;
			temp2++;
		}
		System.out.println(hitchance);
		return hitchance;
	}


	public Random getRand()
	{
		return rand;
	}


	public void setRand(Random rand)
	{
		this.rand = rand;
	}


	public float getMoney()
	{
		return money;
	}


	public void setMoney(float money)
	{
		this.money = money;
	}


	public int getAttackDamage()
	{
		return attackDamage;
	}


	public void setAttackDamage(int attackDamage)
	{
		this.attackDamage = attackDamage;
	}


	public int getHealthPots()
	{
		return healthPots;
	}


	public void setHealthPots(int healthPots)
	{
		this.healthPots = healthPots;
	}


	public float getExperience()
	{
		return experience;
	}


	public void setExperience(float experience)
	{
		this.experience = experience;
	}


	public int getPerkpoints()
	{
		return perkpoints;
	}


	public void setPerkpoints(int perkpoints)
	{
		this.perkpoints = perkpoints;
	}


	public float getHealthPotsHeal()
	{
		return healthPotsHeal;
	}


	public void setHealthPotsHeal(float healthPotsHeal)
	{
		this.healthPotsHeal = healthPotsHeal;
	}


	public int getHealthPotDropChance()
	{
		return healthPotDropChance;
	}


	public void setHealthPotDropChance(int healthPotDropChance)
	{
		this.healthPotDropChance = healthPotDropChance;
	}


	public Skills getSkills() {
		return skills;
	}
	
	
}
