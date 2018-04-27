package uk.antiperson.resourceworld;

import org.bukkit.plugin.java.JavaPlugin;

public class ResourceWorld extends JavaPlugin{

    public ConfigManager configManager = new ConfigManager(this);

    @Override
    public void onEnable(){
        getLogger().info("ResourceWorld v" + getDescription().getVersion() + " by antiPerson");
        getLogger().info("Created especially for MediMinecraft.");

        configManager.startup();

        getLogger().info("Registering events, tasks and commands...");
        registerEvents();
    }

    @Override
    public void onDisable(){
        getServer().getScheduler().cancelTasks(this);
    }

    public void registerEvents(){
        // register events
        getServer().getPluginManager().registerEvents(new BlockEvents(this), this);
    }
}
