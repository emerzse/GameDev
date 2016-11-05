package modell;

import modell.atributes.AttributeListening;
import modell.gameobjects.items.IItem;

import java.util.HashSet;
import java.util.Set;

public class EquipmentManager extends AttributeListening{
	private Set<IItem> equipments;
	private int eqSlot;
	
	public EquipmentManager(int eqSlot) {
		this.eqSlot = eqSlot;
		equipments = new HashSet<>();
	}

	public Set<IItem> getEquipments() {
		return equipments;
	}

	@Override
	public void addItem(IItem item) {
		if(eqSlot-1 < equipments.size())
			throw new IndexOutOfBoundsException();
		
	    equipments.add(item);
		addAllObservers(item);
	}

	public void addItem(Set<IItem> eqIItems){
		eqIItems.forEach((IItem i)->{
			this.addItem(i);
		});
	}
	public void extractAllItem(){
		for (IItem iItem : equipments) {
			extractAllObservers(iItem);	
		}
		equipments.clear();
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
