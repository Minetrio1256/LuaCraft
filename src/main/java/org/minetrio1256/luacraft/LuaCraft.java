package org.minetrio1256.luacraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public final class LuaCraft extends JavaPlugin {

    private Globals globals;

    @Override
    public void onEnable() {
        // Initialize LuaJ
        globals = JsePlatform.standardGlobals();

        // Expose necessary objects to Lua environment
        globals.set("plugin", LuaValue.userdataOf(this));
        globals.set("server", LuaValue.userdataOf(getServer()));

        // Load Lua scripts
        loadLuaScripts();
    }

    private void loadLuaScripts() {
        File scriptsFolder = new File(getDataFolder(), "scripts");
        if (!scriptsFolder.exists()) {
            scriptsFolder.mkdirs();
        }

        File[] scriptFiles = scriptsFolder.listFiles((dir, name) -> name.endsWith(".lua"));
        if (scriptFiles == null) {
            getLogger().warning("No Lua scripts found.");
            return;
        }

        for (File scriptFile : scriptFiles) {
            try {
                LuaValue chunk = globals.load(new FileReader(scriptFile), scriptFile.getName());
                chunk.call(); // Execute the loaded Lua chunk
            } catch (IOException e) {
                getLogger().warning("Error loading Lua script: " + scriptFile.getName());
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
