package com.rpggame.modell.gameobjects;

import com.rpggame.attributes.Attribute;
import java.util.HashMap;
import java.util.Map;

public class GameObject {
	protected Map<Attribute, Integer> attributes;
	
	public GameObject() {
		attributes = new HashMap<>();
	}
	
	public GameObject(Map<Attribute, Integer> attributes) {
		if(attributes !=null){
			this.attributes = attributes;
		}
		else {
			attributes = new HashMap<>();
		}
	}
	
	public Map<Attribute, Integer> getAttributes() {
		return attributes;
	}

}
