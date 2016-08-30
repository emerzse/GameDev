package modell.atributes;

import java.util.Random;

public interface Attribute {
	
	public static  <T extends Enum<T>> Attribute random(Class<T> enumType) {
        
		T[] attrSet = enumType.getEnumConstants();
		
		int i =  attrSet.length;
				
        return (Attribute) attrSet[new Random().nextInt(i)];
	}
}
