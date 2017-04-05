package me.rtn.cb;

import net.minecraft.server.v1_11_R1.EnumItemSlot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

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

                    float x = (float) (Math.random() + Math.PI * 2);
                    float y = (float) (Math.random() + Math.PI * 2);
                    float z = (float) (Math.random() + Math.PI * 2);

                    coal.setVelocity(new Vector(x,y,z));

                }

                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta sMeta = sword.getItemMeta();
                sMeta.setDisplayName(ChatColor.AQUA + ChatColor.BOLD.toString() + "A OP sword");
                sword.setItemMeta(sMeta);

                sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
                sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1000);
                sword.setDurability((short) 1000);
                sword.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);

                event.getEntity().getWorld().dropItem(event.getEntity().getLocation().add(0,1,0),sword);
            }
        }
    }

    @EventHandler
    public void spawn(EntitySpawnEvent event){
        if(event.getEntity().getCustomName() == null){
            return;
        }
        if(event.getEntity().getCustomName().equals(CustomBoss.getInstance().getSpawnEgg().getItemMeta().getDisplayName())){

            ItemStack mobSword = new ItemStack(Material.IRON_SWORD);
            mobSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 500);


            ItemStack mobHelm = new ItemStack(Material.PUMPKIN);
            mobHelm.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 50);
            mobHelm.addUnsafeEnchantment(Enchantment.THORNS, 10);

            ItemStack mobChest = new ItemStack(Material.GOLD_CHESTPLATE);
            mobChest.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 50);
            mobChest.addUnsafeEnchantment(Enchantment.THORNS, 1);

            ItemStack mobLeg = new ItemStack(Material.GOLD_LEGGINGS);
            mobLeg.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 50);

            ItemStack mobBoots = new ItemStack(Material.GOLD_BOOTS);
            mobBoots.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 50);

            net.minecraft.server.v1_11_R1.ItemStack nmsSword = CraftItemStack.asNMSCopy(mobSword);
            net.minecraft.server.v1_11_R1.ItemStack nmsChest = CraftItemStack.asNMSCopy(mobChest);
            net.minecraft.server.v1_11_R1.ItemStack nmsHelm = CraftItemStack.asNMSCopy(mobHelm);
            net.minecraft.server.v1_11_R1.ItemStack nmsBoots = CraftItemStack.asNMSCopy(mobBoots);
            net.minecraft.server.v1_11_R1.ItemStack nmsLegs = CraftItemStack.asNMSCopy(mobLeg);
            //Is there an easier way to do this shit?

            ((CraftLivingEntity)event.getEntity()).getHandle().setEquipment(EnumItemSlot.MAINHAND, nmsSword);
            ((CraftLivingEntity)event.getEntity()).getHandle().setEquipment(EnumItemSlot.CHEST, nmsChest);
            ((CraftLivingEntity)event.getEntity()).getHandle().setEquipment(EnumItemSlot.HEAD, nmsHelm);
            ((CraftLivingEntity)event.getEntity()).getHandle().setEquipment(EnumItemSlot.LEGS, nmsLegs);
            ((CraftLivingEntity) event.getEntity()).getHandle().setEquipment(EnumItemSlot.FEET, nmsBoots);

        }
    }
}
