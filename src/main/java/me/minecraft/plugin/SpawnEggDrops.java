package me.minecraft.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
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
        saveDefaultConfig();

        FileConfiguration config = this.getConfig();
        config.addDefault("spawn_egg_drop_percentage", 10);
        config.addDefault("spawn_egg_drop_amount", 1);
        config.addDefault("drops_from_spawners", "true");
    }

    @EventHandler
    public void mobDeath(EntityDeathEvent e) {
        LivingEntity ent = e.getEntity();
        Random ran = new Random();
        int num = ran.nextInt(100);

        int sed_pe = this.getConfig().getInt("spawn_egg_drop_percentage", 10);
        int sed_am = this.getConfig().getInt("spawn_egg_drop_amount", 1);
        String spawner_drop = this.getConfig().getString("drops_from_spawners", "true");

        if (sed_pe > 100 || sed_pe < 1) {
            sed_pe = 10;
        }
        if (sed_am > 10 || sed_am < 1) {
            sed_am = 1;
        }

        if (spawner_drop.equals("true")) {
            // HOSTILE MOBS
            if (num <= sed_pe) {
                if (ent.getType() == EntityType.BLAZE) {
                    e.getDrops().add(new ItemStack(Material.BLAZE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.BOGGED) {
                    e.getDrops().add(new ItemStack(Material.BOGGED_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.BREEZE) {
                    e.getDrops().add(new ItemStack(Material.BREEZE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CREEPER) {
                    e.getDrops().add(new ItemStack(Material.CREEPER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ELDER_GUARDIAN) {
                    e.getDrops().add(new ItemStack(Material.ELDER_GUARDIAN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ENDERMITE) {
                    e.getDrops().add(new ItemStack(Material.ENDERMITE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.EVOKER) {
                    e.getDrops().add(new ItemStack(Material.EVOKER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.GHAST) {
                    e.getDrops().add(new ItemStack(Material.GHAST_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.GUARDIAN) {
                    e.getDrops().add(new ItemStack(Material.GUARDIAN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.HOGLIN) {
                    e.getDrops().add(new ItemStack(Material.HOGLIN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.HUSK) {
                    e.getDrops().add(new ItemStack(Material.HUSK_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.MAGMA_CUBE) {
                    e.getDrops().add(new ItemStack(Material.MAGMA_CUBE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PHANTOM) {
                    e.getDrops().add(new ItemStack(Material.PHANTOM_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PIGLIN_BRUTE) {
                    e.getDrops().add(new ItemStack(Material.PIGLIN_BRUTE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PILLAGER) {
                    e.getDrops().add(new ItemStack(Material.PILLAGER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.RAVAGER) {
                    e.getDrops().add(new ItemStack(Material.RAVAGER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SHULKER) {
                    e.getDrops().add(new ItemStack(Material.SHULKER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SILVERFISH) {
                    e.getDrops().add(new ItemStack(Material.SILVERFISH_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SKELETON) {
                    e.getDrops().add(new ItemStack(Material.SKELETON_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SLIME) {
                    e.getDrops().add(new ItemStack(Material.SLIME_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.STRAY) {
                    e.getDrops().add(new ItemStack(Material.STRAY_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.VINDICATOR) {
                    e.getDrops().add(new ItemStack(Material.VINDICATOR_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.WARDEN) {
                    e.getDrops().add(new ItemStack(Material.WARDEN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.WITCH) {
                    e.getDrops().add(new ItemStack(Material.WITCH_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.WITHER_SKELETON) {
                    e.getDrops().add(new ItemStack(Material.WITHER_SKELETON_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ZOGLIN) {
                    e.getDrops().add(new ItemStack(Material.ZOGLIN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ZOMBIE) {
                    e.getDrops().add(new ItemStack(Material.ZOMBIE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ZOMBIE_VILLAGER) {
                    e.getDrops().add(new ItemStack(Material.ZOMBIE_VILLAGER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CREAKING) {
                    e.getDrops().add(new ItemStack(Material.CREAKING_SPAWN_EGG, sed_am));
                }

                // NEUTRAL MOBS
                else if (ent.getType() == EntityType.BEE) {
                    e.getDrops().add(new ItemStack(Material.BEE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CAVE_SPIDER) {
                    e.getDrops().add(new ItemStack(Material.CAVE_SPIDER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.DOLPHIN) {
                    e.getDrops().add(new ItemStack(Material.DOLPHIN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.DROWNED) {
                    e.getDrops().add(new ItemStack(Material.DROWNED_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ENDERMAN) {
                    e.getDrops().add(new ItemStack(Material.ENDERMAN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.FOX) {
                    e.getDrops().add(new ItemStack(Material.FOX_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.GOAT) {
                    e.getDrops().add(new ItemStack(Material.GOAT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.IRON_GOLEM) {
                    e.getDrops().add(new ItemStack(Material.IRON_GOLEM_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.LLAMA) {
                    e.getDrops().add(new ItemStack(Material.LLAMA_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PANDA) {
                    e.getDrops().add(new ItemStack(Material.PANDA_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PIGLIN) {
                    e.getDrops().add(new ItemStack(Material.PIGLIN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.POLAR_BEAR) {
                    e.getDrops().add(new ItemStack(Material.POLAR_BEAR_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SPIDER) {
                    e.getDrops().add(new ItemStack(Material.SPIDER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.TRADER_LLAMA) {
                    e.getDrops().add(new ItemStack(Material.TRADER_LLAMA_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.WOLF) {
                    e.getDrops().add(new ItemStack(Material.WOLF_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ZOMBIFIED_PIGLIN) {
                    e.getDrops().add(new ItemStack(Material.ZOMBIFIED_PIGLIN_SPAWN_EGG, sed_am));
                }

                // PASSIVE MOBS
                else if (ent.getType() == EntityType.ALLAY) {
                    e.getDrops().add(new ItemStack(Material.ALLAY_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.ARMADILLO) {
                    e.getDrops().add(new ItemStack(Material.ARMADILLO_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.AXOLOTL) {
                    e.getDrops().add(new ItemStack(Material.AXOLOTL_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.BAT) {
                    e.getDrops().add(new ItemStack(Material.BAT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CAMEL) {
                    e.getDrops().add(new ItemStack(Material.CAMEL_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CAT) {
                    e.getDrops().add(new ItemStack(Material.CAT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.CHICKEN) {
                    e.getDrops().add(new ItemStack(Material.CHICKEN_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.COD) {
                    e.getDrops().add(new ItemStack(Material.COD_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.COPPER_GOLEM) {
                    e.getDrops().add(new ItemStack(Material.COPPER_GOLEM_SPAWN_EGG));
                } else if (ent.getType() == EntityType.COW) {
                    e.getDrops().add(new ItemStack(Material.COW_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.DONKEY) {
                    e.getDrops().add(new ItemStack(Material.DONKEY_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.FROG) {
                    e.getDrops().add(new ItemStack(Material.FROG_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.GLOW_SQUID) {
                    e.getDrops().add(new ItemStack(Material.GLOW_SQUID_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.HAPPY_GHAST) {
                    e.getDrops().add(new ItemStack(Material.HAPPY_GHAST_SPAWN_EGG));
                } else if (ent.getType() == EntityType.HORSE) {
                    e.getDrops().add(new ItemStack(Material.HORSE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.MOOSHROOM) {
                    e.getDrops().add(new ItemStack(Material.MOOSHROOM_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.MULE) {
                    e.getDrops().add(new ItemStack(Material.MULE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.OCELOT) {
                    e.getDrops().add(new ItemStack(Material.OCELOT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PARROT) {
                    e.getDrops().add(new ItemStack(Material.PARROT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PIG) {
                    e.getDrops().add(new ItemStack(Material.PIG_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.PUFFERFISH) {
                    e.getDrops().add(new ItemStack(Material.PUFFERFISH_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.RABBIT) {
                    e.getDrops().add(new ItemStack(Material.RABBIT_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SALMON) {
                    e.getDrops().add(new ItemStack(Material.SALMON_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SHEEP) {
                    e.getDrops().add(new ItemStack(Material.SHEEP_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SKELETON_HORSE) {
                    e.getDrops().add(new ItemStack(Material.SKELETON_HORSE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SNIFFER) {
                    e.getDrops().add(new ItemStack(Material.SNIFFER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SNOW_GOLEM) {
                    e.getDrops().add(new ItemStack(Material.SNOW_GOLEM_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.SQUID) {
                    e.getDrops().add(new ItemStack(Material.SQUID_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.STRIDER) {
                    e.getDrops().add(new ItemStack(Material.STRIDER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.TADPOLE) {
                    e.getDrops().add(new ItemStack(Material.TADPOLE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.TROPICAL_FISH) {
                    e.getDrops().add(new ItemStack(Material.TROPICAL_FISH_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.TURTLE) {
                    e.getDrops().add(new ItemStack(Material.TURTLE_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.VILLAGER) {
                    e.getDrops().add(new ItemStack(Material.VILLAGER_SPAWN_EGG, sed_am));
                } else if (ent.getType() == EntityType.WANDERING_TRADER) {
                    e.getDrops().add(new ItemStack(Material.WANDERING_TRADER_SPAWN_EGG, sed_am));
                }
            }
        } else if (spawner_drop.equals("false")) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "SpawnEggDrops >> Drops for mobs from spawners are now disabled!");
        }
    }
}
