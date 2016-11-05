package modell.gameobjects.items;

import modell.atributes.Attribute;
import modell.attributes.templatetype.TypeAttributes;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ItemTest {

	private static Logger logger = LoggerFactory.getLogger(ItemTest.class);
	@Test
	public void testSetItem() {
		Item item = new Item(1);
		item.setName("The gold medal");
		item.getAttributes().put(TypeAttributes.INTELIGENT, 12);
		item.getAttributes().put(TypeAttributes.VITALITY,20);
		logger.info(item.toString());
	}
	
	@Test
	public void testSetItemRandom() {
		Item item = new Item(1);
		item.setName("magic R ring");
		
		int countAttriboute = new Random().nextInt(5);
		for (int j = 0; j < countAttriboute; j++) {
			item.getAttributes().put(Attribute.random(TypeAttributes.class), new Random().nextInt(40-1)+1);
		}
		
		logger.info(item.toString());
	}
}
