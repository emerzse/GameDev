package modell.gameobjects.items;

import java.util.Random;

import org.junit.Test;

import modell.attributes.templatetype.TypeAttributes;
import modell.dice.Dice;

public class ItemTest {

	@Test
	public void testSetItem() {
		Item item = new Item(1);
		item.setName("The gold medal");
		item.getAttributes().put(TypeAttributes.INTELIGENT, 12);
		item.getAttributes().put(TypeAttributes.VITALITY,20);
		System.out.println(item.toString());
	}
	
	@Test
	public void testSetItemRandom() {
		Item item = new Item(1);
		item.setName("magic R ring");
		
		int countAttriboute = new Random().nextInt(5);
		for (int j = 0; j < countAttriboute; j++) {
			item.getAttributes().put(TypeAttributes.RANDOM.random(), new Random().nextInt(40-1)+1);
		}
		
		System.out.println(item.toString());
	}
}
