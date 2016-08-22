package modell.atributes;

import modell.gameobjects.items.IItem;

public interface ObservAttribute {
	public void updateAdd();
	public void updateExtract(IItem item);
}
