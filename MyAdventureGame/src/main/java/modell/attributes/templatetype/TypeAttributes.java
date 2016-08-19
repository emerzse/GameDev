package modell.attributes.templatetype;

import modell.atributes.Attribute;
/*
 * This is just template how can create attribute type
 */
public enum TypeAttributes implements Attribute{

	RANDOM,VITALITY, STRENGHT, DEXTERY, INTELIGENT;
	
	public Attribute random() {
		int randomAttribute = new java.util.Random().nextInt(4);
		
		switch (randomAttribute) {
			case 0:
				return VITALITY;
			case 1:
				return STRENGHT;
			case 2:
				return DEXTERY;
			case 3:
				return INTELIGENT;
			default:
				break;
		}
		
		return null;
	}
}
