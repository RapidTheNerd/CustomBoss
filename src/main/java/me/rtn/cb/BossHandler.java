package me.rtn.cb;

import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by George on 05-Apr-17 on Apr at 11:18 PM.
 */
public class BossHandler implements Listener {

    @EventHandler
    public void spawnBoss(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName()
                    .equals(CustomBoss.getInstance().getSpawnEgg().getItemMeta())){

            }
        }
    }
    @EventHandler
    public void onDeath(EntityDeathEvent event){
        if(event.getEntity() instanceof Zombie){

            if(event.getEntity().getCustomName() == null){
                return;
            }
            if(event.getEntity().getCustomName().equals(CustomBoss.getInstance().getSpawnEgg().getItemMeta().getDisplayName())){
                for(int i = 0; i < 64; i++){
                    Item coal = event.getEntity().getWorld().dropItem(event.getEntity().getLocation(), new ItemStack(Material.COAL, 1));
                }
            }
        }
    }
}
