package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class KnightSlime extends EntityBetterSlime implements ISpecialSlime{

	public KnightSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2);
		this.setHealthModifier(2);
	}
	
	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(entityIn, 0, xRatio, zRatio);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new KnightSlime(this.world);
	}

	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
	}
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}

	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
	}

	@Nullable
    protected ResourceLocation getLootTable() {
        return this.getSlimeSize() == 1 ? BetterSlimes.knightSlimeLT : LootTableList.EMPTY;
    }
}
