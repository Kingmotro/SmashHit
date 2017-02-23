package com.frash23.smashhit.event;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.frash23.smashhit.impl.DamageAttribute;

public class AsyncEntityDamageEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private DamageAttribute damageAttrib;
	private EntityDamageByEntityEvent damageEvent;

	public AsyncEntityDamageEvent(DamageAttribute damageAttrib, EntityDamageByEntityEvent damageEvent) {
		super(true);
		this.setDamageAttrib(damageAttrib);
		this.setDamageEvent(damageEvent);
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public DamageAttribute getDamageAttrib() {
		return damageAttrib;
	}

	public void setDamageAttrib(DamageAttribute damageAttrib) {
		this.damageAttrib = damageAttrib;
	}

	public EntityDamageByEntityEvent getDamageEvent() {
		return damageEvent;
	}

	public void setDamageEvent(EntityDamageByEntityEvent damageEvent) {
		this.damageEvent = damageEvent;
	}

}
