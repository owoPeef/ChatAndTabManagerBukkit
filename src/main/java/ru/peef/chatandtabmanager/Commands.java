package ru.peef.chatandtabmanager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

import static org.bukkit.plugin.java.JavaPlugin.*;

public class Commands implements CommandExecutor {
    public static Plugin pl = getPlugin(ChatAndTabManagerBukkit.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player player)) { return true; }
        if (cmd.getName().equalsIgnoreCase("chatandtabmanager")) {
            if (args.length == 0) {
                About.sendInfoToPlayer(player, cmd.getName());
            }
            if (args.length == 1) {
                if (Objects.equals(args[0], "reload") && player.hasPermission("chatandtabmanager.config_reload")) {
                    pl.reloadConfig();
                    pl.saveConfig();
                    player.sendMessage("§aConfig reloaded!");
                }
            }
        }
        return true;
    }
}
