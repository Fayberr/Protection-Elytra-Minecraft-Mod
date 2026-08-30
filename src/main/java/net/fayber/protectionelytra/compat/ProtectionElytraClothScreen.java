package net.fayber.protectionelytra.compat;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fayber.protectionelytra.config.ConfigManager;
import net.fayber.protectionelytra.config.ProtectionElytraConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public final class ProtectionElytraClothScreen {
    private ProtectionElytraClothScreen() {}

    public static Screen create(Screen parent) {
        ProtectionElytraConfig config = ConfigManager.get();
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Component.literal("Protection Elytra Settings"))
                .setSavingRunnable(ConfigManager::save);

        ConfigEntryBuilder eb = builder.entryBuilder();

        ConfigCategory general = builder.getOrCreateCategory(Component.literal("General"));

        general.addEntry(eb.startBooleanToggle(Component.literal("Master Toggle"), config.enabled)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Globally enable/disable the mod's anvil functionality."))
                .setSaveConsumer(val -> config.enabled = val)
                .build());

        ConfigCategory enchantments = builder.getOrCreateCategory(Component.literal("Allowed Enchantments"));

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Protection (General)"), config.allowProtection)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Allow regular Protection I-IV on Elytras."))
                .setSaveConsumer(val -> config.allowProtection = val)
                .build());

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Fire Protection"), config.allowFireProtection)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Allow Fire Protection I-IV on Elytras."))
                .setSaveConsumer(val -> config.allowFireProtection = val)
                .build());

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Blast Protection"), config.allowBlastProtection)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Allow Blast Protection I-IV on Elytras."))
                .setSaveConsumer(val -> config.allowBlastProtection = val)
                .build());

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Projectile Protection"), config.allowProjectileProtection)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Allow Projectile Protection I-IV on Elytras."))
                .setSaveConsumer(val -> config.allowProjectileProtection = val)
                .build());

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Thorns"), config.allowThorns)
                .setDefaultValue(true)
                .setTooltip(Component.literal("Allow Thorns I-III on Elytras."))
                .setSaveConsumer(val -> config.allowThorns = val)
                .build());

        enchantments.addEntry(eb.startBooleanToggle(Component.literal("Allow All Armor Enchantments"), config.allowAllArmorEnchantments)
                .setDefaultValue(false)
                .setTooltip(Component.literal("Allow any custom/modded chest armor enchantments on Elytras."))
                .setSaveConsumer(val -> config.allowAllArmorEnchantments = val)
                .build());

        return builder.build();
    }
}
