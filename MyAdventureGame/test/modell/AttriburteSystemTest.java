package modell;

import org.junit.Before;
import org.junit.Test;

public class AttriburteSystemTest {

	AttributeManager attribute;
	GameLootObject lootObject;
	
	@Before
	public void initAttributeSystem(){
		lootObject = new GameLootObject();
		lootObject.attributes.put(GameObjectAttribute.DEXTERY, 5);
		//lootObject.attributes.put(GameObjectAttribute.INTELIGENT, 5);
		attribute = new AttributeManager(10, 11, 9);
		System.out.println(attribute.toString());
	}
	
	//attribute changing test
	@Test
	public void changeOneAttribute() throws Exception{
		//add attribute
		attribute.addAttributeValue(GameObjectAttribute.VITALITY, 10);
		System.out.println(attribute.toString());
		
		//remove attribute
		attribute.extractAttributeValue(GameObjectAttribute.VITALITY, 10);
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.toString());
		
		System.out.println(attribute.getAttributeValue(GameObjectAttribute.DEXTERY));
		
		//add other map union
		System.out.println("----------Other Map---------- ");
		attribute.addAttributeValue(lootObject.attributes);
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.getAttributeValue(GameObjectAttribute.DEXTERY));
		System.out.println(attribute.toString());
		
		
		//attribute.setOriginAttribute(GameObjectAttribute.DEXTERY, 20);
		attribute.extractAttributeValue(lootObject.attributes);
		System.out.println(attribute.toString());
		System.out.println(attribute.getAttributeValue(GameObjectAttribute.DEXTERY));
	}
	
}
