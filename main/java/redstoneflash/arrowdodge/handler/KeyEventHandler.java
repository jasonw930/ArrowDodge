package redstoneflash.arrowdodge.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import redstoneflash.arrowdodge.proxy.ClientProxy;

@Mod.EventBusSubscriber
public class KeyEventHandler {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void keyEvent(KeyInputEvent event) {
		if (ClientProxy.keyToggle.isPressed()) {
			TickEventHandler.toggled = !TickEventHandler.toggled;
			Minecraft.getMinecraft().player.sendMessage(new TextComponentString("Arrow Dodge " + (TickEventHandler.toggled ? "Enabled" : "Disabled")));
		}
	}
	
}
