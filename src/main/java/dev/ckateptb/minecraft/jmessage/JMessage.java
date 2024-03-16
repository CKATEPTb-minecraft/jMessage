package dev.ckateptb.minecraft.jmessage;

import dev.ckateptb.minecraft.jmessage.configuration.JMessageConfiguration;
import dev.ckateptb.minecraft.jyraf.component.Text;
import dev.ckateptb.minecraft.jyraf.internal.configurate.ConfigurateException;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class JMessage extends JavaPlugin {
    @Getter
    private static JMessage plugin;

    public JMessage() throws ConfigurateException {
        JMessage.plugin = this;
        JMessageConfiguration configuration = new JMessageConfiguration();
        configuration.initialize();
        configuration.load();
        configuration.save();
        Text.setGlobalComponentSerializer(configuration.getSerializer().get());
    }
}