package com.rpggame.utilities;

import com.rpggame.attributes.Attribute;

import java.util.Random;

/**
 * Created by emerzse on 2016. 11. 05..
 */
public class GameHelper {

    public static Random randomNumGen = new Random();

    public static int diceValue(int valueLimit){
        return randomNumGen.nextInt(valueLimit-1)+1;
    }

    public static<T extends  Enum<T>> Attribute randomAttribute(Class<T> attributeType) {
        return Attribute.randomAttribute(attributeType);
    }
}
