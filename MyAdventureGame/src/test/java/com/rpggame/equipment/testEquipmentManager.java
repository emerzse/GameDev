package com.rpggame.equipment;

import com.rpggame.attributes.Attribute;
import com.rpggame.attributes.AttributeManager;
import com.rpggame.item.IItem;
import com.rpggame.item.Item;
import com.rpggame.testData.TestAttributes;
import com.rpggame.utilities.GameHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by emerzse on 2016. 11. 06..
 */
public class testEquipmentManager {

    private EquipmentManager equipmentManager;
    private static Map<Attribute, Integer> defaultAttributes;
    private static AttributeManager defaultAttributeManager;

    @Before
    public void initEquipmentManager() {
        equipmentManager = new EquipmentManager(5);

        defaultAttributes = new HashMap<>();
        defaultAttributes.put(TestAttributes.VITALITY, 10);
        defaultAttributes.put(TestAttributes.DEXTERITY, 10);
        defaultAttributes.put(TestAttributes.STRENGTH, 10);
        defaultAttributes.put(TestAttributes.INTELLIGENT, 10);

        defaultAttributeManager = new AttributeManager(equipmentManager,defaultAttributes);
    }

    @Test
    public void test() {
        Set<IItem> itemSet = new HashSet<>();
        itemSet.add(new Item(1, GameHelper.generateAttributes(TestAttributes.class)));
        itemSet.add(new Item(1, GameHelper.generateAttributes(TestAttributes.class)));
        itemSet.add(new Item(1, GameHelper.generateAttributes(TestAttributes.class)));
        itemSet.add(new Item(1, GameHelper.generateAttributes(TestAttributes.class)));
        itemSet.add(new Item(1, GameHelper.generateAttributes(TestAttributes.class)));

        equipmentManager.addItem(itemSet);
        GameHelper.logger.info(defaultAttributeManager.toString()+"\n; "+defaultAttributeManager.getOriginAttributes());
        GameHelper.logger.info(equipmentManager.getCollection().toString());
        GameHelper.logger.info("now take down:");
        equipmentManager.extractAllItem();
        GameHelper.logger.info("==="+defaultAttributeManager.toString()+"\n; "+defaultAttributeManager.getOriginAttributes());
    }
}