package modell.attributes.templatetype;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import modell.atributes.Attribute;
import modell.inventory.InventoryTest;
import static org.junit.Assert.*;

public class AttributeMetodTest {
	private static Logger logger = LoggerFactory.getLogger(InventoryTest.class);
	@Test
	public void randomMetodTest() {
		logger.info(""+Attribute.random(TypeAttributes.class));
	}
	
	@Test
	public void randomTest() {
		
		logger.info("Attribute size: "+TypeAttributes.values().length);
		
		Attribute v = TypeAttributes.VITALITY;
		Attribute cv = null;
		int iv= 0;
		while(v != cv) {
			cv = Attribute.random(TypeAttributes.class);
			iv++;
		}
			logger.info(""+cv+ " :"+iv );
			
		Attribute d = TypeAttributes.DEXTERY;
		Attribute cd = null;
		int id= 0;
		while(d != cd) {
			cd = Attribute.random(TypeAttributes.class);
			id++;
		}
			logger.info(""+cd+ " :"+id );
				
		Attribute s = TypeAttributes.STRENGHT;
		Attribute cs = null;
		int is= 0;
		
		while(s != cs) {
			cs = Attribute.random(TypeAttributes.class);
			is++;
		}
		logger.info(""+cs+ " :"+is );
		
		Attribute i = TypeAttributes.INTELIGENT;
		Attribute ci = null;
		int ii= 0;
		
		while(i != ci) {
			ci = Attribute.random(TypeAttributes.class);
			ii++;
		}
		logger.info(""+ci+ " :"+ii );					

	}
}
