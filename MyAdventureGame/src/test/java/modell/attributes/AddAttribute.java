package modell.attributes;

import org.junit.Before;
import org.junit.Test;

import modell.atributes.AttributeManager;
import modell.attributes.templatetype.TestAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.GameLootObject;

public class AddAttribute {
	AttributeManager attribute;
	GameLootObject lootObject;
	
	@Before
	public void initAttributeSystem(){
		lootObject = new GameLootObject();
		lootObject.getAttributes().put(TypeAttributes.DEXTERY, 5);
		lootObject.getAttributes().put(TestAttribute.FASTHAND, 5);
		attribute = new AttributeManager(10, 11, 9);
		System.out.println(attribute.toString());
	}
	
	//add attribute
	@Test
	public void changeOneAttribute() {
		attribute.addAttributeValue(TypeAttributes.VITALITY, 10);
		System.out.println(attribute.toString());
	}
	
	//add attribute negative
	@Test
	public void changeOneAttributeNegative() {
		attribute.addAttributeValue(TypeAttributes.VITALITY, -5);
		System.out.println(attribute.toString());
	}
	
	//add other map union
	@Test
	public void changeAttributeWithMap() {
			System.out.println("----------Other Map---------- ");
			attribute.addAttributeValue(lootObject.getAttributes());
			System.out.println(attribute.getOriginAttributes());
			System.out.println(attribute.getAttributeValue(TypeAttributes.DEXTERY));
			System.out.println(attribute.toString());
	}
}
