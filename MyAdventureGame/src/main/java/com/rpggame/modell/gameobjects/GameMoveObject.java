package com.rpggame.modell.gameobjects;

import com.rpggame.inventory.Inventory;

import java.awt.Point;

public class GameMoveObject extends GameObject {

	private String name;
	private Inventory inventory;
	private int hitPoint;
	private int armor;
	private Point coordinateXY;
	private int damage;
	private double speed;
	
	public GameMoveObject() {
		super();
		coordinateXY = new Point(0, 0);
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
	 * @return the coordinateXY
	 */
	public Point getCoordinateXY() {
		return coordinateXY;
	}

	/**
	 * @param coordinateXY the coordinateXY to set
	 */
	public void setCoordinateXY(Point coordinateXY) {
		this.coordinateXY = coordinateXY;
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
