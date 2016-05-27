package modell;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

enum GameObjectAttribute {

	VITALITY, STRENGHT, DEXTERY, INTELIGENT;
}
/**
 * This class is manage the attribute in game of characters.
 * example the player, enemy, npc
 */
public class AttributeManager {

	private EnumMap<GameObjectAttribute, Integer> originAttributes;
	private EnumMap<GameObjectAttribute, Integer> currentAttributes;
	
   /**
	*Default init values to attribute
	*This constructor is initialization default attribute in GameObjectAttributeSystem object.
	*Two map is fill up one origin and one current attribute map. 
	*/
	public AttributeManager() {
		originAttributes =  new EnumMap<GameObjectAttribute, Integer>(GameObjectAttribute.class);
		originAttributes.put(GameObjectAttribute.VITALITY, 1);
		originAttributes.put(GameObjectAttribute.STRENGHT, 1);
		originAttributes.put(GameObjectAttribute.DEXTERY, 1);
		currentAttributes = new EnumMap<GameObjectAttribute, Integer>(originAttributes);
	}
	
	/**
	 * Set for parameters to attribute value
	 * This constructor is initialization this parameters:
	 * @param vitality
	 * @param strenght
	 * @param dextery
	 * in GameObjectAttributeSystem object.
	 * Two map is fill up one origin and one current attribute map.
	 */
	public AttributeManager(int vitality, int strenght, int dextery) {
		originAttributes = new EnumMap<GameObjectAttribute, Integer>(GameObjectAttribute.class);
		originAttributes.put(GameObjectAttribute.VITALITY, vitality);
		originAttributes.put(GameObjectAttribute.STRENGHT, strenght);
		originAttributes.put(GameObjectAttribute.DEXTERY, dextery);
		currentAttributes = new EnumMap<GameObjectAttribute, Integer>(originAttributes);
	}
	
	public AttributeManager(EnumMap<GameObjectAttribute, Integer> patternAttribute){
		originAttributes = new EnumMap<GameObjectAttribute, Integer>(patternAttribute); 
		currentAttributes = new EnumMap<GameObjectAttribute, Integer>(originAttributes);
	}
	
	//Change attribute:
	/**
	 * This metod can grow up any attribute where:
	 * @param nameAttribute is content if  content:
	 * @param newValue add to the found attribute's value
	 */
	public void addAttributeValue(GameObjectAttribute nameAttribute, int newValue){
		if(currentAttributes.containsKey(nameAttribute)){
			int currentValue = currentAttributes.get(nameAttribute);
		    currentAttributes.replace(nameAttribute, currentValue + newValue);
		}		
	}
	/**
	 * This metod can grow up any attribute where:
	 * @param otherAttributes
	 */
	public void addAttributeValue(Map<GameObjectAttribute, Integer> otherAttributes){
		otherAttributes.forEach((k,v)-> currentAttributes.replace(k, currentAttributes.get(k)+v));
	}
	
	/**
	 * This metod can decrease any attribute where:
	 * @param nameAttribute is content if  content:
	 * @param newValue extract to the found attribute's value
	 */
	public void extractAttributeValue(GameObjectAttribute nameAttribute, int newValue){
		if(currentAttributes.containsKey(nameAttribute)){
			int currentValue = currentAttributes.get(nameAttribute);
			this.checkAttributes(nameAttribute,newValue);
			currentAttributes.replace(nameAttribute, currentValue - newValue);			
		}		
	}
	/**
	 * This metod can decrease any attribute where:
	 * @param otherAttributes
	 */
	public void extractAttributeValue(Map<GameObjectAttribute, Integer> otherAttributes){
		otherAttributes.forEach((k,v)-> checkAttributes(k, v));
		otherAttributes.forEach((k,v)-> currentAttributes.replace(k, currentAttributes.get(k)-v));
	}
	
	
	public int getAttributeValue(GameObjectAttribute nameAttribute){
		int value = 0;
		if(currentAttributes.containsKey(nameAttribute)){
			value = currentAttributes.get(nameAttribute);
		}
		
		return value;
	}
	
	/**
	 * Check the attribute value where the new change value is less than origin value
	 * @param attribute: searching the examine attribute
	 * @param value: this value changing the current value 
	 * @return boolean value is not important
	 * If is found wrong state its throw a illegalArgumentException
	 */
	private boolean checkAttributes(GameObjectAttribute attribute, int value){
		int currentValue = currentAttributes.get(attribute)-value;
		boolean ret = !originAttributes.entrySet().stream().filter(map-> map.getKey() == attribute && map.getValue() >  currentValue).collect(Collectors.toMap(p -> p.getKey(), p-> p.getValue())).isEmpty();
		
		if(ret){
			throw new IllegalArgumentException("The current value not possible less than origin value. Attribute: "+attribute+" and illegal value: "+value);
		}
		
		return ret;
	}
	
	@Override
	public String toString() {
		return "Current: "+ currentAttributes.toString();
	}
	
	public String getOriginAttributes() {
		return "Original: "+ originAttributes.toString();
	}
	
	public void setOriginAttribute(GameObjectAttribute attribute, int value){
		originAttributes.replace(attribute, value);
	}
}
