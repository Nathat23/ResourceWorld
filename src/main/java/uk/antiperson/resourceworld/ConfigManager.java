package uk.antiperson.resourceworld;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {

    private FileConfiguration fileConfiguration;
    private ResourceWorld rw;
    private File file;
    public ConfigManager(ResourceWorld rw){
        this.rw = rw;
    }

    public void startup(){
        rw.saveResource("config.yml", false);
        file = new File(rw.getDataFolder(), "config.yml");
        fileConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getConfig(){
        return fileConfiguration;
    }
}
