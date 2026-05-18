package net.withrage.spawnEggDrops121;

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

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public final class SpawnEggDrops121 extends JavaPlugin implements Listener {

    private static final double DEFAULT_DROP_PERCENTAGE = 10.0;
    private static final double MIN_DROP_PERCENTAGE = 0.0001;
    private static final double MAX_DROP_PERCENTAGE = 100.0;

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
        config.addDefault("blacklisted_mobs", Arrays.asList("PLAYER"));
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

    private boolean isBlacklisted(EntityType type) {
        for (String mobName : getConfig().getStringList("blacklisted_mobs")) {
            if (mobName.equalsIgnoreCase(type.name())) {
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();
        double roll = ThreadLocalRandom.current().nextDouble(100.0);

        boolean allowSpawnerDrops = this.getConfig().getBoolean("drops_from_spawners", true);
        boolean fromSpawner = ent.getPersistentDataContainer().has(FROM_SPAWNER, PersistentDataType.BYTE);

        if (fromSpawner && !allowSpawnerDrops) return;

        double dropPercentage = this.getConfig().getDouble("spawn_egg_drop_percentage", DEFAULT_DROP_PERCENTAGE);
        int dropAmount = this.getConfig().getInt("spawn_egg_drop_amount", 1);
        if (dropPercentage > MAX_DROP_PERCENTAGE || dropPercentage < MIN_DROP_PERCENTAGE) { dropPercentage = DEFAULT_DROP_PERCENTAGE; }
        if (dropAmount > 10 || dropAmount < 1) { dropAmount = 1; }

        if (roll < dropPercentage) {
            Material eggMat = getSpawnEggMaterial(ent.getType());
            if (eggMat == null) return;
            if (isBlacklisted(ent.getType())) return;

            e.getDrops().add(new ItemStack(eggMat, dropAmount));
        }
    }
}
