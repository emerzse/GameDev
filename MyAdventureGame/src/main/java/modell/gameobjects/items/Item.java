package modell.gameobjects.items;

import modell.gameobjects.GameObject;

public class Item extends GameObject implements IItem{
	private int scale;
	private String name;
	
	public Item(int scale) {
		super();
		if(scale == 0)
			throw new NullPointerException();
		this.scale = scale;
	}

	public int getScale() {
		return scale;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		String properties ="Name: " + this.name +", Scale: "+ this.scale;
		
		if(!this.getAttributes().isEmpty())
			properties += ",\n Attributes: " + this.getAttributes().toString();
			
		return properties;
	}
}
