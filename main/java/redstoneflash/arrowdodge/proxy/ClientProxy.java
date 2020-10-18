package redstoneflash.arrowdodge.proxy;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	public static KeyBinding keyToggle;
	
    public void preInit(FMLPreInitializationEvent event) {
    	super.preInit(event);
    }

    public void init(FMLInitializationEvent event) {
    	super.init(event);
    	
    	keyToggle = new KeyBinding("Toggle", Keyboard.KEY_P, "Arrow Dodge");

    	ClientRegistry.registerKeyBinding(keyToggle);
    }
    
    public void postInit(FMLPostInitializationEvent event) {
    	super.postInit(event);
    }
    
}
