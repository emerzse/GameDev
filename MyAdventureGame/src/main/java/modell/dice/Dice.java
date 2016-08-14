package modell.dice;

import java.util.Random;

public class Dice {

	public static int diceValue(int valueLimit){
		return new Random().nextInt(valueLimit-1)+1;
	}
}
