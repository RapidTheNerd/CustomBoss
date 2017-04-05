package me.rtn.cb;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by George on 05-Apr-17 on Apr at 10:36 PM.
 */
public class CustomBoss extends JavaPlugin implements Listener {

    private static CustomBoss instance;

    public static CustomBoss getInstance() {
        return instance;
    }

    @Override
    public void onEnable(){
        instance = this;
    }

    @Override
    public void onDisable(){

    }

}
