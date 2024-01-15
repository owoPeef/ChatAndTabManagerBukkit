package ru.peef.chatandtabmanager;

import org.bukkit.plugin.java.JavaPlugin;
import ru.peef.chatandtabmanager.utils.Config;

import java.util.Map;
import java.util.Objects;

public final class ChatAndTabManagerBukkit extends JavaPlugin {

    @Override
    public void onEnable() {
        enablePlugin();
    }

    public void enablePlugin() {
        Config.loadConfig();
        getServer().getPluginManager().registerEvents(new PlayerEvents(), this);

        for (Map.Entry<String, Map<String, Object>> cmd : getDescription().getCommands().entrySet()) {
            String command = cmd.getKey();
            try {
                Objects.requireNonNull(getCommand(command)).setExecutor(new Commands());
                this.getLogger().info("Command \"" + command + "\" init success");
            } catch (Exception exc) {
                this.getLogger().warning("Command \"" + command + "\" don't init. ("+exc.getMessage()+")");
            }
        }
    }
}
