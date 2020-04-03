package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class JungleSlime extends EntityBetterSlime implements ISpecialSlime{

	public JungleSlime(World worldIn) {
		super(worldIn);
		this.setAttackModifier(2.5);
		this.setHealthModifier(2.5);
	}
	
	@Override
	protected EntityBetterSlime createInstance()
    {
        return new JungleSlime(this.world);
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
        return this.getSlimeSize() == 1 ? BetterSlimes.jungleSlimeLT : LootTableList.EMPTY;
    }
}
