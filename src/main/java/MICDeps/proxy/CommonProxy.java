package MICDeps.proxy;

import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

	public void registerItemRenderer(Item item, int meta, String id) {
	}

	public String localize(String unlocalized, Object... args) {
		return I18n.translateToLocalFormatted(unlocalized, args);
	}

	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	}

	public void registerRenders() {
	}

	@EventHandler
	public void serverInit(FMLServerStartingEvent event) {
	}

	public void spawnParticle(World worldIn, EnumParticleTypes types, double posX, double posY, double posZ, double d1, double d2, double d3) {
	}
}
