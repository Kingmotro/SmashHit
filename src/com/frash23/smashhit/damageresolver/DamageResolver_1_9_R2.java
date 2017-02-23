package com.frash23.smashhit.damageresolver;

import org.bukkit.craftbukkit.v1_9_R2.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.frash23.smashhit.impl.DamageAttribute;
import com.frash23.smashhit.impl.DamageType;

import net.minecraft.server.v1_9_R2.GenericAttributes;

class DamageResolver_1_9_R2 implements DamageResolver {

	private boolean USE_CRITS, OLD_CRITS;

	DamageResolver_1_9_R2(boolean useCrits, boolean oldCrits) {
		USE_CRITS = useCrits;
		OLD_CRITS = oldCrits;
	}

	@Override
	public DamageAttribute getDamage(Player damager, Damageable entity) {
		double damage = ((CraftPlayer) damager).getHandle().getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).getValue();
		int damageType = DamageType.NORMAL;
		if (USE_CRITS && !((Entity) damager).isOnGround() && damager.getVelocity().getY() < 0 && OLD_CRITS || damager.isSprinting()) {
			damageType = DamageType.CRITICAL;
			damage *= 1.5;
		}
		return new DamageAttribute(damage, damageType);
	}

}
