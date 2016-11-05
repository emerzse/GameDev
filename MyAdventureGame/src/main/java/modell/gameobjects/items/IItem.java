package modell.gameobjects.items;

import modell.atributes.Attribute;

import java.util.Map;

public interface IItem {
	public int getScale();
	public Map<Attribute, Integer> getAttributes();
}
