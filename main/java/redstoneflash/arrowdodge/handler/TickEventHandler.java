package redstoneflash.arrowdodge.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber
public class TickEventHandler {

	public static boolean toggled = false;
	public static boolean left = false;
	public static boolean right = false;
	public static boolean found = false;
	public static boolean prevFound = false;
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void playerTickEvent(PlayerTickEvent event) {
		if (!toggled) return;
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayerSP player = mc.player;
		
		prevFound = found;
		found = false;
		for (Entity entity : mc.world.loadedEntityList) {
			if (entity instanceof EntityArrow) {
				EntityArrow arrow = (EntityArrow) entity;
				if ((entity.motionX > 0.8 || entity.motionY > 0.8) && Math.pow(arrow.posX - player.posX, 2) + Math.pow(arrow.posY - player.posY, 2) + Math.pow(arrow.posZ - player.posZ, 2) < 100) {
					double dist = distToLine(player.posX, player.posZ, arrow.posX, arrow.posZ, arrow.posX + arrow.motionX, arrow.posZ + arrow.motionZ);
					
					if (dist >= 0 && dist <= 0.6) {
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), false);
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), true);
						found = true;
						break;
					} else if (dist <= 0 && dist >= -0.6) {
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), true);
						KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), false);
						found = true;
						break;
					}
				}
			}
		}
		if (prevFound && !found) {
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindLeft.getKeyCode(), left);
			KeyBinding.setKeyBindState(mc.gameSettings.keyBindRight.getKeyCode(), right);
		} else if (!found) {
			left = mc.gameSettings.keyBindLeft.isPressed();
			right = mc.gameSettings.keyBindRight.isPressed();
		}
	}
	
	public static double distToPoint(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	
	public static double distToLine(double x1, double y1, double x2, double y2, double x3, double y3) {
		return ((y3 - y2) * x1 - (x3 - x2) * y1 + x3 * y2 - y3 * x2) / distToPoint(x2, y2, x3, y3);
	}
	
	
}
