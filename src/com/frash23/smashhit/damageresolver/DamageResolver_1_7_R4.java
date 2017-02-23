package com.frash23.smashhit.damageresolver;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.frash23.smashhit.impl.DamageAttribute;
import com.frash23.smashhit.impl.DamageType;

import net.minecraft.server.v1_7_R4.EnchantmentManager;
import net.minecraft.server.v1_7_R4.EntityLiving;
import net.minecraft.server.v1_7_R4.EntityPlayer;
import net.minecraft.server.v1_7_R4.GenericAttributes;

class DamageResolver_1_7_R4 implements DamageResolver {

	private boolean USE_CRITS, OLD_CRITS;

	DamageResolver_1_7_R4(boolean useCrits, boolean oldCrits) {
		USE_CRITS = useCrits;
		OLD_CRITS = oldCrits;
	}

	@Override
	public DamageAttribute getDamage(Player damager, Damageable entity) {
		EntityPlayer nmsp = ((CraftPlayer) damager).getHandle();
		double damage = nmsp.getAttributeInstance(GenericAttributes.e).getValue();
		int damageType = DamageType.NORMAL;
		damage += EnchantmentManager.a((EntityLiving) nmsp, ((EntityLiving) ((CraftEntity) entity).getHandle()));
		if (USE_CRITS && !((Entity) damager).isOnGround() && damager.getVelocity().getY() < 0 && OLD_CRITS || damager.isSprinting()) {
			damageType = DamageType.CRITICAL;
			damage *= 1.5;
		}
		return new DamageAttribute(damage, damageType);
	}

}
