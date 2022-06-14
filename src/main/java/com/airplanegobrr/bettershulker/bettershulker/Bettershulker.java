package com.airplanegobrr.bettershulker.bettershulker;

import com.airplanegobrr.bettershulker.bettershulker.events.InventoryMoveItem;
import com.airplanegobrr.bettershulker.bettershulker.events.InventoryInteract;
import com.airplanegobrr.bettershulker.bettershulker.events.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bettershulker extends JavaPlugin {

    @Override
    public void onEnable    () {
        // Plugin startup logic
        //add invMove event listener
        getServer().getPluginManager().registerEvents(new InventoryMoveItem(this), this);
        //add invInteract event listener
        getServer().getPluginManager().registerEvents(new InventoryInteract(this), this);
        //add invClick event listener
        getServer().getPluginManager().registerEvents(new InventoryClick(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
