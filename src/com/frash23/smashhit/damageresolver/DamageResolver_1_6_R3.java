package com.frash23.smashhit.damageresolver;

import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_6_R3.EnchantmentManager;
import net.minecraft.server.v1_6_R3.EntityLiving;
import net.minecraft.server.v1_6_R3.EntityPlayer;
import net.minecraft.server.v1_6_R3.GenericAttributes;

class DamageResolver_1_6_R3 implements DamageResolver {

	private boolean USE_CRITS, OLD_CRITS;

	DamageResolver_1_6_R3(boolean useCrits, boolean oldCrits) {
		USE_CRITS = useCrits;
		OLD_CRITS = oldCrits;
	}

	@Override
	public double getDamage(Player damager, Damageable entity) {
		EntityPlayer nmsp = ((CraftPlayer) damager).getHandle();
		double damage = nmsp.getAttributeInstance(GenericAttributes.e).getValue();
		damage += EnchantmentManager.a((EntityLiving) nmsp, ((EntityLiving) ((CraftEntity) entity).getHandle()));
		if (USE_CRITS && !((Entity) damager).isOnGround() && damager.getVelocity().getY() < 0 && OLD_CRITS || damager.isSprinting())
			damage *= 1.5;
		return damage;
	}

}
