package org.minetrio1256.luacraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class LuaCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("The LuaCraft plugin has loaded!");
        getLogger().info("Now starting Lua scripts!");
        String currentDirectory = System.getProperty("user.dir");
        String folderPath = currentDirectory + File.separator + "LuaCraft";

        // Create the folder if it doesn't exist
        File folder = new File(folderPath);
        if (!folder.exists()) {
            boolean created = folder.mkdir();
            if (created) {
                System.out.println("Folder created successfully.");
            } else {
                System.out.println("Failed to create folder.");
                return;
            }
        }

        // List files in the folder
        File[] files = folder.listFiles();
        List<String> fileList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                fileList.add(file.getName());
            }
        }

        // Display the list of files
        System.out.println("Files in the folder:");
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
