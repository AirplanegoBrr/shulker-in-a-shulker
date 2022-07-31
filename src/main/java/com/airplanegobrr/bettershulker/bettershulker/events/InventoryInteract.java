package com.airplanegobrr.bettershulker.bettershulker.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryInteractEvent;
import com.airplanegobrr.bettershulker.bettershulker.Bettershulker;

public class InventoryInteract implements Listener {
    private final Bettershulker main;

    public InventoryInteract(Bettershulker main) {
        this.main = main;
    }

    @EventHandler
    public void InventoryInteractEvent(InventoryInteractEvent event){
        main.log("InventoryInteractEvent");
    }
}