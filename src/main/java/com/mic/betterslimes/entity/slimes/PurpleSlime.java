package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class PurpleSlime extends EntityBetterSlime implements ISpecialSlime {

	public PurpleSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2.5);
		this.setHealthModifier(2);
	}
	
	@Override
	protected EntityBetterSlime createInstance() {
        return new PurpleSlime(this.world);
    }
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}
	
	@Nullable
    protected ResourceLocation getLootTable() {
        return this.getSlimeSize() == 1 ? BetterSlimes.purpleSlimeLT : LootTableList.EMPTY;
    }
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
	}
}
