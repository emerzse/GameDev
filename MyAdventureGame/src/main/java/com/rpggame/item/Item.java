package com.rpggame.item;


import com.rpggame.attributes.Attribute;
import com.rpggame.modell.gameobjects.GameObject;

import java.util.Map;

public class Item extends GameObject implements IItem{
	private int scale;
	private String name;
	
	public Item(int scale) {
		super();
		if(scale == 0)
			throw new NullPointerException();
		this.scale = scale;
	}
	
	public Item(int scale, Map<Attribute, Integer> attributes) {
		super(attributes);
		if(scale == 0)
			throw new NullPointerException();
		this.scale = scale;
	}
	
	public Item(int scale,String name) {
		super();
		if(scale == 0)
			throw new NullPointerException();
		this.scale = scale;
		this.name = name;
	}
	
	public Item(int scale,String name, Map<Attribute, Integer> attributes) {
		super(attributes);
		if(scale == 0)
			throw new NullPointerException();
		this.scale = scale;
		this.name = name;
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
