package net.fayber.protectionelytra;

import net.fabricmc.api.ModInitializer;
import net.fayber.protectionelytra.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProtectionElytraMod implements ModInitializer {
    public static final String MOD_ID = "protection_elytra";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ConfigManager.load();
        LOGGER.info("Protection Elytra initialized. Server-side protection enchanting active.");
    }
}
