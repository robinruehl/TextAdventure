package main.Item;

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
			this.Attack  = 5;
			this.Accuracy = 15;
		}
		if (Type==2) {
			this.Attack = 10;
			this.Accuracy = 10;
		}
		if (Type==3) {
			this.Attack = 15;
			this.Accuracy = 5;
		}
	}

}
