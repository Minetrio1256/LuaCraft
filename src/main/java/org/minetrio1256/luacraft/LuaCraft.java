package org.minetrio1256.luacraft;

import org.bukkit.plugin.java.JavaPlugin;

public final class LuaCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("The LuaCraft plugin has loaded!");
        getLogger().info("Now starting Lua scripts!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
