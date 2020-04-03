package MICDeps.util.handlers;

import MICDeps.ModBase;
import MICDeps.items.ItemBuilder;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegistryHandler {
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for (Item item : ItemBuilder.getItemList()) {
			ModBase.proxy.registerItemRenderer(item, 0, "inventory");
		}
	}
}
