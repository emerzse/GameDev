package com.rpggame.attributes;

import java.util.HashMap;
import java.util.Map;
import static com.rpggame.utilities.GameHelper.randomNumGen;

public class HelpAttribute {

	public static <T extends Enum<T> & Attribute>   Map<Attribute, Integer> generateAttributes(Class<T> selectedAttribute){
		Map<Attribute, Integer> result = new HashMap<>();

		T[] attrSet = selectedAttribute.getEnumConstants();
		int attributeLength =  attrSet.length;
		
		for (int i = 0; i < randomNumGen.nextInt(attributeLength); i++) {
			result.put(Attribute.randomAttribute(selectedAttribute),randomNumber());
		}
		
		return result;
	}
	
	private static int randomNumber(){
		int result = randomNumGen.nextInt(30+30)-30;
		
		while(result == 0){
			result = randomNumGen.nextInt(30+30)-30;
		}
		
		return result;
	}
}
