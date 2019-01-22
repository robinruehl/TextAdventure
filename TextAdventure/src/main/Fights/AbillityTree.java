package main.Fights;

import main.Game.Abillity;

public class AbillityTree {
	private Abillity stomp;
	public Abillity getStomp() {
		return stomp;
	}

	public void setStomp(Abillity stomp) {
		this.stomp = stomp;
	}

	public Abillity getFireBurst() {
		return fireBurst;
	}

	public void setFireBurst(Abillity fireBurst) {
		this.fireBurst = fireBurst;
	}

	private Abillity fireBurst;
	
	public AbillityTree()
	{
		stomp = new Abillity(0, 0, 0, 100, 2, "Stomp", 0, 0);
		fireBurst = new Abillity(0, 0, 0, 50, 1, "Fire Burst", 1, 0);
	}
}
