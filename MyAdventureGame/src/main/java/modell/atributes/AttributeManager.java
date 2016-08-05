package modell.atributes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import modell.attributes.templatetype.TypeAttributes;

/**
 * This class is manage the attribute in game of characters.
 * example the player, enemy, npc
 */
public class AttributeManager {

	private HashMap<Attribute, Integer> originAttributes;
	private HashMap<Attribute, Integer> currentAttributes;
	
   /**
	*Default init values to attribute
	*This constructor is initialization default attribute in GameObjectAttributeSystem object.
	*Two map is fill up one origin and one current attribute map. 
	*/
	public AttributeManager() {
		originAttributes =  new HashMap<>();
		originAttributes.put(TypeAttributes.VITALITY, 1);
		originAttributes.put(TypeAttributes.STRENGHT, 1);
		originAttributes.put(TypeAttributes.DEXTERY, 1);
		currentAttributes = new HashMap<>(originAttributes);
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
		originAttributes =  new HashMap<>();
		originAttributes.put(TypeAttributes.VITALITY, vitality);
		originAttributes.put(TypeAttributes.STRENGHT, strenght);
		originAttributes.put(TypeAttributes.DEXTERY, dextery);
		currentAttributes = new HashMap<>(originAttributes);
	}
	
	public AttributeManager(Map<Attribute, Integer> patternAttribute){
		originAttributes = new HashMap<>(patternAttribute); 
		currentAttributes = new HashMap<>(originAttributes);
	}
	
	//Change attribute:
	/**
	 * This method can grow up any attribute where:
	 * @param nameAttribute is content if  content:
	 * @param newValue add to the found attribute's value
	 */
	public void addAttributeValue(Attribute nameAttribute, int newValue){
		if(currentAttributes.containsKey(nameAttribute)   ){
			int currentValue = currentAttributes.get(nameAttribute);
		    currentAttributes.replace(nameAttribute, currentValue + newValue);
		}		
	}
	/**
	 * This method can grow up any attribute where:
	 * @param map
	 */
	public void addAttributeValue(Map<Attribute, Integer> map){
		
	//	currentAttributes.compute(key, remappingFunction)
		map.forEach((Attribute k, Integer v)->{
			currentAttributes.compute(k, (Attribute oldK, Integer oldV)->{
				return oldV!=null ? oldV+v : v;
			});
		});
	}
	
	/**
	 * This method can decrease any attribute where:
	 * @param nameAttribute is content if  content:
	 * @param newValue extract to the found attribute's value
	 */
	public void extractAttributeValue(Attribute nameAttribute, int newValue){
		if(currentAttributes.containsKey(nameAttribute)){
			int currentValue = currentAttributes.get(nameAttribute);
			this.checkAttributes(nameAttribute,newValue);
			currentAttributes.replace(nameAttribute, currentValue - newValue);			
		}		
	}
	/**
	 * This method can decrease any attribute where:
	 * @param otherAttributes
	 */
	public void extractAttributeValue(Map<Attribute, Integer> otherAttributes){
		otherAttributes.forEach((k,v)-> checkAttributes(k, v));
		otherAttributes.forEach((k,v)-> currentAttributes.replace(k, currentAttributes.get(k)-v));
		this.removeZeroAttribute();
	}
	/**
	 * This method can remove attribute where value is 0
	 * This why need where have a temporary attribute  
	 */
	private void removeZeroAttribute(){
		Iterator<Map.Entry<Attribute, Integer>>	iAttribute =  currentAttributes.entrySet().iterator();
	
		while(iAttribute.hasNext()){
			Map.Entry<Attribute, Integer> current = iAttribute.next();
			if(current.getValue() == 0)
				iAttribute.remove();	
		}
	}
	
	public int getAttributeValue(TypeAttributes nameAttribute){
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
	private boolean checkAttributes(Attribute attribute, int value){
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
}
