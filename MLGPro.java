package com.weswaas.mlgpro;

import org.bukkit.plugin.java.JavaPlugin;

import com.weswaas.mlgpro.game.ArenaManager;
import com.weswaas.mlgpro.gui.PlayGUI;
import com.weswaas.mlgpro.listeners.ListenerManager;
import com.weswaas.mlgpro.utils.WorldUtils;

public class MLGPro extends JavaPlugin{
	
	public MLGPro instance;
	private WorldUtils wu;
	private ArenaManager am;
	private PlayGUI gui;
	
	@Override
	public void onEnable() {
		instance = this;
		instances();
		am.registerArenas();
		
		new ListenerManager(this).registerListeners(wu, am, gui);
	}
	
	@Override
	public void onDisable() {
		
	}
	
	private void instances(){
		wu = new WorldUtils();
		am = new ArenaManager(wu);
		gui = new PlayGUI();
	}

}
