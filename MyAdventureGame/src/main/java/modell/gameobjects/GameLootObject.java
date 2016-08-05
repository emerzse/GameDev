package modell.gameobjects;

import java.util.HashMap;
import java.util.Map;

import modell.atributes.Attribute;

public class GameLootObject {
	protected Map<Attribute, Integer> attributes;
	
	public GameLootObject() {
		attributes = new HashMap<>();
	}
	
	public Map<Attribute, Integer> getAttributes() {
		return attributes;
	}


}
