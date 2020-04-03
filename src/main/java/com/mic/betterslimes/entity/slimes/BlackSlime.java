package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class BlackSlime extends EntityBetterSlime implements ISpecialSlime{

	public BlackSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(3);
		this.setHealthModifier(3);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new BlackSlime(this.world);
	}

	@Override
	public boolean canSpecialSlimeSpawnHere() {
		return this.posY < 30;
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
        return this.getSlimeSize() == 1 ? BetterSlimes.blackSlimeLT : LootTableList.EMPTY;
    }
}
