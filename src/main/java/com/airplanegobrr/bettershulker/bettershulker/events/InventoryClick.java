package com.airplanegobrr.bettershulker.bettershulker.events;

import com.airplanegobrr.bettershulker.bettershulker.Bettershulker;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class InventoryClick implements Listener {
    private final Bettershulker main;

    public InventoryClick(Bettershulker main) {
        this.main = main;
    }


    @EventHandler
    public void InventoryClickEvent(InventoryClickEvent event){
        main.log(" ");
        main.log("InventoryClickEvent");
        Inventory inv = event.getClickedInventory();
        Inventory inv2 = event.getInventory();
        ItemStack item = event.getCurrentItem();
        ItemStack itemHolding = event.getCursor();
        Boolean shift = event.isShiftClick();
        InventoryAction action = event.getAction();
        Event.Result res = event.getResult();
        
        //Werid inv null error fix
        if (inv == null || inv2 == null) return;

        int slot = event.getSlot();
        int slot2 = event.getRawSlot();

        main.log("Inv: " + inv.getType().toString());
        main.log("Inv2: " + inv2.getType().toString());
        main.log("Clicked item: " + item.getType().toString());
        main.log("Item holding: " + itemHolding.getType().toString());
        main.log("Result: " + res.toString());
        main.log("Is the inv the block? " + (inv.getType().toString() == itemHolding.getType().toString()));
        main.log("Is the item we are clicking air? " + String.valueOf(item.getType().toString() == "AIR"));

        //slots
        main.log("Slot: "+slot);
        main.log("Slot2: "+slot2);
        //Log action
        main.log("Action: "+action.toString());

        if (inv.getType().toString().contains("SHULKER") && itemHolding.getType().toString().contains("SHULKER")){

            event.setCancelled(true);
            if (item.getType().toString() == "AIR"){
                main.log("Item is air. Placing item.");
                event.setCurrentItem(itemHolding);
                itemHolding.setAmount(0);
            } else {
                //swap code
                main.log("Swapping");
                ItemStack temp = item;
                event.setCurrentItem(itemHolding);
                itemHolding.setAmount(0);
                event.setCursor(temp);
            }
        }

        if (inv2.getType().toString() == item.getType().toString() & shift){
            if (inv == inv2) return;
            event.setCancelled(true);
            main.log("Shift clicked!");
            //check that inv2 has enough space to add the item
            if (inv2.firstEmpty() != -1){
                inv2.addItem(item);
                inv.removeItem(item);
            }
        }
        main.log(" ");
    }
}
