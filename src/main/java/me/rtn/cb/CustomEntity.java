package me.rtn.cb;

import net.minecraft.server.v1_11_R1.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_11_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Zombie;

/**
 * Created by George on 05-Apr-17 on Apr at 11:00 PM.
 */
public class CustomEntity extends EntityZombie {


    public CustomEntity(World world) {
        super(world);
    }

    protected void initAttributes(){
        super.initAttributes();

       this.getAttributeInstance((GenericAttributes.ATTACK_DAMAGE)).setValue(15.0D);
       this.getAttributeInstance((GenericAttributes.maxHealth)).setValue(400D);
       this.setCustomName(ChatColor.RED + "OP FUCKER");
       this.setCustomNameVisible(true);
       this.setBaby(true);
       this.getAttributeInstance((GenericAttributes.MOVEMENT_SPEED)).setValue(100.0D);
    }

    protected Item getLoot(){
        return Items.DIAMOND;
    }

    public static Zombie spawn(Location loc){
        World aWorld = (World) ((CraftWorld)loc.getWorld()).getHandle();

        CustomEntity entity = new CustomEntity(aWorld);
        entity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());

        ((CraftLivingEntity) entity.getBukkitEntity()).setRemoveWhenFarAway(false);

        aWorld.addEntity(entity);

        return (Zombie) entity.getBukkitEntity();
    }
}
