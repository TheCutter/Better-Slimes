package com.mic.betterslimes.entity.slimes;

import com.mic.betterslimes.BetterSlimes;
import com.mic.betterslimes.entity.EntityBetterSlime;
import com.mic.betterslimes.entity.ISpecialSlime;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.LootTableList;

import javax.annotation.Nullable;

public class BlueSlime extends EntityBetterSlime implements ISpecialSlime {

	public BlueSlime(World worldIn) {
		super(worldIn);
	}

	@Override
	protected EntityBetterSlime createInstance() {
		return new BlueSlime(this.world);
	}

	@Nullable
	protected ResourceLocation getLootTable() {
		return this.getSlimeSize() == 1 ? BetterSlimes.blueSlimeLT : LootTableList.EMPTY;
	}
}