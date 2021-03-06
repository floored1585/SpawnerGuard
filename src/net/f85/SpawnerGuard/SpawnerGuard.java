//
// SpawnerGuard copyright 2015 Ian Clark
//
// Distributed under the MIT License
// http://opensource.org/licenses/MIT
//
package net.f85.SpawnerGuard;

import net.f85.SpawnerGuard.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.*;
import org.bukkit.configuration.file.*;
import java.util.List;
import java.util.logging.*;
import java.util.Random;

public class SpawnerGuard extends JavaPlugin {


  public static SpawnerGuard plugin;
  public static SpawnerGuardListener listener;
  public static Logger log;
  public static FileConfiguration config;


  @Override
  public void onEnable() {

    plugin = this;

    // Generate the default config file
    plugin.saveDefaultConfig();

    config = plugin.getConfig();

    listener = new SpawnerGuardListener(this);
    log = getLogger();

    getLogger().info("Successfully activated SpawnerGuard");
  }


  @Override
  public void onDisable() {
    getLogger().info("Successfully deactivated SpawnerGuard");
  }


  public void changeBadSpawner(Location loc, EntityType type) {
    for (BlockState b : loc.getChunk().getTileEntities()) {
      // Skip to next iteration if this isn't a spawner
      if (b.getType() != Material.MOB_SPAWNER) {
        continue;
      }
      CreatureSpawner spawner = (CreatureSpawner)b;
      if (config.getList("invalid_creatures").contains(spawner.getSpawnedType().toString())) {
        // We have a bad spawner, change it!
        List<String> list = (List<String>)config.getList("spawner_reset_creatures");
        String newType = list.get(new Random().nextInt(list.size()));
        spawner.setSpawnedType(EntityType.valueOf(newType));
      } else if (SpawnerGuard.config.getString("blaze_world_name").equals(loc.getWorld().getName())) {
        // We need to change it to a blaze spawner
        spawner.setSpawnedType(EntityType.BLAZE);
        SpawnerGuard.log.warning(type.toString() + " spawner changed to BLAZE");
      }
    }
  }


}
