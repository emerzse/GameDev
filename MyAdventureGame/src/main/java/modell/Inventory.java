package modell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import modell.gameobjects.items.IItem;

public class Inventory {
	private int freeSpace;
	private int xSize, ySize;
	private ArrayList<IItem> items;
	
	public Inventory(int xSize, int ySize ) {
		this.xSize = xSize;
		this.ySize = ySize;
		freeSpace = xSize*ySize;
		items = new ArrayList<>();
	}
	
	public void addItem(IItem item){
		if(item.equals(null))
			throw new NullPointerException();
		
		if(freeSpace-item.getScale() >=0) {
			freeSpace-= item.getScale();
			items.add(item);
		}
	}
	
	public void remove(int index){
		IItem item = this.getItems().get(index);
		this.freeSpace += item.getScale();
		this.getItems().remove(index);
	}
	
	public void transferAllItem(Inventory otherInv){
		otherInv.getItems().addAll(this.getItems());
		otherInv.freeSpace -= this.getItems().parallelStream().mapToInt(i-> i.getScale()).sum();
		this.getItems().clear();
		this.freeSpace = this.xSize*this.ySize;
	}
	
	public void transferItem(int index,Inventory otherInv){
		IItem item = this.getItems().get(index);
		this.freeSpace += item.getScale();
		this.getItems().remove(index);
		otherInv.addItem(item);
	}
	
	
	public int getFreeSpace() {
		return freeSpace;
	}

	public ArrayList<IItem> getItems() {
		return items;
	}

	@Override
	public String toString() {
		StringBuilder sb = new  StringBuilder();
		sb.append("Inventory's items: \n");
		
		for (IItem item : items) {
			sb.append(item.toString()+";\n");
		}
		return sb.toString();
	}

	public int getxSize() {
		return xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setxSize(int xSize) {
		if(xSize==0)
			throw new NullPointerException();
		
		this.xSize = xSize;
		freeSpace = xSize*ySize;
	}

	public void setySize(int ySize) {
		if(ySize==0)
			throw new NullPointerException();
		
		this.ySize = ySize;
		freeSpace = xSize*ySize;
	}
	
	
}
