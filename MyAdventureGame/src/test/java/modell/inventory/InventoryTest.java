package modell.inventory;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modell.Inventory;
import modell.attributes.templatetype.TypeAttributes;
import modell.dice.Dice;
import modell.gameobjects.items.IItem;
import modell.gameobjects.items.Item;
import modell.gameobjects.items.Weapon;

public class InventoryTest {
	
	Inventory inventory;
	Inventory inventory2;
	ArrayList<IItem> items;
	private static Logger logger = LoggerFactory.getLogger(InventoryTest.class);
	
	
	@Before
	public void  init() {
		inventory = new Inventory(3, 9);
		inventory2 = new Inventory(3, 9);
		items = new ArrayList<>();
		
		int countItems = new Random().nextInt(30-10)+1;
		for (int i = 0; i < countItems; i++) {
			Item item = new Item(Dice.diceValue(6));
			item.setName("item #"+i+". ");
			
			int countAttriboute = new Random().nextInt(5);
			for (int j = 0; j < countAttriboute; j++) {
				item.getAttributes().put(TypeAttributes.RANDOM.random(), new Random().nextInt(40-1)+1);
			}
			
			items.add(item);
		}		
	}

//	@Test
//	public void testInventorySpace() {
//		logger.info("--------Test1--------");
//		items.forEach((i)-> {
//			logger.info(i.toString());
//		});
//		
//		logger.info("--------Inventory--------");
//		logger.info("Item countnumbers: "+items.size());
//		logger.info("item sum need space: "+items.parallelStream().mapToInt(i->i.getScale()).sum());
//		logger.info("Inventory freeplace: "+inventory.getFreeSpace());
//		
//		for (IItem iItem : items) {
//			inventory.addItem(iItem);
//		}
//		
//		logger.info(inventory.toString());
//		logger.info("Inventory freeplace: "+inventory.getFreeSpace());
//		logger.info("Inventory count items: "+inventory.getItems().size());
//	}
	
	@Test
	public void testInventoryTrasfertoInventory() {
		logger.info("--------Test2--------");
		
		for (IItem iItem : items) {
			inventory.addItem(iItem);
		}
		
		//logger.info(inventory.toString());
		logger.info("Inventory1 freeplace: "+inventory.getFreeSpace());
		logger.info("Inventory1 count items: "+inventory.getItems().size());
		
		inventory.transferAllItem(inventory2);
		logger.info("--------Inventory1--------");
		//logger.info(inventory.toString());
		logger.info("Inventory1 freeplace: "+inventory.getFreeSpace());
		logger.info("Inventory1 count items: "+inventory.getItems().size());
		
		logger.info("--------Inventory2--------");
		//logger.info(inventory2.toString());
		logger.info("Inventory2 freeplace: "+inventory2.getFreeSpace());
		logger.info("Inventory2 count items: "+inventory2.getItems().size());
		
	}
	@Test
	public void testInventoryTrasfertoInventory2() {
		logger.info("--------Test3--------");
		
		for (IItem iItem : items) {
			inventory.addItem(iItem);
		}
		
		//logger.info(inventory.toString());
		logger.info("Inventory1 freeplace: "+inventory.getFreeSpace());
		logger.info("Inventory1 count items: "+inventory.getItems().size());
		
		inventory.transferItem(new Random().nextInt(inventory.getItems().size()),inventory2);
		logger.info("--------Inventory1--------");
		//logger.info(inventory.toString());
		logger.info("Inventory1 freeplace: "+inventory.getFreeSpace());
		logger.info("Inventory1 count items: "+inventory.getItems().size());
		
		logger.info("--------Inventory2--------");
		logger.info(inventory2.toString());
		logger.info("Inventory2 freeplace: "+inventory2.getFreeSpace());
		logger.info("Inventory2 count items: "+inventory2.getItems().size());
		
	}
	
	@Test
	public void testInventoryWeapon() {
		logger.info("--------Test4--------");
		Weapon w = new Weapon(3);
		w.setName("sword");
		w.setDmg(30);
		w.getAttributes().put(TypeAttributes.RANDOM.random(), new Random().nextInt(40-1)+1);
		inventory.addItem(w);
		
		logger.info("--------Inventory1--------");
		logger.info(inventory.toString());
		logger.info("Inventory1 freeplace: "+inventory.getFreeSpace());
		logger.info("Inventory1 count items: "+inventory.getItems().size());
		
	}

}
