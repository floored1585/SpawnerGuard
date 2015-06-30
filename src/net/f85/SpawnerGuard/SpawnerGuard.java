//
// SpawnerGuard copyright 2015 Ian Clark
//
// Distributed under the MIT License
// http://opensource.org/licenses/MIT
//
package net.f85.SpawnerGuard;

import net.f85.SpawnerGuard.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.*;
import org.bukkit.configuration.file.*;
import java.util.logging.*;

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


}
