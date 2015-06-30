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
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.*;
import java.util.ArrayList;

public class SpawnerGuardListener implements Listener {


  private SpawnerGuard plugin;


  public SpawnerGuardListener(SpawnerGuard plugin) {
    this.plugin = plugin;
    plugin.getServer().getPluginManager().registerEvents(this, plugin);
  }


  @EventHandler
  public void onCreatureSpawn(CreatureSpawnEvent e) {
    LivingEntity en = e.getEntity();
    EntityType type = e.getEntityType();

    // If entity was created by a spawner
    if (e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER)) {

      // If the entity is on our invalid creature list (it isn't allowed to come from a spawner)
      if (SpawnerGuard.config.getList("invalid_creatures").contains(type.toString())) {
        // Cancel the spawn!
        e.setCancelled(true);
        SpawnerGuard.log.warning(type.toString() + " generation by spawner prevented near " +
            en.getLocation().getBlockX() + "," +
            en.getLocation().getBlockY() + "," +
            en.getLocation().getBlockZ() +
            " in world: " + en.getLocation().getWorld().getName());
      }
    }
  }

}
