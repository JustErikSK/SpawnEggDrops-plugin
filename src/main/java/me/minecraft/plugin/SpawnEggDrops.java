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
        } else if (ent.getType() == EntityType.BREEZE && num < 2) {
            e.getDrops().add(new ItemStack(Material.BREEZE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CREEPER && num < 2) {
            e.getDrops().add(new ItemStack(Material.CREEPER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ELDER_GUARDIAN && num < 2) {
            e.getDrops().add(new ItemStack(Material.ELDER_GUARDIAN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ENDERMITE && num < 2) {
            e.getDrops().add(new ItemStack(Material.ENDERMITE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.EVOKER && num < 2) {
            e.getDrops().add(new ItemStack(Material.EVOKER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.GHAST && num < 2) {
            e.getDrops().add(new ItemStack(Material.GHAST_SPAWN_EGG));
        } else if (ent.getType() == EntityType.GUARDIAN && num < 2) {
            e.getDrops().add(new ItemStack(Material.GUARDIAN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.HOGLIN && num < 2) {
            e.getDrops().add(new ItemStack(Material.HOGLIN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.HUSK && num < 2) {
            e.getDrops().add(new ItemStack(Material.HUSK_SPAWN_EGG));
        } else if (ent.getType() == EntityType.MAGMA_CUBE && num < 2) {
            e.getDrops().add(new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PHANTOM && num < 2) {
            e.getDrops().add(new ItemStack(Material.PHANTOM_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PIGLIN_BRUTE && num < 2) {
            e.getDrops().add(new ItemStack(Material.PIGLIN_BRUTE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PILLAGER && num < 2) {
            e.getDrops().add(new ItemStack(Material.PILLAGER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.RAVAGER && num < 2) {
            e.getDrops().add(new ItemStack(Material.RAVAGER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SHULKER && num < 2) {
            e.getDrops().add(new ItemStack(Material.SHULKER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SILVERFISH && num < 2) {
            e.getDrops().add(new ItemStack(Material.SILVERFISH_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SKELETON && num < 2) {
            e.getDrops().add(new ItemStack(Material.SKELETON_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SLIME && num < 2) {
            e.getDrops().add(new ItemStack(Material.SLIME_SPAWN_EGG));
        } else if (ent.getType() == EntityType.STRAY && num < 2) {
            e.getDrops().add(new ItemStack(Material.STRAY_SPAWN_EGG));
        } else if (ent.getType() == EntityType.VINDICATOR && num < 2) {
            e.getDrops().add(new ItemStack(Material.VINDICATOR_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WARDEN && num < 15) {
            e.getDrops().add(new ItemStack(Material.WARDEN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WITCH && num < 2) {
            e.getDrops().add(new ItemStack(Material.WITCH_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WITHER_SKELETON && num < 2) {
            e.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOGLIN && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOGLIN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOMBIE && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOMBIE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOMBIE_VILLAGER && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG));
        }

        // NEUTRAL MOBS
        else if (ent.getType() == EntityType.BEE && num < 2) {
            e.getDrops().add(new ItemStack(Material.BEE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CAVE_SPIDER && num < 2) {
            e.getDrops().add(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.DOLPHIN && num < 2) {
            e.getDrops().add(new ItemStack(Material.DOLPHIN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.DROWNED && num < 2) {
            e.getDrops().add(new ItemStack(Material.DROWNED_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ENDERMAN && num < 2) {
            e.getDrops().add(new ItemStack(Material.ENDERMAN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.FOX && num < 2) {
            e.getDrops().add(new ItemStack(Material.FOX_SPAWN_EGG));
        } else if (ent.getType() == EntityType.GOAT && num < 2) {
            e.getDrops().add(new ItemStack(Material.GOAT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.IRON_GOLEM && num < 2) {
            e.getDrops().add(new ItemStack(Material.IRON_GOLEM_SPAWN_EGG));
        } else if (ent.getType() == EntityType.LLAMA && num < 2) {
            e.getDrops().add(new ItemStack(Material.LLAMA_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PANDA && num < 2) {
            e.getDrops().add(new ItemStack(Material.PANDA_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PIGLIN && num < 2) {
            e.getDrops().add(new ItemStack(Material.PIGLIN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.POLAR_BEAR && num < 2) {
            e.getDrops().add(new ItemStack(Material.POLAR_BEAR_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SPIDER && num < 2) {
            e.getDrops().add(new ItemStack(Material.SPIDER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.TRADER_LLAMA && num < 2) {
            e.getDrops().add(new ItemStack(Material.TRADER_LLAMA_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WOLF && num < 2) {
            e.getDrops().add(new ItemStack(Material.WOLF_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ZOMBIFIED_PIGLIN && num < 2) {
            e.getDrops().add(new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG));
        }

        // PASSIVE MOBS
        else if (ent.getType() == EntityType.ALLAY && num < 2) {
            e.getDrops().add(new ItemStack(Material.ALLAY_SPAWN_EGG));
        } else if (ent.getType() == EntityType.ARMADILLO && num < 2) {
            e.getDrops().add(new ItemStack(Material.ARMADILLO_SPAWN_EGG));
        } else if (ent.getType() == EntityType.AXOLOTL && num < 2) {
            e.getDrops().add(new ItemStack(Material.AXOLOTL_SPAWN_EGG));
        } else if (ent.getType() == EntityType.BAT && num < 2) {
            e.getDrops().add(new ItemStack(Material.BAT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CAMEL && num < 2) {
            e.getDrops().add(new ItemStack(Material.CAMEL_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CAT && num < 2) {
            e.getDrops().add(new ItemStack(Material.CAT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.CHICKEN && num < 2) {
            e.getDrops().add(new ItemStack(Material.CHICKEN_SPAWN_EGG));
        } else if (ent.getType() == EntityType.COD && num < 2) {
            e.getDrops().add(new ItemStack(Material.COD_SPAWN_EGG));
        } else if (ent.getType() == EntityType.COW && num < 2) {
            e.getDrops().add(new ItemStack(Material.COW_SPAWN_EGG));
        } else if (ent.getType() == EntityType.DONKEY && num < 2) {
            e.getDrops().add(new ItemStack(Material.DONKEY_SPAWN_EGG));
        } else if (ent.getType() == EntityType.FROG && num < 2) {
            e.getDrops().add(new ItemStack(Material.FROG_SPAWN_EGG));
        } else if (ent.getType() == EntityType.GLOW_SQUID && num < 2) {
            e.getDrops().add(new ItemStack(Material.GLOW_SQUID_SPAWN_EGG));
        } else if (ent.getType() == EntityType.HORSE && num < 2) {
            e.getDrops().add(new ItemStack(Material.HORSE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.MOOSHROOM && num < 2) {
            e.getDrops().add(new ItemStack(Material.MOOSHROOM_SPAWN_EGG));
        } else if (ent.getType() == EntityType.MULE && num < 2) {
            e.getDrops().add(new ItemStack(Material.MULE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.OCELOT && num < 2) {
            e.getDrops().add(new ItemStack(Material.OCELOT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PARROT && num < 2) {
            e.getDrops().add(new ItemStack(Material.PARROT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PIG && num < 2) {
            e.getDrops().add(new ItemStack(Material.PIG_SPAWN_EGG));
        } else if (ent.getType() == EntityType.PUFFERFISH && num < 2) {
            e.getDrops().add(new ItemStack(Material.PUFFERFISH_SPAWN_EGG));
        } else if (ent.getType() == EntityType.RABBIT && num < 2) {
            e.getDrops().add(new ItemStack(Material.RABBIT_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SALMON && num < 2) {
            e.getDrops().add(new ItemStack(Material.SALMON_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SHEEP && num < 2) {
            e.getDrops().add(new ItemStack(Material.SHEEP_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SKELETON_HORSE && num < 2) {
            e.getDrops().add(new ItemStack(Material.SKELETON_HORSE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SNIFFER && num < 2) {
            e.getDrops().add(new ItemStack(Material.SNIFFER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SNOW_GOLEM && num < 2) {
            e.getDrops().add(new ItemStack(Material.SNOW_GOLEM_SPAWN_EGG));
        } else if (ent.getType() == EntityType.SQUID && num < 2) {
            e.getDrops().add(new ItemStack(Material.SQUID_SPAWN_EGG));
        } else if (ent.getType() == EntityType.STRIDER && num < 2) {
            e.getDrops().add(new ItemStack(Material.STRIDER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.TADPOLE && num < 2) {
            e.getDrops().add(new ItemStack(Material.TADPOLE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.TROPICAL_FISH && num < 2) {
            e.getDrops().add(new ItemStack(Material.TROPICAL_FISH_SPAWN_EGG));
        } else if (ent.getType() == EntityType.TURTLE && num < 2) {
            e.getDrops().add(new ItemStack(Material.TURTLE_SPAWN_EGG));
        } else if (ent.getType() == EntityType.VILLAGER && num < 2) {
            e.getDrops().add(new ItemStack(Material.VILLAGER_SPAWN_EGG));
        } else if (ent.getType() == EntityType.WANDERING_TRADER && num < 2) {
            e.getDrops().add(new ItemStack(Material.WANDERING_TRADER_SPAWN_EGG));
        }
    }
}
