package com.rpggame.item;


import com.rpggame.attributes.Attribute;

import java.util.Map;

public interface IItem {
    int getScale();

    Map<Attribute, Integer> getAttributes();
}
