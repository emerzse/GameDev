package modell.attributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modell.EquipmentManager;
import modell.atributes.Attribute;
import modell.atributes.AttributeManager;
import modell.atributes.HelpAttribute;
import modell.attributes.templatetype.TypeAttributes;
import modell.gameobjects.items.IItem;
import modell.gameobjects.items.Item;

public class EquipmentAttribute {
	private static Logger logger = LoggerFactory.getLogger(EquipmentAttribute.class);
	
	AttributeManager attriManager;
	EquipmentManager eqManager;
	
	@Before
	public void initVarible(){
		
		Map<Attribute, Integer> attributes= new HashMap<>();
		
		attributes.put(TypeAttributes.VITALITY, 10);
		attributes.put(TypeAttributes.STRENGHT, 10);
		attributes.put(TypeAttributes.DEXTERY, 10);
		attributes.put(TypeAttributes.INTELIGENT, 10);
		
		eqManager = new EquipmentManager(5);
		attriManager = new AttributeManager(eqManager,attributes);
		logger.info("init: \n"+attributes.toString());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void equipmentOverflow(){
		for (int i = 0; i < 7; i++) {
			Item item =  new Item(3);
			item.setName(""+i);
			eqManager.addItem(item);
		}
		logger.info("this is unvisible flag"+eqManager.getEquipments().toString());
	}
	
	@Test
	public void equipmentFillUp(){
		Item head = new Item(1,"head", HelpAttribute.generateAttributes());
		Item chest = new Item(6,"chest", HelpAttribute.generateAttributes());
		Item gloves = new Item(2,"gloves", HelpAttribute.generateAttributes());
		Item weapon = new Item(3,"weapon", HelpAttribute.generateAttributes());
		Item medal = new Item(1,"medal", HelpAttribute.generateAttributes());
		
		Set<IItem> eqIitems = new HashSet<>(Arrays.asList(head,chest,gloves,weapon,medal));
		
		eqManager.addItem(eqIitems);
		
		logger.info("Fill up equipment attribute change: \n"+attriManager.toString());
		
	}
	
	@Test
	public void equipmentRemove(){
		Item head = new Item(1,"head", HelpAttribute.generateAttributes());
		Item chest = new Item(6,"chest", HelpAttribute.generateAttributes());
		Item gloves = new Item(2,"gloves", HelpAttribute.generateAttributes());
		Item weapon = new Item(3,"weapon", HelpAttribute.generateAttributes());
		Item medal = new Item(1,"medal", HelpAttribute.generateAttributes());
		
		Set<IItem> eqIitems = new HashSet<>(Arrays.asList(head,chest,gloves,weapon,medal));
		
		eqManager.addItem(eqIitems);
		
		logger.info("Fill up equipment attribute change: \n"+attriManager.toString());
		
		eqManager.extractItem(gloves);
		
		logger.info("remove: "+gloves.getName()+" After:\n"
							  +attriManager.toString()+"\n"
				              +"the remove item properties: "+gloves.toString());
		
	}
	
	
	@Test
	public void equipmentRemoveAll(){
		Item head = new Item(1,"head", HelpAttribute.generateAttributes());
		Item chest = new Item(6,"chest", HelpAttribute.generateAttributes());
		Item gloves = new Item(2,"gloves"/*, HelpAttribute.generateAttributes()*/);
		Item weapon = new Item(3,"weapon", HelpAttribute.generateAttributes());
		Item medal = new Item(1,"medal", HelpAttribute.generateAttributes());
		
		Set<IItem> eqIitems = new HashSet<>(Arrays.asList(head,chest,gloves,weapon,medal));
		
		eqManager.addItem(eqIitems);
		
		logger.info("Fill up equipment attribute change: \n"+attriManager.toString());
		//Set<IItem> removeItems = new HashSet<>(eqManager.getEquipments());
		
		logger.info("all \n"
	              +"equipment now:\n"+eqManager.getEquipments().toString());
		
		eqManager.extractAllItem();
		
		logger.info("remove: all items After:\n"
							  +attriManager.toString()+"\n"
				              +"the remove item properties: "+eqIitems.toString()+"\n"
				              +"equipment now:\n"+eqManager.getEquipments().toString());
		
	}
	
}
