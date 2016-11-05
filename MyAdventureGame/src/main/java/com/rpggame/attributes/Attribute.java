package com.rpggame.attributes;

import static com.rpggame.utilities.GameHelper.randomNumGen;

public interface Attribute {
	
	static  <T extends Enum<T>> Attribute randomAttribute(Class<T> enumType) {
		T[] attrSet = enumType.getEnumConstants();
		int i =  attrSet.length;
				
        return (Attribute) attrSet[randomNumGen.nextInt(i)];
	}
}
