package modell.dice;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiceTest {
	private static Logger logger = LoggerFactory.getLogger(DiceTest.class);

@Test
public void tryDropNumber() {
	int sValue = 4;
	int found = 0;
	int tryDrop = 0;
	
	
	while(sValue != found){
		found = Dice.diceValue(6);
		tryDrop++;
		logger.info(""+found);
	}
	
	logger.info("---------------");
	logger.info(""+tryDrop);
}
	
	
}
