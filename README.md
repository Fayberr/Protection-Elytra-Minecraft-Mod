# Protection Elytra

Fabric mod for Minecraft **26.3**.

Lets you put Protection, Fire Protection, Blast Protection, Projectile Protection
and Thorns on an Elytra at an anvil. The enchantments work normally while the
Elytra is worn in the chest slot, so they count towards damage reduction like on
any chestplate.

## Installation

Needs Fabric Loader and Fabric API. Put the jar in the `mods` folder of a server,
or in your own `mods` folder for singleplayer. Players joining a server do not need
the mod installed.

## Configuration

Settings are stored in `config/protection_elytra.json`. Each of the five
enchantments can be switched off separately, and there is an option to allow every
armor enchantment on the Elytra. If Mod Menu is installed there is a settings
screen, built with Modern Config when that is installed and with Cloth Config
otherwise.

## Building

Needs JDK 25. Run `./gradlew build`. The Modern Config dependency is resolved from
`mavenLocal()`, so publish it first with `./gradlew publishToMavenLocal` in the
Modern Config repository.

## License

GPL-3.0-or-later.
