package modell.atributes;

import java.util.ArrayList;
import java.util.Set;

import modell.gameobjects.items.IItem;

public abstract class AttributeListening {
	
private ArrayList<ObservAttribute> observers = new ArrayList<>();

public abstract void addItem(IItem item);
public abstract void extractItem(IItem item);
public abstract Set<IItem> getCollection();

protected void attach(ObservAttribute observer) {
	observers.add(observer);
}

protected void addAllObservers() {
	for (ObservAttribute observAttribute : observers) {
		observAttribute.updateAdd();
	}
}

protected void extractAllObservers(IItem item) {
	for (ObservAttribute observAttribute : observers) {
		observAttribute.updateExtract(item);
	}
}

}
