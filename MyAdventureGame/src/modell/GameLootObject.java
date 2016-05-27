package modell;

import java.util.HashMap;
import java.util.Map;

public class GameLootObject {
	protected Map<GameObjectAttribute, Integer> attributes;
	
	public GameLootObject() {
		attributes = new HashMap<GameObjectAttribute, Integer>();
	}
}
