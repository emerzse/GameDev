package modell.attributes;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modell.atributes.AttributeManager;
import modell.attributes.templatetype.TestAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.GameObject;

public class ExtractAttribute {
	AttributeManager attribute;
    GameObject lootObject;
    private static Logger logger = LoggerFactory.getLogger(ExtractAttribute.class);

	@Before
	public void initAttributeSystem(){
		logger.info("----------Test-init---------- ");
		lootObject = new GameObject();
		lootObject.getAttributes().put(TypeAttributes.DEXTERY, 5);
		lootObject.getAttributes().put(TestAttribute.FASTHAND, 5);
		//lootObject.attributes.put(GameObjectAttribute.INTELIGENT, 5);
		attribute = new AttributeManager(10, 11, 9);
		logger.info(attribute.toString());
	}
	
	
	//remove attribute
	@Test
	public void extractAttributeValue() {
		logger.info("----------1-Test---------- ");
		attribute.addAttributeValue(TypeAttributes.VITALITY, 25);
		logger.info(attribute.toString());
		attribute.extractAttributeValue(TypeAttributes.VITALITY, 25);
		logger.info(attribute.getOriginAttributes());
		logger.info(attribute.toString());
	}
	
	//add other map union
	@Test
	public void extractAttributeValueWithMap() {
		logger.info("----------2-Test---------- ");
		attribute.addAttributeValue(lootObject.getAttributes());
		logger.info(attribute.getOriginAttributes());
		logger.info(attribute.toString());
		attribute.extractAttributeValue(lootObject.getAttributes());
		logger.info(attribute.toString());
	}
	
	//remove attribute
	@Test(expected = Exception.class)
	public void extractAttributeValueEXP() {
		logger.info("----------3-Test---------- ");
		attribute.addAttributeValue(TypeAttributes.VITALITY, 25);
		logger.info(attribute.toString());
		attribute.extractAttributeValue(TypeAttributes.VITALITY, 35);
		logger.info(attribute.getOriginAttributes());
		logger.info(attribute.toString());
	}

}
