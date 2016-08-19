package modell.inventory;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import modell.Inventory;
import modell.attributes.templatetype.TypeAttributes;
import modell.dice.Dice;
import modell.gameobjects.items.IItem;
import modell.gameobjects.items.Item;

public class InventoryTest {
	
	Inventory inventory;
	Inventory inventory2;
	ArrayList<IItem> items;
	
	
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
//		System.out.println("--------Test1--------");
//		items.forEach((i)-> {
//			System.out.println(i.toString());
//		});
//		
//		System.out.println("--------Inventory--------");
//		System.out.println("Item countnumbers: "+items.size());
//		System.out.println("item sum need space: "+items.parallelStream().mapToInt(i->i.getScale()).sum());
//		System.out.println("Inventory freeplace: "+inventory.getFreeSpace());
//		
//		for (IItem iItem : items) {
//			inventory.addItem(iItem);
//		}
//		
//		System.out.println(inventory.toString());
//		System.out.println("Inventory freeplace: "+inventory.getFreeSpace());
//		System.out.println("Inventory count items: "+inventory.getItems().size());
//	}
	
	@Test
	public void testInventoryTrasfertoInventory() {
		System.out.println("--------Test2--------");
		
		for (IItem iItem : items) {
			inventory.addItem(iItem);
		}
		
		//System.out.println(inventory.toString());
		System.out.println("Inventory1 freeplace: "+inventory.getFreeSpace());
		System.out.println("Inventory1 count items: "+inventory.getItems().size());
		
		inventory.transferAllItem(inventory2);
		System.out.println("--------Inventory1--------");
		//System.out.println(inventory.toString());
		System.out.println("Inventory1 freeplace: "+inventory.getFreeSpace());
		System.out.println("Inventory1 count items: "+inventory.getItems().size());
		
		System.out.println("--------Inventory2--------");
		//System.out.println(inventory2.toString());
		System.out.println("Inventory2 freeplace: "+inventory2.getFreeSpace());
		System.out.println("Inventory2 count items: "+inventory2.getItems().size());
		
	}
	@Test
	public void testInventoryTrasfertoInventory2() {
		System.out.println("--------Test3--------");
		
		for (IItem iItem : items) {
			inventory.addItem(iItem);
		}
		
		//System.out.println(inventory.toString());
		System.out.println("Inventory1 freeplace: "+inventory.getFreeSpace());
		System.out.println("Inventory1 count items: "+inventory.getItems().size());
		
		inventory.transferItem(new Random().nextInt(inventory.getItems().size()),inventory2);
		System.out.println("--------Inventory1--------");
		//System.out.println(inventory.toString());
		System.out.println("Inventory1 freeplace: "+inventory.getFreeSpace());
		System.out.println("Inventory1 count items: "+inventory.getItems().size());
		
		System.out.println("--------Inventory2--------");
		System.out.println(inventory2.toString());
		System.out.println("Inventory2 freeplace: "+inventory2.getFreeSpace());
		System.out.println("Inventory2 count items: "+inventory2.getItems().size());
		
	}

}
