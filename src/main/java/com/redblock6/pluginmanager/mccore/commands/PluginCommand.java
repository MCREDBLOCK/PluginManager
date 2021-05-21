package com.redblock6.pluginmanager.mccore.commands;

import com.redblock6.pluginmanager.PluginManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PluginCommand implements Listener, CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (command.getName().equalsIgnoreCase("load")) {
                if (((Player) sender).getPlayer().hasPermission("redblock.plugins")) {
                    PluginManager.loadPlugin(args[0]);
                }
            } else if (command.getName().equalsIgnoreCase("unload")) {
                if (((Player) sender).getPlayer().hasPermission("redblock.plugins")) {
                    PluginManager.disablePlugin(args[0]);
                }
            } if (command.getName().equalsIgnoreCase("reload")) {
                if (((Player) sender).getPlayer().hasPermission("redblock.plugins")) {
                    PluginManager.reloadPlugin(args[0]);
                }
            }
        } else {
            return true;
        }
        return false;
    }
}
