package modell.attributes;

import org.junit.Before;
import org.junit.Test;

import modell.atributes.AttributeManager;
import modell.attributes.templatetype.TestAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.GameLootObject;

public class ExtractAttribute {
	AttributeManager attribute;
	GameLootObject lootObject;

	@Before
	public void initAttributeSystem(){
		System.out.println("----------Test-init---------- ");
		lootObject = new GameLootObject();
		lootObject.getAttributes().put(TypeAttributes.DEXTERY, 5);
		lootObject.getAttributes().put(TestAttribute.FASTHAND, 5);
		//lootObject.attributes.put(GameObjectAttribute.INTELIGENT, 5);
		attribute = new AttributeManager(10, 11, 9);
		System.out.println(attribute.toString());
	}
	
	
	//remove attribute
	@Test
	public void extractAttributeValue() {
		System.out.println("----------1-Test---------- ");
		attribute.addAttributeValue(TypeAttributes.VITALITY, 25);
		System.out.println(attribute.toString());
		attribute.extractAttributeValue(TypeAttributes.VITALITY, 25);
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.toString());
	}
	
	//add other map union
	@Test
	public void extractAttributeValueWithMap() {
		System.out.println("----------2-Test---------- ");
		attribute.addAttributeValue(lootObject.getAttributes());
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.toString());
		attribute.extractAttributeValue(lootObject.getAttributes());
		System.out.println(attribute.toString());
	}
	
	//remove attribute
	@Test(expected = Exception.class)
	public void extractAttributeValueEXP() {
		System.out.println("----------3-Test---------- ");
		attribute.addAttributeValue(TypeAttributes.VITALITY, 25);
		System.out.println(attribute.toString());
		attribute.extractAttributeValue(TypeAttributes.VITALITY, 35);
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.toString());
	}

}
