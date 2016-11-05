package com.rpggame.attributes;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by emerzse on 2016. 11. 05..
 */
public class testAttributeManager {
    AttributeManager attributeManager;

    @Before
    public void initManagers() {
        attributeManager = new AttributeManager();
    }

    @Test
    public void testAddAttributes() {
        //GIVEN
        Map<Attribute,Integer> attributes = new HashMap<>();

        //WHEN
        attributeManager.addAttributeValue(attributes);
    }
}
