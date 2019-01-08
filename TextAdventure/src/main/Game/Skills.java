package main.Game;

import main.c.PC;

public class Skills {
	

	public Skills() {}
	
	//Die Skills bzw. Attribute des Spielers erh�hen. 
	void skillincr(int skill, PC player) {
		if (skill == 1) {									//Maximale Lebenspunkte erh�hen
			if (player.getPerkpoints()>0) {						//daf�r muss man nat�rlich Perkpoints haben
				player.setMaxHealth(player.getMaxHealth()+20);
				player.setHealth(player.getHealth()+20);//die maximale Lebenspunkte werden erh�ht um 20 Lebenspunkte
				player.setPerkpoints(player.getPerkpoints()-1);	//ein Perkpoint wird abgezogen
				
			}

		}
		else if (skill ==2) {								//Schaden erh�hen
			if (player.getPerkpoints()>0) {
				player.setAttackDamage(player.getAttackDamage()+10);
				player.setPerkpoints(player.getPerkpoints()-1);
			}
		
		}
		else if (skill ==3) {								//Gl�ck erh�hen
			if (player.getPerkpoints()>0) {
				player.setLuck(player.getLuck()+1);
				player.setPerkpoints(player.getPerkpoints()-1);
			}

		}
		else if (skill ==4) {								//Intelligenz erh�hen
			if (player.getPerkpoints()>0) {
				player.setIntelligence(player.getIntelligence()+1);
				player.setPerkpoints(player.getPerkpoints()-1);
			}
			
		}
	}
}
