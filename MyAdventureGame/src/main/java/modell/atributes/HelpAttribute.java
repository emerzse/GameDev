package modell.atributes;

import modell.attributes.templatetype.TypeAttributes;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HelpAttribute {

	
	public static Map<Attribute, Integer> generateAttributes(){
		Map<Attribute, Integer> result = new HashMap<>();
		
		for (int i = 0; i < new Random().nextInt(TypeAttributes.values().length-1); i++) {
			result.put(Attribute.random(TypeAttributes.class),randomNumber());
		}
		
		return result;
	}
	
	private static int randomNumber(){
		int result = new Random().nextInt(30+30)-30;
		
		while(result == 0){
			result = new Random().nextInt(30+30)-30;
		}
		
		return result;
	}
}
