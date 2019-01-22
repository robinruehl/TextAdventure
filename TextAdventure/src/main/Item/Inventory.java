package main.Item;
//item class muss noch gemaccht werden
public class Inventory {
	Items[] inventory = new Items[40];
	Items weapon;
	Items amory;
	Items consumable;
	
	public Inventory() {}
	// show the  items in Inventory 4 the player
	showitems()
	
	
	
	 //count items in inventory
		public void amountItem(Item item, int count) {
		total count =0;
		for(int i=0;)
		
		}
		
		
	
	
	// delete items from inventory
    
    public void removeItem(Inventory inv, Item item) {
        for (Item is : inv.getamount()) {
            if (is != null) {
                int newamount = is.getAmount() - amount;
                if (newamount < 0) {
                    is.setAmount(newamount);
                    break;
                } else {
                    inv.remove(is);
                    amount = -newamount;
                    if (amount == 0) break;
                }
            }
        }
    }
    
	}
	//überprüfung ob es sich um eine Waffe handelt:
	public void addWeapon(Item  weapon) {
		if(weapon.getType == "weapon") {
			this.weapon = weapon;
		} else {
			System.out.println("Gegenstand ist keine Waffe...");
		}
	}
	//überprüfung ob es sich um eine Rüstung handelt:
	public void addAmory(Item amory) {
		if(amory.getType=="armory") {
			this.amory =amory;
		} else {
			System.out.println("Das ist leider keine Rüstung villeicht solltest du dich doch warm anziehen");
		}
	}
	//überprüfung ob es sich um ein kunsumgut handelt
	public void addConsumable(Item consumable) {
		if(weapon.getType=="Consumable") {
			this.consumable = consumable;
			} else {
				System.out.println("Gegenstand ist entweder Rüstung oder Waffe aber diese solltest du nicht trinken");
			}
	}
	
}