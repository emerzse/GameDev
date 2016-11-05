package com.rpggame.attributes;

import java.util.Map;

public interface ObserveAttribute {
    void updateAdd(Map<Attribute, Integer> itemAtrMap);

    void updateExtract(Map<Attribute, Integer> itemAtrMap);
}
