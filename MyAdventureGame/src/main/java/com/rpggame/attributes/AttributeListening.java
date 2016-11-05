package com.rpggame.attributes;

import com.rpggame.item.IItem;

import java.util.ArrayList;
import java.util.Set;

public abstract class AttributeListening {

    private ArrayList<ObserveAttribute> observers = new ArrayList<>();

    public abstract void addItem(IItem item);

    public abstract void extractItem(IItem item);

    public abstract Set<IItem> getCollection();

    protected void attach(ObserveAttribute observer) {
        observers.add(observer);
    }

    protected void addAllObservers(IItem item) {
        for (ObserveAttribute observeAttribute : observers) {
            observeAttribute.updateAdd(item.getAttributes());
        }
    }

    protected void extractAllObservers(IItem item) {
        for (ObserveAttribute observeAttribute : observers) {
            observeAttribute.updateExtract(item.getAttributes());
        }
    }

}
