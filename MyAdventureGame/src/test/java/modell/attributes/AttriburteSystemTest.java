package modell.attributes;

import org.junit.Before;
import org.junit.Test;

import modell.atributes.AttributeManager;
import modell.attributes.templatetype.TestAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.GameObject;


public class AttriburteSystemTest {

	AttributeManager attribute;
	GameObject lootObject;
	
	@Before
	public void initAttributeSystem(){
		lootObject = new GameObject();
		lootObject.getAttributes().put(TypeAttributes.DEXTERY, 5);
		lootObject.getAttributes().put(TestAttribute.FASTHAND, 5);
		//lootObject.attributes.put(GameObjectAttribute.INTELIGENT, 5);
		attribute = new AttributeManager(10, 11, 9);
		System.out.println(attribute.toString());
	}
	
	//attribute changing test
	@Test(expected = Exception.class)
	public void changeOneAttribute() throws Exception{
		//add attribute
		attribute.addAttributeValue(TypeAttributes.VITALITY, 10);
		System.out.println(attribute.toString());
		
		//remove attribute
		attribute.extractAttributeValue(TypeAttributes.VITALITY, 10);
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.toString());
		
		System.out.println(attribute.getAttributeValue(TypeAttributes.DEXTERY));
		
		//add other map union
		System.out.println("----------Other Map---------- ");
		attribute.addAttributeValue(lootObject.getAttributes());
		System.out.println(attribute.getOriginAttributes());
		System.out.println(attribute.getAttributeValue(TypeAttributes.DEXTERY));
		System.out.println(attribute.toString());
		
		attribute.extractAttributeValue(lootObject.getAttributes());
		System.out.println(attribute.toString());
		System.out.println(attribute.getAttributeValue(TypeAttributes.DEXTERY));
	}
	
}
