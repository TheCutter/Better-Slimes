package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class RedSlime extends EntityBetterSlime implements ISpecialSlime {

	public RedSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(1.5);
		this.setHealthModifier(1.5);
	}
	
	@Override
	protected EntityBetterSlime createInstance() {
        return new RedSlime(this.world);
    }
	
	@Nullable
    protected ResourceLocation getLootTable() {
        return this.getSlimeSize() == 1 ? BetterSlimes.redSlimeLT : LootTableList.EMPTY;
    }
	
	@Override
	protected int getAttackStrength() {
		return (int) (super.getAttackStrength() * attackMod);
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
	}
}
