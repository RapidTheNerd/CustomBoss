package me.rtn.cb.packets;

import net.minecraft.server.v1_11_R1.EntityInsentient;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by George on 05-Apr-17 on Apr at 10:46 PM.
 */
public class NMSUtil {

    public void register(String name, int id, Class<? extends EntityInsentient> nmsClass, Class<? extends EntityInsentient> customClass){
        try {

            List<Map<?, ?>> data = new ArrayList<Map<?, ?>>();
            for(Field field : EntityType.class.getDeclaredFields()){

                if(field.getType().getSimpleName() == Map.class.getSimpleName()){
                    field.setAccessible(true);
                    data.add((Map<?,?>) field.get(null));
                }
            }

            if(data.get(2).containsKey(id)){
                data.get(0).remove(name);
                data.get(2).remove(id);
            }

            Method entityType = EntityType.class.getDeclaredMethod("a", Class.class, String.class, int.class);
            entityType.setAccessible(true);
            entityType.invoke(null, customClass, name, id);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
