package application;

public class Armor extends Items{
	int Health;
	int Type;
	// Type 1 = R�stung1 Type 2 = R�stung 2
	Armor(int Health, int Type) {
		this.Health = Health;
	}
	Armor(int Type){
		if (Type==1) {
			this.Health = r.nextInt(50)+100;
		}
		if (Type==2) {
			this.Health = r.nextInt(50)+150;
		}
	}

}
