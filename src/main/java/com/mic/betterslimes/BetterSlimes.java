package com.mic.betterslimes;

import MICDeps.ModBase;
import MICDeps.items.ItemBuilder;
import MICDeps.util.handlers.ConfigHandler;
import com.mic.betterslimes.entity.EntityInit;
import com.mic.betterslimes.items.ModItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BetterSlimes.MODID, name = BetterSlimes.NAME, version = BetterSlimes.VERSION)
public class BetterSlimes extends ModBase {
	public static final String MODID = "betterslimes";
	public static final String NAME = "Better Slimes";
	public static final String VERSION = "1.0";

	public static ResourceLocation blueSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","blue_slime"));
	public static ResourceLocation redSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","red_slime"));
	public static ResourceLocation blackSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","black_slime"));
	public static ResourceLocation yellowSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","yellow_slime"));
	public static ResourceLocation purpleSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","purple_slime"));
	public static ResourceLocation skySlimeLT = LootTableList.register(new ResourceLocation("betterslimes","sky_slime"));
	public static ResourceLocation ironSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","iron_slime"));
	public static ResourceLocation goldSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","gold_slime"));
	public static ResourceLocation iceSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","ice_slime"));
	public static ResourceLocation jungleSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","jungle_slime"));
	public static ResourceLocation sandSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","sand_slime"));
	public static ResourceLocation knightSlimeLT = LootTableList.register(new ResourceLocation("betterslimes","knight_slime"));

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) { 
		configHandler = new ConfigHandler(this, MODID);
		ConfigHandler.registerConfig(event);

		itemBuilder = new ItemBuilder(MODID);
		items = new ModItems(itemBuilder);

		EntityInit.registerEntity();
		proxy.registerRenders();

		super.preInit(event);
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		items.oreDict();
		super.init(event);
	}
}