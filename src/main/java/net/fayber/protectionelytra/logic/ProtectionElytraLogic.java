package net.fayber.protectionelytra.logic;

import net.fayber.protectionelytra.config.ConfigManager;
import net.fayber.protectionelytra.config.ProtectionElytraConfig;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class ProtectionElytraLogic {

    public static boolean canEnchantElytra(Enchantment enchantment) {
        ProtectionElytraConfig config = ConfigManager.get();
        if (!config.enabled || !enchantment.matchingSlot(EquipmentSlot.CHEST)) {
            return false;
        }

        // The translation key is language independent, unlike the rendered name.
        if (enchantment.description().getContents() instanceof TranslatableContents tc) {
            switch (tc.getKey()) {
                case "enchantment.minecraft.protection":
                    return config.allowProtection;
                case "enchantment.minecraft.fire_protection":
                    return config.allowFireProtection;
                case "enchantment.minecraft.blast_protection":
                    return config.allowBlastProtection;
                case "enchantment.minecraft.projectile_protection":
                    return config.allowProjectileProtection;
                case "enchantment.minecraft.thorns":
                    return config.allowThorns;
                default:
                    break;
            }
        }
        return config.allowAllArmorEnchantments;
    }
}
