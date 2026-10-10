package net.fayber.protectionelytra.compat;

import net.fayber.modernconfig.api.ModernConfigScreen;
import net.fayber.protectionelytra.config.ConfigManager;
import net.fayber.protectionelytra.config.ProtectionElytraConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

/** Modern Config version of the settings screen. Only loaded when Modern Config is installed. */
public final class ProtectionElytraModernScreen {
    private ProtectionElytraModernScreen() {}

    public static Screen create(Screen parent) {
        ProtectionElytraConfig c = ConfigManager.get();
        return ModernConfigScreen.builder(Component.literal("Protection Elytra Settings"), parent, ConfigManager::save)

                .category("General")
                .bool("Master Toggle", () -> c.enabled, v -> c.enabled = v)
                .tooltip("Turns the anvil enchanting on or off.")

                .category("Allowed Enchantments")
                .bool("Protection", () -> c.allowProtection, v -> c.allowProtection = v)
                .tooltip("Allow Protection on Elytras.")
                .bool("Fire Protection", () -> c.allowFireProtection, v -> c.allowFireProtection = v)
                .tooltip("Allow Fire Protection on Elytras.")
                .bool("Blast Protection", () -> c.allowBlastProtection, v -> c.allowBlastProtection = v)
                .tooltip("Allow Blast Protection on Elytras.")
                .bool("Projectile Protection", () -> c.allowProjectileProtection, v -> c.allowProjectileProtection = v)
                .tooltip("Allow Projectile Protection on Elytras.")
                .bool("Thorns", () -> c.allowThorns, v -> c.allowThorns = v)
                .tooltip("Allow Thorns on Elytras.")
                .bool("Allow All Armor Enchantments", () -> c.allowAllArmorEnchantments, v -> c.allowAllArmorEnchantments = v)
                .tooltip("Also allow any other chest armor enchantment, including ones from other mods.")

                .build();
    }
}
