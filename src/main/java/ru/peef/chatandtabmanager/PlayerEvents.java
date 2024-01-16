package ru.peef.chatandtabmanager;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import ru.peef.chatandtabmanager.utils.Config;
import ru.peef.chatandtabmanager.utils.Messages;

import java.util.List;

public class PlayerEvents implements Listener {
    Plugin plugin = ChatAndTabManagerBukkit.getPlugin(ChatAndTabManagerBukkit.class);
    boolean isGlobalEnabled;

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        if (event.getPlayer().isBanned()) {
            for (World world : plugin.getServer().getWorlds()) {
                for (Player player : world.getPlayers()) {
                    player.sendMessage(Messages.formatMessage(Config.readConfig("banFormat"), "Пример", player));
                }
            }
        } else {
            boolean hasJoinPermission = event.getPlayer().hasPermission("chatandtabmanager.leave_notify");
            boolean isChatClickable = Config.readConfigBoolean("isChatClickable");
            boolean isChatHover = Config.readConfigBoolean("isChatHover");
            boolean leaveNotify = Config.readConfigBoolean("leaveNotificationsEnabled");
            boolean leaveNotifyDefault = Config.readConfigBoolean("leaveNotificationsDefault");
            boolean leaveSoundEnabled = Config.readConfigBoolean("leaveSoundEnabled");
            String leaveSound = Config.readConfig("leaveSound");
            String leaveMessage = Config.readConfig("leaveMessage");

            if (!leaveNotifyDefault) {
                if (hasJoinPermission && leaveNotify && !isChatClickable && !isChatHover) {
                    event.setQuitMessage(Messages.formatMessage(leaveMessage, event.getPlayer()));
                }

                if (hasJoinPermission && leaveNotify && isChatClickable && !isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));
                    int clickableType = Config.readConfigInteger("clickableType");
                    if (clickableType == 1) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 2) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 3) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    }

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (hasJoinPermission && leaveNotify && isChatClickable && isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));
                    int clickableType = Config.readConfigInteger("clickableType");
                    if (clickableType == 1) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 2) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 3) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    }

                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (hasJoinPermission && leaveNotify && !isChatClickable && isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));

                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (!hasJoinPermission && leaveNotify) {
                    event.setQuitMessage("");
                }
            } else {
                if (leaveNotify && !isChatClickable && !isChatHover) {
                    event.setQuitMessage(Messages.formatMessage(leaveMessage, event.getPlayer()));
                }

                if (leaveNotify && isChatClickable && !isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));
                    int clickableType = Config.readConfigInteger("clickableType");
                    if (clickableType == 1) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 2) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 3) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    }

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (leaveNotify && isChatClickable && isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));
                    int clickableType = Config.readConfigInteger("clickableType");
                    if (clickableType == 1) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 2) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    } else if (clickableType == 3) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                    }

                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (leaveNotify && !isChatClickable && isChatHover) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(leaveMessage, event.getPlayer()));

                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                    Bukkit.spigot().broadcast(msg);
                    event.setQuitMessage("");
                }

                if (leaveNotify) {
                    event.setQuitMessage("");
                    if (leaveSoundEnabled) {
                        try {
                            List<World> worlds = plugin.getServer().getWorlds();
                            for (World world : worlds) {
                                List<Player> players = world.getPlayers();
                                for (Player currPlayer : players) {
                                    currPlayer.playSound(
                                            currPlayer.getLocation(),
                                            Sound.valueOf(leaveSound),
                                            1f,
                                            1f
                                    );
                                }
                            }
                        } catch (IllegalArgumentException exc) {
                            plugin.getLogger().info("Don't found sound " + leaveSound);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        boolean hasJoinPermission = event.getPlayer().hasPermission("chatandtabmanager.join_notify");
        boolean isChatClickable = Config.readConfigBoolean("isChatClickable");
        boolean isChatHover = Config.readConfigBoolean("isChatHover");
        boolean joinNotify = Config.readConfigBoolean("joinNotificationsEnabled");
        boolean joinNotifyDefault = Config.readConfigBoolean("joinNotificationsDefault");
        boolean joinSoundEnabled = Config.readConfigBoolean("joinSoundEnabled");
        String joinSound = Config.readConfig("joinSound");
        String joinMessage = Config.readConfig("joinMessage");

        if (!joinNotifyDefault) {
            if (hasJoinPermission && joinNotify && !isChatClickable && !isChatHover) {
                event.setJoinMessage(Messages.formatMessage(joinMessage, event.getPlayer()));
            }

            if (hasJoinPermission && joinNotify && isChatClickable && !isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));
                int clickableType = Config.readConfigInteger("clickableType");
                if (clickableType == 1) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 2) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 3) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                }

                Bukkit.spigot().broadcast(msg);
                event.setJoinMessage("");
            }

            if (hasJoinPermission && joinNotify && isChatClickable && isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));
                int clickableType = Config.readConfigInteger("clickableType");
                if (clickableType == 1) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 2) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 3) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                }

                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                Bukkit.spigot().broadcast(msg);
                event.setJoinMessage("");
            }

            if (hasJoinPermission && joinNotify && !isChatClickable && isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));

                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                Bukkit.spigot().broadcast(msg);
                event.setJoinMessage("");
            }

            if (!hasJoinPermission && joinNotify) {
                event.setJoinMessage("");
            }
        } else {
            if (joinNotify && !isChatClickable && !isChatHover) {
                event.setJoinMessage(Messages.formatMessage(joinMessage, event.getPlayer()));
            }

            if (joinNotify && isChatClickable && !isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));
                int clickableType = Config.readConfigInteger("clickableType");
                if (clickableType == 1) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 2) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 3) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                }

                Bukkit.spigot().broadcast(msg);
                event.setJoinMessage("");
            }

            if (joinNotify && isChatClickable && isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));
                int clickableType = Config.readConfigInteger("clickableType");
                if (clickableType == 1) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 2) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                } else if (clickableType == 3) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), event.getPlayer())));
                }

                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                Bukkit.spigot().broadcast(msg);
                event.setJoinMessage("");
            }

            if (joinNotify && !isChatClickable && isChatHover) {
                TextComponent msg = new TextComponent(Messages.formatMessage(joinMessage, event.getPlayer()));

                msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), event.getPlayer(), true)).create()));

                Bukkit.spigot().broadcast(msg);

                plugin.getLogger().info(Messages.formatMessage(joinMessage, event.getPlayer()));

                event.setJoinMessage("");
            }

            if (joinNotify) {
                event.setJoinMessage("");
                if (joinSoundEnabled) {
                    try {
                        List<World> worlds = plugin.getServer().getWorlds();
                        for (World world : worlds) {
                            List<Player> players = world.getPlayers();
                            for (Player currPlayer : players) {
                                currPlayer.playSound(
                                    currPlayer.getLocation(),
                                    Sound.valueOf(joinSound),
                                    1f,
                                    1f
                                );
                            }
                        }
                    } catch (IllegalArgumentException exc) {
                        plugin.getLogger().info("Don't found sound " + joinSound);
                    }
                }
            }
        }

        event.getPlayer().setPlayerListName(Messages.formatMessage(Config.readConfig("playerTabFormat"), event.getPlayer()));
    }

    // TODO: При упоминании ника производить звук (с поддержкой конфига)
    @EventHandler
    public void onChatMessage(AsyncPlayerChatEvent event) {
        boolean playerHear = false;
        isGlobalEnabled = Config.readConfigBoolean("isGlobalEnabled");
        String player_message = event.getMessage();
        Player player = event.getPlayer();

        player_message = player_message
                .replace("<3", ChatColor.RED + "❤")
                .replace(":))", ChatColor.GOLD + "(◕ ‿ ◕)つ")
                .replace("->", "→")
                .replace("<-", "←")
                .replace("o/", "(◠ ◡ ◠)╱");

        String prefix = Config.readConfig("globalPrefix");
        String message;
        event.setCancelled(true);
        boolean isChatClickable = Config.readConfigBoolean("isChatClickable");
        if (!isGlobalEnabled) {
            String format = Config.readConfig("chat");
            if (isChatClickable) {
                TextComponent msg = new TextComponent(Messages.formatMessage(format, player_message, player));
                int clickableType = Config.readConfigInteger("clickableType");
                if (clickableType == 1) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                } else if (clickableType == 2) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                } else if (clickableType == 3) {
                    msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                }

                if (Config.readConfigBoolean("isChatHover")) {
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), player, true)).create()));
                }

                Bukkit.spigot().broadcast(msg);
            } else {
                if (Config.readConfigBoolean("isChatHover")) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(format, player_message, player));

                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), player, true)).create()));

                    Bukkit.spigot().broadcast(msg);
                } else {
                    plugin.getServer().broadcastMessage(Messages.formatMessage(format, player_message, player));
                }
            }
        } else {
            if (player_message.startsWith(prefix)) {
                player_message = player_message.substring(prefix.length());
                if (Config.readConfigBoolean("isChatClickable")) {
                    TextComponent msg = new TextComponent(Messages.formatMessage(Config.readConfig("globalChat"), player_message, player));
                    int clickableType = Config.readConfigInteger("clickableType");
                    if (clickableType == 1) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                    } else if (clickableType == 2) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                    } else if (clickableType == 3) {
                        msg.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, Messages.formatMessage(Config.readConfig("clickableValue"), player)));
                    }

                    if (Config.readConfigBoolean("isChatHover")) {
                        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), player, true)).create()));
                    }

                    Bukkit.spigot().broadcast(msg);
                } else {
                    if (Config.readConfigBoolean("isChatHover")) {
                        TextComponent msg = new TextComponent(Messages.formatMessage(Config.readConfig("globalChat"), player_message, player));

                        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(Messages.formatMessage(Config.readConfig("hoverMessage"), player, true)).create()));

                        Bukkit.spigot().broadcast(msg);
                    } else {
                        plugin.getServer().broadcastMessage(Messages.formatMessage(Config.readConfig("globalChat"), player_message, player));
                    }
                }
            } else {
                String noOneHeard = Config.readConfig("ifNoOneHeardTheMessage");
                message = Messages.formatMessage(Config.readConfig("localChat"), player_message, player);

                World playerWorld = player.getWorld();
                List<Player> players = playerWorld.getPlayers();
                if (players.size() == 1) {
                    player.sendMessage(Messages.formatMessage(noOneHeard, player));
                } else {
                    int a = 0;
                    while (a != players.size()) {
                        Player currentPlayer = players.get(a);
                        if (currentPlayer != player) {
                            Location currentLoc = currentPlayer.getLocation();
                            int currentPlayerX = currentLoc.getBlockX();
                            int currentPlayerZ = currentLoc.getBlockZ();
                            // Message sender
                            Location playerLoc = player.getLocation();
                            int playerX = playerLoc.getBlockX();
                            int playerZ = playerLoc.getBlockZ();

                            int localRadius = Config.readConfigInteger("localRadius");

                            int curPlayerX_playerX = currentPlayerX - playerX;
                            int playerX_curPlayerX = playerX - currentPlayerX;
                            int curPlayerZ_playerZ = currentPlayerZ - playerZ;
                            int playerZ_curPlayerZ = playerZ - currentPlayerZ;

                            if ((curPlayerX_playerX <= localRadius && curPlayerX_playerX >= 0) ||
                                (playerX_curPlayerX <= localRadius && playerX_curPlayerX >= 0) ||
                                (curPlayerZ_playerZ <= localRadius && curPlayerZ_playerZ >= 0) ||
                                (playerZ_curPlayerZ <= localRadius && playerZ_curPlayerZ >= 0)) {
                                currentPlayer.sendMessage(Messages.formatMessage(message, player));
                                playerHear = true;
                            }
                        }
                        a++;
                    }
                    if (playerHear) {
                        player.sendMessage(Messages.formatMessage(message, player));
                    } else {
                        player.sendMessage(Messages.formatMessage(noOneHeard, player));
                    }
                }
            }
        }
    }

    @EventHandler
    public void onKick(PlayerKickEvent event) {
        for (World world : plugin.getServer().getWorlds()) {
            for (Player player : world.getPlayers()) {
                player.sendMessage(Messages.formatMessage(Config.readConfig("kickFormat"), event.getReason(), player));
            }
        }
    }
}
