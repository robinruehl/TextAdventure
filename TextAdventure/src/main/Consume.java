package application;

public class Consume extends Items{
	int Health;
	int Attack;
	int Type;
	// Type 1 = Wundertonikum, Type 2 = Medizin, Type 3 = Schlangenöl
	Consume(int Health, int Attack, int Type) {
		this.Health = Health;
		this.Attack = Attack;
	}
	Consume(int Type){
		if (Type == 1) {
			this.Attack = r.nextInt(5)+5;
			this.Health = r.nextInt(25)+25;
		}
		if (Type==2) {
			this.Health = r.nextInt()+50;
		}
		if (Type==3) {
			this.Attack = r.nextInt(10)+10;
		}
	}

}
