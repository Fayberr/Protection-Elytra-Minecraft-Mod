package net.fayber.protectionelytra.logic;

import net.fayber.protectionelytra.config.ConfigManager;
import net.fayber.protectionelytra.config.ProtectionElytraConfig;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

public class ProtectionElytraLogic {

    public static boolean canEnchantElytra(Enchantment enchantment) {
        ProtectionElytraConfig config = ConfigManager.get();
        if (!config.enabled) {
            return false;
        }

        // If the enchantment matches chest armor slot
        if (enchantment.matchingSlot(EquipmentSlot.CHEST)) {
            String desc = enchantment.description().getString().toLowerCase();

            if (desc.contains("protection") || desc.contains("schutz")) {
                if (desc.contains("fire") || desc.contains("feuer")) {
                    return config.allowFireProtection;
                }
                if (desc.contains("blast") || desc.contains("explosions")) {
                    return config.allowBlastProtection;
                }
                if (desc.contains("projectile") || desc.contains("schuss")) {
                    return config.allowProjectileProtection;
                }
                return config.allowProtection;
            }

            if (desc.contains("thorns") || desc.contains("dornen")) {
                return config.allowThorns;
            }

            if (config.allowAllArmorEnchantments) {
                return true;
            }
        }

        return false;
    }
}
