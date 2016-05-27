package modell;

import java.awt.Point;

public class GameMoveObject {

	private String name;
	private Inventory inventory;
	private int hitPoint;
	private int armor;
	private Point cordinateXY;
	private int damage;
	private double speed;
	private AttributeManager attributeSystem;
	private EquipmentManager equipmentManager;
	
	public GameMoveObject() {
		cordinateXY = new Point(0, 0);
	}
	
	public void move(){
		
	}
	
	public void attack(){
		
	}
	
	public void spell(){
		
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	/**
	 * @return the hitPoint
	 */
	public int getHitPoint() {
		return hitPoint;
	}

	/**
	 * @param hitPoint the hitPoint to set
	 */
	public void setHitPoint(int hitPoint) {
		this.hitPoint = hitPoint;
	}

	/**
	 * @return the armor
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * @param armor the armor to set
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * @return the cordinateXY
	 */
	public Point getCordinateXY() {
		return cordinateXY;
	}

	/**
	 * @param cordinateXY the cordinateXY to set
	 */
	public void setCordinateXY(Point cordinateXY) {
		this.cordinateXY = cordinateXY;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}	
}
