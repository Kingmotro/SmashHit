package com.frash23.smashhit.impl;

public class DamageAttribute {
	
	private double damage;
	private int damageType;
	
	public DamageAttribute(double damage, int damageType) {
		this.setDamage(damage);
		this.setDamageType(damageType);
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public int getDamageType() {
		return damageType;
	}

	public void setDamageType(int damageType) {
		this.damageType = damageType;
	}

}
