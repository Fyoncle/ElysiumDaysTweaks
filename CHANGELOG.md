<div align="center">

<img src="https://cdn.modrinth.com/data/cached_images/d40adbf6cf2abc56c43341e893a47de9250ec4d8.png" width="70%">

# 8.0.0 Update

</div>

<details>
<summary>🛠️ Fixed</summary>

- Fixed the RAM Warning Screen being closeable with ESC
- Fixed a game freeze after clicking "Don't Show Again" on the RAM Warning Screen
- Fixed the custom app icon appearing blurry on some setups (notably with Windhawk or MyDockFinder)
- Fixed the app icon not showing on macOS
- Fixed Superb Steeds's issue [#9](https://github.com/MoriyaShiine/superb-steeds/issues/9)
- Fixed [[Let's Do] Bakery - Farm&Charm Compat](https://modrinth.com/mod/lets-do-bakery-farmcharm-compat) not working with modded knives
- Fixed the resource pack not being pinned to the top as intended *(by [Lancet-crow](https://github.com/Lancet-crow))*
- Fixed a few wrong pixels on the focused Discord button
- Fixed Enchantment Descriptions compatibility for Guarding
- Fixed the update checker crashing if Modrinth is down *(by VipCoder)*
- Fixed [MC-220390](https://bugs.mojang.com/browse/MC/issues/MC-220390) *(by VipCoder)*

</details>

<details>
<summary>✨ Added</summary>

- Added a Wiki button to the main menu
- Added a Quit Game button to the RAM Warning Screen
- Added a Switch Language button to the RAM Warning Screen
- Added Elysium Days version to the window title
- Added End Remastered loot tables for [Friends & Foes](https://modrinth.com/mod/friends-and-foes) compatibility
- Added prettier banners for [Modern World Creation](https://modrinth.com/mod/modern-world-creation)
- Added translations for the RAM Warning Screen:
  - English `en_us` by Fyoncle
  - Turkish `tr_tr` by Fyoncle
  - Spanish `es_es` by PuffyMaria
  - Catalan `ca_es` by PuffyMaria
  - Chilean Spanish `es_cl` by AstroLazuli
  - French `fr_fr` by weebinsomniaque
  - Russian `ru_ru` by shizotoaster
  - German `de_de` by JustDragonGirl
  - Swedish `sv_se` by Aprilamnm
  - Finnish `fi_fi` by Tofuzki
  - Hindi `hi_in` by Rox
  - Polish `pl_pl` by Bedwarsowiec
  - Arabic `ar_sa` by APZi
  - Japanese `ja_jp` by Historia
  - Indonesian `id_id` by Endertainer007
  - Dutch `nl_nl` by Jzody
  - Norwegian Bokmål `no_no` by Aprilamnm
  - Norwegian Nynorsk `nn_no` by Aprilamnm
  - Filipino `fil_ph` by Astronaut
  - Persian `fa_ir`
- Added tip for the [Armorable Skeleton Horses](https://modrinth.com/mod/armorable-skeleton-horses) mod
- Added tip for the [Tameable Foxes](https://modrinth.com/mod/tameable-foxes) mod
- Added Filipino translations for End Remastered Eye of Ender warning *(by Astronaut)*

</details>

<details>
<summary>🔧 Changed</summary>

- Rebranded to **Elysium Core**
- Redesigned the Elysium Days logo
- Replaced the config system with [FzzyConfig](https://modrinth.com/mod/fzzyconfig)
- Redesigned the Ignore, Don't Show Again, and Open Guide buttons
- Renamed "Show Guide" to "Open Guide"
- Nerfed Bygone Nether's Wither Skeleton Horses via mixin *(by VipCoder)*
- Made the Update Button and Neat Toggle translatable
- Rewrote part of the RAM Warning Screen to support translations
- Updated the RAM guide Wiki link
- Updated the Secret Story tip
- Improved tip wording for all tips
- Improved French translations for End Remastered *(by weebinsomniaque)*
- Improved Polish translations for End Remastered *(by vstankav)*
- Improved Catalan translations for End Remastered *(by PuffyMaria)*
- Changed a Phantasm translation line as an easter egg
- Changed "Health Bar" text to "Health Bars"
- Removed Iceologers from [Drodi's Illagers x Fresh Animations](https://modrinth.com/resourcepack/drodis-illagers-fresh-animation) for [Friends & Foes](https://modrinth.com/mod/friends-and-foes) compatibility

</details>

<details>
<summary>❌ Removed</summary>

- Removed all holiday-based logo and panorama variants due to the development burden it created
- Removed Sponge and Podzol recipes *(replaced by ED_Recipes datapack)*
- Removed Rotten Flesh to Leather recipe *(replaced with RME's Campfire Leather datapack)*
- Removed Lost Castle advancement compat *(fixed upstream)*
- Separated Spawn Animations compat to [its own datapack](https://modrinth.com/datapack/spawn-animations-compats)
- Separated Backported Wolves compat to [its own datapack](https://modrinth.com/datapack/backported-wolves-regions-unexplored-compat)
- Separated Icons compat to [its own resource pack](https://modrinth.com/resourcepack/icons-compats)
- Separated Horse Armor & Saddle recipes to [its own datapack](https://modrinth.com/datapack/bhar)
- Separated Tips compat to [its own datapack](https://modrinth.com/datapack/tips-compats)

</details>

<details>
<summary>⚙️ Internal</summary>

- Changed `MOD_ID` from `elysium-days-tweaks` to `elysiumcore`
- Renamed `isVersionBigger` to `isVersionGreater`
- Renamed `addModsButton` to `addButtons`
- Replaced `@Overwrite` with `@Inject` in `SplashTextRendererMixin`
- Replaced Edition text removal with `@WrapOperation` instead of overwriting the texture
- Separated Authors and Contributors in `fabric.mod.json`
- Added Lancet_ and VixelCreates as contributors in `fabric.mod.json`
- Added `dragon.jem` to override the vanilla model of the dragon for compatibility between [AL' Boss Rush](https://modrinth.com/resourcepack/als-boss-rush-x-fresh-animations) and [Ender Dragon Revamp](https://www.curseforge.com/minecraft/texture-packs/ender-dragon-revamp)
- Renamed all directories to Elysium Core
- Hid some recipes from EMI
- Bumped version to 8.0.0
- Marked [Fancy Menu](https://modrinth.com/mod/fancymenu) as incompatible

</details>

---

<div align="center">

<img src="https://raw.githubusercontent.com/Mqxx/GitHub-Markdown/1fd12c475756b54e467799d98eca7b406f109341/blockquotes/badge/dark-theme/info.svg" width="100">

Due to the size of this release, some changes may be undocumented.

</div>