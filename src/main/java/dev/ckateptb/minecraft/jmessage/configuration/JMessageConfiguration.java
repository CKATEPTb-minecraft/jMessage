package dev.ckateptb.minecraft.jmessage.configuration;

import dev.ckateptb.minecraft.jmessage.JMessage;
import dev.ckateptb.minecraft.jmessage.serializer.MiniMessageComponentSerializer;
import dev.ckateptb.minecraft.jyraf.component.serialier.ComponentSerializer;
import dev.ckateptb.minecraft.jyraf.component.serialier.inkymessage.InkyComponentSerializer;
import dev.ckateptb.minecraft.jyraf.component.serialier.minedown.MineDownComponentSerializer;
import dev.ckateptb.minecraft.jyraf.config.hocon.HoconConfig;
import dev.ckateptb.minecraft.jyraf.internal.configurate.objectmapping.meta.Comment;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.util.function.Supplier;

@Getter
public class JMessageConfiguration extends HoconConfig {
    @Comment("Allowed options: INKYMESSAGE, MINEDOWN, MINIMESSAGE")
    private Serializer serializer = Runtime.version().version().get(0) < 17 ? Serializer.MINIMESSAGE : Serializer.INKYMESSAGE;

    public File getFile() {
        return JMessage.getPlugin().getDataFolder().toPath().resolve("config.conf").toFile();
    }

    @RequiredArgsConstructor(access = AccessLevel.PACKAGE)
    public enum Serializer {
        INKYMESSAGE(InkyComponentSerializer::new),
        MINEDOWN(MineDownComponentSerializer::new),
        MINIMESSAGE(MiniMessageComponentSerializer::new);
        private final Supplier<ComponentSerializer> supplier;

        public ComponentSerializer get() {
            return this.supplier.get();
        }
    }

}
