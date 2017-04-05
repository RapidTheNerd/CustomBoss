package me.rtn.cb;

import net.minecraft.server.v1_11_R1.EntityZombie;
import net.minecraft.server.v1_11_R1.GenericAttributes;
import net.minecraft.server.v1_11_R1.World;
import org.bukkit.ChatColor;

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
}
