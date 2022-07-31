package com.airplanegobrr.bettershulker.bettershulker.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import com.airplanegobrr.bettershulker.bettershulker.Bettershulker;

public class InventoryMoveItem implements Listener {
    private final Bettershulker main;

    public InventoryMoveItem(Bettershulker main) {
        this.main = main;
    }

    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event){
        main.log("onInventoryMoveItem");
        main.log(String.valueOf(event.getDestination().getType().toString().contains("SHULKER")));
        main.log(String.valueOf(event.getItem().getType().toString().contains("SHULKER")));
        if (event.getDestination().getType().toString().contains("SHULKER") == event.getItem().getType().toString().contains("SHULKER")){
            //move item to inv block with BukkitRunnable to delay
            event.getDestination().addItem(event.getItem());
            //remove item from inv block
            event.getSource().removeItem(event.getItem());
            event.setCancelled(true);
        }
    }
}