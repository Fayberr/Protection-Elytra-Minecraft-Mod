# Protection Elytra Mod Specification & Architecture

## Overview
**Protection Elytra** is a lightweight, server-side Fabric mod for Minecraft 26.1.x and 26.2 that allows players to enchant Elytras with Protection (and other armor protection enchantments) using an Anvil.

---

## 1. Core Requirements

1. **Server-Side Only / Vanilla Client Compatible (`"environment": "*"`):**
   * Operates entirely server-side (on dedicated servers or singleplayer integrated servers).
   * **No client mod required**: Vanilla Minecraft clients connecting to a server running this mod can combine an Elytra with Protection books on an anvil and receive the protection benefits.
2. **Anvil Enchanting & Vanilla Balance:**
   * Allows enchanting Elytra with:
     * **Protection I - IV**
     * **Fire Protection I - IV**
     * **Blast Protection I - IV**
     * **Projectile Protection I - IV**
     * **Thorns I - III**
   * Preserves standard vanilla anvil mechanics (experience costs, repair costs, level combining, and mutual exclusion between different protection types).
3. **Damage Protection:**
   * When worn in the chest armor slot (`EquipmentSlot.CHEST`), vanilla's `EnchantmentHelper.getDamageProtection` automatically calculates and applies the damage reduction from the Elytra's Protection enchantment.
4. **Configurability:**
   * Config file `config/protection_elytra.json`:
     * Toggle individual enchantment types (`allowProtection`, `allowFireProtection`, `allowBlastProtection`, `allowProjectileProtection`, `allowThorns`).
     * `allowAllArmorEnchantments` toggle for modded armor enchantments.

---

## 2. Technical Architecture

### Package Structure (`net.fayber.protectionelytra`)

```
net.fayber.protectionelytra
├── ProtectionElytraMod.java          # ModInitializer entrypoint
├── config/
│   ├── ProtectionElytraConfig.java   # Config data model
│   └── ConfigManager.java            # JSON persistence
├── logic/
│   └── ProtectionElytraLogic.java    # Checks enchantment compatibility for Elytra
└── mixin/
    └── EnchantmentMixin.java         # Hooks Enchantment.canEnchant(ItemStack) for Elytra
```

### Data Tags
* `data/minecraft/tags/item/enchantable/chest_armor.json`: Adds `minecraft:elytra`
* `data/minecraft/tags/item/enchantable/armor.json`: Adds `minecraft:elytra`
* `data/minecraft/tags/item/enchantable/equippable.json`: Adds `minecraft:elytra`

---

## 3. Build & Compatibility

* **Target MC Versions**: `26.1.x-fabric` and `26.2-fabric`
* **Java Target**: Java 25 (`options.release = 25`)
* **Loom**: `1.17.19` (unobfuscated 26.x Mojang mappings, no refmap)
* **License**: GPL-3.0-or-later, Copyright 2026 Fayber.
