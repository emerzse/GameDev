package modell.gameobjects;

import java.util.HashMap;
import java.util.Map;

import modell.atributes.Attribute;

public class GameObject {
	protected Map<Attribute, Integer> attributes;
	
	public GameObject() {
		attributes = new HashMap<>();
	}
	
	public GameObject(Map<Attribute, Integer> attributes) {
		this.attributes = attributes;
	}
	
	public Map<Attribute, Integer> getAttributes() {
		return attributes;
	}

}
