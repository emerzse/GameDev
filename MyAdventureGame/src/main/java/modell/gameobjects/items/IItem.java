package modell.gameobjects.items;

import java.util.Map;

import modell.atributes.Attribute;

public interface IItem {
	public int getScale();
	public Map<Attribute, Integer> getAttributes();
}
