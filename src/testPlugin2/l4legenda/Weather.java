package testPlugin2.l4legenda;

import org.bukkit.Bukkit;

public class Weather {
	
	public volatile static boolean weater = false;
	
	public static void Storm() {
		Bukkit.getWorld("world").setStorm(true);
	}
	
	public static void NotStorm() {
		Bukkit.getWorld("world").setStorm(false);
	}
}
