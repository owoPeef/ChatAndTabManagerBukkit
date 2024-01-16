package ru.peef.chatandtabmanager.utils;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.peef.chatandtabmanager.ChatAndTabManagerBukkit;

import java.text.DecimalFormat;

public class Messages {
    public static String formatMessage(String message, Player player) {
        return message
                .replace("{player_deaths}", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replace("{player_mobs_killed}", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replace("{player_health}", String.valueOf(player.getHealth()))
                .replace("{player_level}", String.valueOf(player.getLevel()))
                .replace("{player_nickname}", player.getName())
                .replace("&", "§");
    }

    public static String formatMessage(String original_message, String message, Player player) {
        return original_message
                .replace("{player_message}", message)
                .replace("{player_deaths}", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replace("{player_mobs_killed}", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replace("{player_health}", String.valueOf(player.getHealth()))
                .replace("{player_level}", String.valueOf(player.getLevel()))
                .replace("{player_nickname}", player.getName())
                .replace("&", "§");
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String formatMessage(String original_message, Player player, boolean needExtension) {
        int player_level = player.getLevel();
        String msg = "";
        String to_next_level = Config.readConfig("levelProgressCompletedColor");
        if (original_message.contains("{player_level_progress}")) {
            float progress = (1 - player.getExp()) * 100;
            float f = progress / 10;

            for (int i = 0; i < 10 - f; i++) {
                to_next_level += "|";
            }
            if (progress % 10 >= 5) {
                to_next_level += Config.readConfig("levelProgressHalfColor") + "|";
            }
            to_next_level += Config.readConfig("levelProgressUncompletedColor");
            for (int i = 0; i < f; i++) {
                to_next_level += "|";
            }
            to_next_level = to_next_level.substring(0, to_next_level.length() - 1);

            msg = to_next_level;
        }

        return original_message
                .replace("{player_level_progress}", msg)
                .replace("{player_deaths}", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replace("{player_mobs_killed}", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replace("{player_health}", String.valueOf(df.format(player.getHealth())))
                .replace("{player_level}", String.valueOf(player_level))
                .replace("{player_nickname}", player.getName())
                .replace("&", "§");
    }
}
