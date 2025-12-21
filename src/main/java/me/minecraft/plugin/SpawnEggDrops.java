package me.minecraft.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityTransformEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class SpawnEggDrops extends JavaPlugin implements Listener {

    private NamespacedKey FROM_SPAWNER;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "SpawnEggDrops >> Plugin has been enabled!");
        this.getServer().getPluginManager().registerEvents(this, this);
        saveDefaultConfig();

        FROM_SPAWNER = new NamespacedKey(this, "from_spawner");

        FileConfiguration config = this.getConfig();
        config.addDefault("spawn_egg_drop_percentage", 10);
        config.addDefault("spawn_egg_drop_amount", 1);
        config.addDefault("drops_from_spawners", true);
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    @EventHandler
    public void onMobSpawn(CreatureSpawnEvent e) {
        if (e.getSpawnReason() == CreatureSpawnEvent.SpawnReason.SPAWNER) {
            e.getEntity().getPersistentDataContainer().set(FROM_SPAWNER, PersistentDataType.BYTE, (byte) 1);
        }
    }

    @EventHandler
    public void onTransform(EntityTransformEvent e) {
        if (!(e.getEntity() instanceof LivingEntity original)) return;
        Byte flag = original.getPersistentDataContainer().get(FROM_SPAWNER, PersistentDataType.BYTE);
        if (flag == null || flag != (byte) 1) return;

        for (Entity result : e.getTransformedEntities()) {
            if (result instanceof LivingEntity le) {
                le.getPersistentDataContainer().set(FROM_SPAWNER, PersistentDataType.BYTE, (byte) 1);
            }
        }
    }

    private Material getSpawnEggMaterial(EntityType type) {
        Material egg = Material.matchMaterial(type.name() + "_SPAWN_EGG");
        return egg;
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();
        int roll = ThreadLocalRandom.current().nextInt(100);

        boolean allowSpawnerDrops = this.getConfig().getBoolean("drops_from_spawners", true);
        boolean fromSpawner = ent.getPersistentDataContainer().has(FROM_SPAWNER, PersistentDataType.BYTE);

        if (fromSpawner && !allowSpawnerDrops) return;

        int dropPercentage = this.getConfig().getInt("spawn_egg_drop_percentage", 10);
        int dropAmount = this.getConfig().getInt("spawn_egg_drop_amount", 1);
        if (dropPercentage > 100 || dropPercentage < 1) { dropPercentage = 10; }
        if (dropAmount > 10 || dropAmount < 1) { dropAmount = 1; }

        if (roll <= dropPercentage) {
            Material eggMat = getSpawnEggMaterial(ent.getType());
            if (eggMat == null) return;
            if (ent.getType() == EntityType.PLAYER) return;

            e.getDrops().add(new ItemStack(eggMat, dropAmount));
        }
    }
}
