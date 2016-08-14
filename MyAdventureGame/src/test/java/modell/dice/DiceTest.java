package modell.dice;

import org.junit.Test;

public class DiceTest {

@Test
public void tryDropNumber() {
	int sValue = 4;
	int found = 0;
	int tryDrop = 0;
	
	while(sValue != found){
		found = Dice.diceValue(6);
		tryDrop++;
		System.out.println(found);
	}
	
	System.out.println("---------------");
	System.out.println(tryDrop);
	System.out.println(sValue == found);
}
	
	
}
