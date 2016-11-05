package com.rpggame.attributes;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by emerzse on 2016. 11. 05..
 */
public class testAttributeManager {
    AttributeManager attributeManager;

    @Before
    public void initManagers() {
        Map<Attribute, Integer> defaultAttributes = new HashMap<>();
        defaultAttributes.put(testAttributes.VITALITY, 10);
        defaultAttributes.put(testAttributes.DEXTERITY, 10);
        defaultAttributes.put(testAttributes.STRENGTH, 10);
        defaultAttributes.put(testAttributes.INTELLIGENT, 10);
        attributeManager = new AttributeManager(defaultAttributes);
    }

    @Test
    public void testAddAttributes() {
        //GIVEN
        Map<Attribute, Integer> attributes = new HashMap<>();
        attributes.put(testAttributes.VITALITY, 10);
        //WHEN
        attributeManager.addAttributeValue(attributes);
        //THEN
        assertEquals(20, attributeManager.getAttributeValue(testAttributes.VITALITY));
    }
}

enum testAttributes implements Attribute {
    VITALITY, DEXTERITY, INTELLIGENT, STRENGTH
}
