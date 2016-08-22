package modell.gameobjects.items;

public class Weapon extends Item{
	
	int dmg;

	public Weapon(int scale) {
		super(scale);
	}

	public int getDmg() {
		return dmg;
	}

	public void setDmg(int dmg) {
		this.dmg = dmg;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nItemType: Weapon, Dmg: "+this.dmg+";";
	}

}
