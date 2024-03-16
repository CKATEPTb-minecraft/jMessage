package dev.ckateptb.minecraft.jmessage.serializer;

import dev.ckateptb.minecraft.jyraf.component.serialier.ComponentSerializer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniMessageComponentSerializer implements ComponentSerializer {
    private final MiniMessage miniMessage = MiniMessage.get();
    @Override
    public Component deserialize(String string) {
        Component component = this.miniMessage.deserialize(string);
        if (!string.contains("<italic")) {
            return component.decoration(TextDecoration.ITALIC, false);
        }
        return component;
    }

    @Override
    public String serialize(Component component) {
        return this.miniMessage.serialize(component);
    }
}
