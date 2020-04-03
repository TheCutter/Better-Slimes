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

public class GoldSlime extends EntityBetterSlime implements ISpecialSlime{

	public GoldSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(3);
		this.setHealthModifier(4);
	}
	
	@Override
	public void knockBack(Entity entityIn, float strength, double xRatio, double zRatio) {
		super.knockBack(entityIn, 0, xRatio, zRatio);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new GoldSlime(this.world);
	}

	@Override
	public boolean canSpecialSlimeSpawnHere() {
		return this.posY < 29 && this.posY > 4;
	}

	@Override
	protected SoundEvent getSquishSound() {
		return SoundEvents.ITEM_ARMOR_EQUIP_GOLD;
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
        return this.getSlimeSize() == 1 ? BetterSlimes.goldSlimeLT : LootTableList.EMPTY;
    }
}
