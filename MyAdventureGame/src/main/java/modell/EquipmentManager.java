package modell;

import java.util.Set;

import modell.atributes.AttributeListening;
import modell.gameobjects.items.IItem;

public class EquipmentManager extends AttributeListening{
	private Set<IItem> equipments;
	private int eqSlot;
	
	public EquipmentManager(int eqSlot) {
		this.eqSlot = eqSlot;
	}

	public Set<IItem> getEquipments() {
		return equipments;
	}

	@Override
	public void addItem(IItem item) {
		if(item!=null && eqSlot >= equipments.size())
			equipments.add(item);
		addAllObservers();
	}

	@Override
	public Set<IItem> getCollection() {
		return equipments;
	}

	@Override
	public void extractItem(IItem item) {
		equipments.remove(item);
		extractAllObservers(item);	
	}
}
