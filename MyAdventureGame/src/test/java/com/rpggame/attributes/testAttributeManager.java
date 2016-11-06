package com.rpggame.attributes;

import com.rpggame.testData.TestAttributes;
import com.rpggame.testData.TestSubAttributes;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by emerzse on 2016. 11. 05..
 */
public class testAttributeManager {
    private static Map<Attribute, Integer> defaultAttributes;
    private static AttributeManager calcAttributeManager;
    private AttributeManager defaultAttributeManager;
    private AttributeManager zeroAttributeManager;
    private static boolean calcAttrManflag = false;

    @BeforeClass
    public static void initMainClass() {
        defaultAttributes = new HashMap<>();
        defaultAttributes.put(TestAttributes.VITALITY, 10);
        defaultAttributes.put(TestAttributes.DEXTERITY, 10);
        defaultAttributes.put(TestAttributes.STRENGTH, 10);
        defaultAttributes.put(TestAttributes.INTELLIGENT, 10);
        calcAttributeManager = new AttributeManager(defaultAttributes);
    }

    @Before
    public void initManagers() {
        defaultAttributeManager = new AttributeManager(defaultAttributes);
        zeroAttributeManager = new AttributeManager();
    }

    @Test
    public void testAddAttributes() {
        //GIVEN
        Map<Attribute, Integer> attributes = new HashMap<>();
        attributes.put(TestAttributes.VITALITY, 10);
        attributes.put(TestSubAttributes.FIRE_RESISTANCE,5);
        //WHEN
        defaultAttributeManager.addAttributeValue(attributes);
        defaultAttributeManager.addAttributeValue(TestAttributes.DEXTERITY,5);
        calcAttributeManager.addAttributeValue(attributes);
        calcAttrManflag = true;
        zeroAttributeManager.addAttributeValue(TestAttributes.VITALITY, 10);
        //THEN
        assertEquals(20, defaultAttributeManager.getAttributeValue(TestAttributes.VITALITY));
        assertEquals(15,defaultAttributeManager.getAttributeValue(TestAttributes.DEXTERITY));
        assertEquals(20, calcAttributeManager.getAttributeValue(TestAttributes.VITALITY));
        assertEquals(5,calcAttributeManager.getAttributeValue(TestSubAttributes.FIRE_RESISTANCE));
        assertEquals(10, zeroAttributeManager.getAttributeValue(TestAttributes.VITALITY));

    }

    /**
     * Need class run the successful test
     */
    @Test
    public void testExtractAttributes() {
        //GIVEN
        Map<Attribute, Integer> attributes = new HashMap<>();
        attributes.put(TestAttributes.VITALITY, 5);
        //WHEN
        calcAttributeManager.extractAttributeValue(attributes);
        calcAttributeManager.extractAttributeValue(TestAttributes.DEXTERITY, 5);
        calcAttributeManager.extractAttributeValue(TestSubAttributes.FIRE_RESISTANCE,5);
        zeroAttributeManager.extractAttributeValue(TestAttributes.VITALITY, 2);

        //THEN
        if (calcAttrManflag) {
            assertEquals(15, calcAttributeManager.getAttributeValue(TestAttributes.VITALITY));
        } else {
            assertEquals(5, calcAttributeManager.getAttributeValue(TestAttributes.VITALITY));
        }
        assertEquals(5, calcAttributeManager.getAttributeValue(TestAttributes.DEXTERITY));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExtractAttributesNotHaveAttribute() {
        //WHEN
        zeroAttributeManager.getAttributeValue(TestAttributes.VITALITY);
    }
}

