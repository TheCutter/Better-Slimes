package MICDeps.proxy;

import com.mic.betterslimes.RenderHandler;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(
						"betterslimes" + ":" + item.getRegistryName().toString().replace("betterslimes" + ":", ""),
						"inventory"));
	}

	@Override
	public void spawnParticle(World worldIn, EnumParticleTypes types, double posX, double posY, double posZ, double d1, double d2, double d3) {
		worldIn.spawnParticle(types, posX, posY, posZ, 0, 0, 0);
	}

	@Override
	public String localize(String unlocalized, Object... args) {
		return I18n.format(unlocalized, args);
	}

	@Override
	public void registerRenders() {
		RenderHandler.registerEntityRenders("betterslimes");
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		System.out.println("PreInit Success");
		// ModItems.registerModels();
	}
}
