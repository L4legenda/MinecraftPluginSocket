package testPlugin2.l4legenda;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	
	
	
	queueSocket soc;
	
	public void onEnable(){
        getLogger().info("enable");
        soc = new queueSocket();
        soc.start();
        
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			
			@Override
			public void run() {
				if(Weather.weater) {
					Weather.Storm();
				}else {
					Weather.NotStorm();
				}
				
			}
		}, 0, 20);
        
    }
    public void onDisable(){
        getLogger().info("disable");
        soc.close();
    }
    
    
}
