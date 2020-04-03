package com.mic.betterslimes.entity;

import MICDeps.util.handlers.ConfigHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBetterSlime extends EntitySlime {

	public double attackMod = 1;
	public double healthMod = 1;
	public double speedMod = 1;
	private int tick = 0;

	public EntityBetterSlime(World worldIn) {
		super(worldIn);
	}

	@Override
	protected EntityBetterSlime createInstance() {

		return new EntityBetterSlime(this.world);
	}

	public void setAttackModifier(double mod) {
		this.attackMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}

	public void setHealthModifier(double mod) {
		this.healthMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}

	public void setSpeedModifier(double mod) {
		this.speedMod = mod;
		setSlimeSize(getSlimeSize(), true);
	}

	@Override
	protected void updateAITasks() {
		super.updateAITasks();

		if (tick > 200) {
			if (rand.nextInt(ConfigHandler.splitChance) > rand.nextInt(100)) {
				split();
			}
			tick = 0;
		}
		tick++;
	}

	public void split() {
		EntityBetterSlime s = this;
		if (s.getSlimeSize() > 1) {
			EntityBetterSlime p = s.createInstance();
			p.setSlimeSize(1, true);
			p.setLocationAndAngles(this.posX, this.posY + 0.5D, this.posZ, this.rand.nextFloat() * 360.0F, 0.0F);
			this.world.spawnEntity(p);
		}
	}

	@Override
	public void setSlimeSize(int size, boolean resetHealth) {
		super.setSlimeSize(size, resetHealth);

		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) (size * size * attackMod));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED)
				.setBaseValue((double) (0.2F + 0.1F * (float) size * speedMod));

		if (resetHealth) {
			this.setHealth(this.getMaxHealth());
		}
	}

	@Override
	public boolean getCanSpawnHere() {
		if (this.world.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(rand, world)) {
			return false;
		}

		if (this.world.getDifficulty() == EnumDifficulty.PEACEFUL) {
			return false;
		}

		return this.canSpecialSlimeSpawnHere();
	}

	public boolean canSpecialSlimeSpawnHere() {
		return true;
	}

	@Override
	protected boolean canDamagePlayer() {
		return true;
	}
}
