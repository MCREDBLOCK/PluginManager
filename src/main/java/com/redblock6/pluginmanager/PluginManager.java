package com.redblock6.pluginmanager;

import com.redblock6.pluginmanager.mccore.commands.PluginCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginManager extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("load").setExecutor(new PluginCommand());
        this.getCommand("unload").setExecutor(new PluginCommand());
        this.getCommand("reload").setExecutor(new PluginCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void loadPlugin(String s) {
        org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
        for (Plugin p : pm.getPlugins()) {
            if (p.getName().equals(s)) {
                pm.enablePlugin(p);
            }
        }
    }

    public static void disablePlugin(String s) {
        org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
        for (Plugin p : pm.getPlugins()) {
            if (p.getName().equals(s)) {
                pm.disablePlugin(p);
            }
        }
    }

    public static void reloadPlugin(String s) {
        org.bukkit.plugin.PluginManager pm = Bukkit.getPluginManager();
        for (Plugin p : pm.getPlugins()) {
            if (p.getName().equals(s)) {
                pm.disablePlugin(p);
                pm.enablePlugin(p);
            }
        }
    }
}
