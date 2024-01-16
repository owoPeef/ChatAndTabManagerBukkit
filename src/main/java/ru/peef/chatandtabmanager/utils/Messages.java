package ru.peef.chatandtabmanager.utils;

import org.bukkit.Statistic;
import org.bukkit.entity.Player;

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
        return original_message.replace("{player_message}", message)
                .replace("{player_deaths}", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replace("{player_mobs_killed}", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replace("{player_health}", String.valueOf(player.getHealth()))
                .replace("{player_level}", String.valueOf(player.getLevel()))
                .replace("{player_nickname}", player.getName())
                .replace("&", "§");
    }

    public static String formatMessage(String original_message, Player player, boolean NeedExtension) {
        return original_message
                .replace("{player_deaths}", String.valueOf(player.getStatistic(Statistic.DEATHS)))
                .replace("{player_mobs_killed}", String.valueOf(player.getStatistic(Statistic.MOB_KILLS)))
                .replace("{player_health}", String.valueOf(player.getHealth()))
                .replace("{player_level}", String.valueOf(player.getLevel()))
                .replace("{player_nickname}", player.getName())
                .replace("&", "§");
    }
}
