package modell.attributes;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import modell.atributes.AttributeManager;
import modell.attributes.templatetype.TestAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.GameObject;

public class AddAttribute {
	AttributeManager attribute;
	GameObject lootObject;
	private static Logger logger = LoggerFactory.getLogger(AddAttribute.class);
	
	@Before
	public void initAttributeSystem(){
		lootObject = new GameObject();
		lootObject.getAttributes().put(TypeAttributes.DEXTERY, 5);
		lootObject.getAttributes().put(TestAttribute.FASTHAND, 5);
		attribute = new AttributeManager(10, 11, 9);
		logger.info(attribute.toString());
	}
	
	//add attribute
	@Test
	public void changeOneAttribute() {
		attribute.addAttributeValue(TypeAttributes.VITALITY, 10);
		logger.info(attribute.toString());
	}
	
	//add attribute negative
	@Test
	public void changeOneAttributeNegative() {
		attribute.addAttributeValue(TypeAttributes.VITALITY, -5);
		logger.info(attribute.toString());
	}
	
	//add other map union
	@Test
	public void changeAttributeWithMap() {
		    logger.info("----------Other Map---------- ");
			attribute.addAttributeValue(lootObject.getAttributes());
			logger.info(attribute.getOriginAttributes());
			logger.info(""+attribute.getAttributeValue(TypeAttributes.DEXTERY));
			logger.info(attribute.toString());
	}
}
