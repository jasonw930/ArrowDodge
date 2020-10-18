package redstoneflash.arrowdodge;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import redstoneflash.arrowdodge.proxy.CommonProxy;

@Mod(modid = ArrowDodge.MODID, name = ArrowDodge.NAME, version = ArrowDodge.VERSION)
public class ArrowDodge {
	
    public static final String MODID = "arrowdodge";
    public static final String NAME = "Arrow Dodge";
    public static final String VERSION = "v0.1";
    
    @Instance
    public static ArrowDodge instance;
    
    @SidedProxy(serverSide = "redstoneflash.arrowdodge.proxy.ServerProxy", clientSide = "redstoneflash.arrowdodge.proxy.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
    	proxy.init(event);
    }
    
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
    
}
