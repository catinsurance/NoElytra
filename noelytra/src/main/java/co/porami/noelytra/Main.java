package co.porami.noelytra;

import co.porami.Files.DataManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static DataManager data;
    public static boolean elytraEnabled;


    @Override
    public void onEnable() {
        data = new DataManager(this);
        if (data.getConfig().contains("elytraEnabled")) {
            elytraEnabled = this.data.getConfig().getBoolean("elytraEnabled");
        } else {
            elytraEnabled = false;
            data.getConfig().set("elytraEnabled", true);
            data.saveConfig();
        }
        System.out.println("Starting No Elytra...");
        getCommand("elytra").setExecutor(new ChatCommands());
        getCommand("elytra").setTabCompleter(new ChatTabCompletion());
        getServer().getPluginManager().registerEvents(new OnGlide(), this);
    }

    @Override
    public void onDisable() {
    }
}
