# SpawnerGuard
A simple plugin for disabling spawners of specific entities under certain conditions.

## Requirements
This plugin is built against the [Spigot](http://www.spigotmc.org) Minecraft server.  Your mileage may vary with other servers.

To install, simply place the JAR in your plugins folder.

## config.yml
* creative_worlds (List of Strings): A list of world names in which to disable this plugin.
* invalid_creatures (List of Strings): A list of creatures that should not be allowed to spawn from spawners.
* reset_invalid_spawners (Boolean): Whether or not invalid spawners, when detected, should be converted to one of the types in spawner_reset_creatures.
* spawner_reset_creatures: (List of Strings): A list of valid spawner types, used when converting an invalid spawner.
* spawner_modification_allowed: (Boolean): Whether or not players can change spawners with monster eggs.
* warning_text (String): The message sent to a player when they are prevented from changing a spawner with a monster egg.

## Contribute
If you have specific suggestions or if you find a bug, please don't hesitate to open an issue.  If you have time clone this repo and submit a pull request for your idea, go for it!

## License
SpawnerGuard is distributed under the MIT license.  Be free!!
