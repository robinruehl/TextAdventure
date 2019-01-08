package main.Game;

public class Abillity {
	private int reqLevel;
	private int reqInt;
	private int reqLuck;
	private int damage;
	private int cooldown;
	private int effect1;
	private int effect2;
	

	private String name;
	
	public Abillity(int rlevel, int rint, int rluck, int d, int c, String name, int e1, int e2)
	{
		this.reqLevel = rlevel;
		this.reqInt = rint;
		this.reqLuck = rluck;
		this.damage = d;
		this.cooldown = c;
		this.name = name;
		
		this.effect1 = e1;
		this.effect2 = e2;
	}

	public int getReqLevel() {
		return reqLevel;
	}

	public void setReqLevel(int reqLevel) {
		this.reqLevel = reqLevel;
	}

	public int getReqInt() {
		return reqInt;
	}

	public void setReqInt(int reqInt) {
		this.reqInt = reqInt;
	}

	public int getReqLuck() {
		return reqLuck;
	}

	public void setReqLuck(int reqLuck) {
		this.reqLuck = reqLuck;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getCooldown() {
		return cooldown;
	}

	public void setCooldown(int cooldown) {
		this.cooldown = cooldown;
	}

	public int getEffect1() {
		return effect1;
	}

	public void setEffect1(int effect1) {
		this.effect1 = effect1;
	}

	public int getEffect2() {
		return effect2;
	}

	public void setEffect2(int effect2) {
		this.effect2 = effect2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}