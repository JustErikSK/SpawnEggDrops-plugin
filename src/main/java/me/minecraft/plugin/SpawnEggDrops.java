package me.minecraft.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class SpawnEggDrops extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GREEN + "SpawnEggDrops >> Plugin has been enabled!");
        this.getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();
        Random ran = new Random();
        int num = ran.nextInt(100);

        // HOSTILE MOBS
        if (ent.getType() == EntityType.BLAZE && num < 2) {
            e.getDrops().add(new ItemStack(Material.BLAZE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.BOGGED && num < 2) {
            e.getDrops().add(new ItemStack(Material.BOGGED_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CREEPER && num < 2) {
            e.getDrops().add(new ItemStack(Material.CREEPER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.HUSK && num < 2) {
            e.getDrops().add(new ItemStack(Material.HUSK_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SKELETON && num < 2) {
            e.getDrops().add(new ItemStack(Material.SKELETON_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SLIME && num < 2) {
            e.getDrops().add(new ItemStack(Material.SLIME_SPAWN_EGG));
        } else if (ent.getType() == EntityType.STRAY && num < 2) {
            e.getDrops().add(new ItemStack(Material.STRAY_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WARDEN && num < 15) {
            e.getDrops().add(new ItemStack(Material.WARDEN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WITCH && num < 2) {
            e.getDrops().add(new ItemStack(Material.WITCH_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WITHER_SKELETON && num < 2) {
            e.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOMBIE && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOMBIE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOMBIE_VILLAGER && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
        }

        // NEUTRAL MOBS
        else if (ent.getType() == EntityType.CAVE_SPIDER && num < 2) {
            e.getDrops().add(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SPIDER && num < 2) {
            e.getDrops().add(new ItemStack(Material.SPIDER_SPAWN_EGG));
        }

        // PASSIVE MOBS
        else if (ent.getType() == EntityType.ALLAY && num < 2) {
            e.getDrops().add(new ItemStack(Material.ALLAY_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ARMADILLO && num < 2) {
            e.getDrops().add(new ItemStack(Material.ARMADILLO_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CHICKEN && num < 2) {
            e.getDrops().add(new ItemStack(Material.CHICKEN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.COW && num < 2) {
            e.getDrops().add(new ItemStack(Material.COW_SPAWN_EGG));
        } else if (ent.getType() == EntityType.FROG && num < 2) {
            e.getDrops().add(new ItemStack(Material.FROG_SPAWN_EGG));
        } else if (ent.getType() == EntityType.MOOSHROOM && num < 2) {
            e.getDrops().add(new ItemStack(Material.MOOSHROOM_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PIG && num < 2) {
            e.getDrops().add(new ItemStack(Material.PIG_SPAWN_EGG));
        } else if (ent.getType() == EntityType.RABBIT && num < 2) {
            e.getDrops().add(new ItemStack(Material.RABBIT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SHEEP && num < 2) {
            e.getDrops().add(new ItemStack(Material.SHEEP_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SNIFFER && num < 2) {
            e.getDrops().add(new ItemStack(Material.SNIFFER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.TURTLE && num < 2) {
            e.getDrops().add(new ItemStack(Material.TURTLE_SPAWN_EGG));
        }
    }
}
