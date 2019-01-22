package application;

import java.util.Random;

public class Weapons extends Items{
	int Attack;
	int Type;
	//1 = Dolch, 2 = Schwert, 3 = Axt
	Random r;
	Weapons(int Attack, int Type) {
		this.Attack = Attack;
	}
	
	Weapons(){
		this.Attack = (r.nextInt(5)+5);
	}
	Weapons(int Type)
	{
		if (Type==1) {
			this.Attack  = r.nextInt(10)+5;
			this.Luck = r.nextInt(10)+15;
		}
		if (Type==2) {
			this.Attack = r.nextInt(10)+10;
			this.Luck = r.nextInt(10)+10;
		}
		if (Type==3) {
			this.Attack = r.nextInt(10)+15;
			this.Luck = r.nextInt(10)+5;
		}
	}

}
