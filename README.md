<p align="center"><a  href="https://modrinth.com/plugin/qtownybiomeblacklist"><img alt="Modrinth Download Link" src="https://img.shields.io/badge/Download-00AF5C?logo=modrinth&logoColor=white&style=for-the-badge" height="32"></a> <a href="https://www.quartzdev.gg/discord/"><img alt="Discord Invite" src="https://img.shields.io/badge/Discord-5865F2?logo=discord&logoColor=white&style=for-the-badge" height="32"></a> <a href="https://github.com/QarthO/qTownyBiomeBlacklist"><img alt="GitHub Source Code" src="https://img.shields.io/badge/Source-181717?logo=github&logoColor=white&style=for-the-badge" height="32"></a> <a href="https://paypal.me/qartho/"><img alt="PayPal Donation Link" src="https://img.shields.io/badge/Donate-00457C?logo=paypal&logoColor=white&style=for-the-badge" height="32"></a> <a href="https://modrinth.com/plugin/qTownyBiomeBlacklist/versions"><img alt="Supported Versions: 1.20.2" src="https://img.shields.io/badge/1.20.2-blue?style=for-the-badge&label=Minecraft Versions" height="32"></a></p>

---
### A [TownyAdvanced](https://github.com/TownyAdvanced/Towny) addon where you can blacklist claiming in specific biomes
---
<h3> Tested Versions </h3>
<p>Minecraft: v1.20.2</p>
<p>Towny: <a href="https://github.com/TownyAdvanced/Towny/releases/tag/0.100.0.0">v0.100.0.0</a>-<a href="https://github.com/TownyAdvanced/Towny/releases/tag/0.100.0.4">v0.100.0.4</a></p>
<p>Servers: <a href="https://papermc.io">Paper</a>, <a href="https://pufferfish.host/downloads">Pufferfish</a>, <a href="https://purpurmc.org">Purpur</a> or any other <u>stable</u> paper fork. </p>
<blockquote>Spigot or modded hybrids will most <i>*likely*</i> work, but will recieve no support. If you're still using spigot, it is <b>HIGHLY</b> recommend you upgrade to Paper</blockquote>

---

### Config
The full biome list can be found <a href="https://jd.papermc.io/paper/1.20/org/bukkit/block/Biome.html">here</a>.

```yaml
#######################################################################
# +-----------------------------------------------------------------+ #
# |                   qTownyBiomeBlacklist Config                   | #
# |   Source:   https://github.com/QarthO/qTownyBiomeBlacklist      | #
# |   Download: https://modrinth.com/plugin/qTownyBiomeBlacklist/   | #
# |   Donate:   https://paypal.me/qartho                            | #
# +-----------------------------------------------------------------+ #
#######################################################################

# The message that's sent to the player after attempting to claim in a blacklisted biome
# - Uses towny to send the message, so its already has the [Towny] prefix
deny-message: "You're not allowed to claim land in <biome>"

# Biome list can be found here: https://jd.papermc.io/paper/1.20/org/bukkit/block/Biome.html
# This example prevents claiming in any ocean biome
blacklisted-biomes:
  - COLD_OCEAN
  - DEEP_COLD_OCEAN
  - DEEP_FROZEN_OCEAN
  - DEEP_LUKEWARM_OCEAN
  - DEEP_OCEAN
  - FROZEN_OCEAN
  - LUKEWARM_OCEAN
  - OCEAN
  - WARM_OCEAN

```

---

This plugin uses [bStats](https://bstats.org/). You can opt-out in the bStats config
<p align="center">
<a href="https://bstats.org/plugin/bukkit/qTownyBiomeBlacklist/"><img alt="bStats qSpleef" src="https://bstats.org/signatures/bukkit/qTownyBiomeBlacklist.svg"></a></p>
