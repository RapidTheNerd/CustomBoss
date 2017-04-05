package me.rtn.cb;

import me.rtn.cb.packets.NMSUtil;
import net.minecraft.server.v1_11_R1.EntityZombie;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.stream.Stream;

/**
 * Created by George on 05-Apr-17 on Apr at 10:36 PM.
 */
public class CustomBoss extends JavaPlugin implements Listener {

    BossHandler handler = new BossHandler();

    private static CustomBoss instance;

    public static CustomBoss getInstance() {
        return instance;
    }

    public ItemStack spawnEgg;

    @Override
    public void onEnable(){

        NMSUtil util = new NMSUtil();

        util.register("OP FUCKER", "54", EntityZombie.class, CustomBoss.class);

        instance = this;

        spawnEgg = new ItemStack(Material.MOB_SPAWNER, 1);
        ItemMeta eggMeta = spawnEgg.getItemMeta();
        eggMeta.setDisplayName(ChatColor.RED + "HAVE FUN!");
        spawnEgg.setItemMeta(eggMeta);
        handler.addGlow(spawnEgg);

        Stream.of(
                new BossHandler()
        ).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable(){

    }

    public ItemStack getSpawnEgg() {
        return spawnEgg;
    }
}
