<div align="center">

<img src="https://cdn.modrinth.com/data/cached_images/d40adbf6cf2abc56c43341e893a47de9250ec4d8.png" width="70%">

#

</div>

<details>  
<summary>🛠️ What's Fixed</summary>

### Fyoncle:

- Redesigned the ED Logo
- Fixed RAM Warning Screen can be closed with hitting ESC
- Fixed game freezing for a split second after clicking Don't Show Again on the RAM Warning Screen
- Replaced @Overwrite with @Inject in SplashTextRendererMixin, injecting then canceling execution for removing splashes
  now to fix crashes with other mods.
- Abandon the config system of Elysium Core and implement FzzyConfig
- Removed all the holiday-based logo & panorama variants
- The custom icon being blurry on some setups or distros, specially was seen on Windows when icon scale was manipulated with Windhawk or MyDockFinder
- Fixed the icon not showing up on MacOS

### VipCoder:

- Fixed an issue with the update checker crashing the game if Modrinth is down
- Fixed MC-220390

</details>

<details>
<summary>✨ What's Changed</summary>

- Rebranded to Elysium Core
- Added Translations For RAM Warning Screen:
    - English (en_us) by Fyoncle
    - Turkish (tr_tr) by Fyoncle
    - Spanish (es_es) by PuffyMaria
    - Catalan (ca_es) by PuffyMaria
    - Chilean Spanish (es_cl) by AstroLazuli
    - French (fr_fr) by weebinsomniaque
    - Russian (ru_ru) by shizotoaster
    - German (de_de) by JustDragonGirl
    - Swedish (sv_se) by Aprilamnm
    - Finnish (fi_fi) by Tofuzki
    - Hindi (hi_in) by Rox
    - Polish (pl_pl) by Bedwarsowiec
    - Arabic (ar_sa) by APZi
    - Japanese (ja_jp) by Historia
    - Indonesian (id_id) by Endertainer007
    - Dutch (nl_nl) by Jzody
    - Norwegian Bokmål (no_no) by Aprilamnm
    - Norwegian Nynorsk (nn_no) by Aprilamnm
    - Filipino (fil_ph) by Astronaut
    - Persian (fa_ir)
- Updated End Remastered Eye Translations
    - Add Filipino Translations (fil_ph) (Thanks to Astronaut)
    - Improved French Translations (Thanks to weebinsomniaque! <3)
    - Improved Polish Translations (Thanks to vstankav! <3)
    - Improved Catalan Translations (Thanks to PuffyMaria! <3)
- Tips Compat:
    - Added tip for the Saddle recipe and Horse Armor recipes
    - Added tip for [Armorable Skeleton Horses](https://modrinth.com/mod/armorable-skeleton-horses) mod!
    - Added tip for [Tameable Foxes](https://modrinth.com/mod/tameable-foxes) mod!
    - Improved wording of the Tips
    - Updated Secret Story Tip
    - Rename Podzol and Sponge Tip
- Added a Wiki button in the main menu
- Redesigned the Ignore, Don't Show Again, and Open Guide Button!
- Added Quit Game Button on RAM Warning Screen
- Added End Remastered loot tables for Friends & Foes to add compat!
- Updated Recipes
    - Backported the official Saddle recipe
    - Rebalanced Rotten Flesh to Leather recipes and added normal furnace and smelting variants
    - Rebalanced the Horse Armor recipes completely
- Updated the Wiki link for the RAM guide
- Change "Show Guide" text to "Open Guide"

</details>

<details>
<summary>⚙️ Other</summary>

- Fixed Superb Steeds's issue [#9](https://github.com/MoriyaShiine/superb-steeds/issues/9)
- Fixed [[Let's Do] Bakery - Farm&Charm Compat](https://modrinth.com/mod/lets-do-bakery-farmcharm-compat) not working
  with modded knives
- Fixed an issue where the mod fails to pin the resource pack to the top as intended. (Pull Requested
  by [Lancet-crow](https://github.com/Lancet-crow))
- Changed MOD_ID from `elysium-days-tweaks` to `elysiumcore`
- Removed Edition text through @WrapOperation instead of overwriting the texture
- Fix a few wrong pixels on the focused Discord Button
- Separate Authors and Contributors in the fabric.mod.json
- Add VixelCreates and Lancet_ in the contributors on fabric.mod.json
- Nerf Bygone Nether's Wither Skeleton Horses through a mixin (VipCoder)
- Rewrote a part of the RAM Warning Screen to make it translatable
- Made Update Button and Neat Toggle translatable
- Add Elysium Days version to the window title
- Bump Version To 8.0.0
- Bump Loader Version
- Update Constants Wiki link
- Separated Spawn Animations Compat to its own datapack on Modrinth
- Separated Backported Wolves Compat to its own datapack on Modrinth
- Separated Icons Compat to its own resource pack on Modrinth
- Separated Horse Armor & Saddle Recipes with Simple Netherite Horse Armor to its own datapack on Modrinth
- Remove Iceologers
  from [Drodi's Illagers x Fresh Animations](https://modrinth.com/resourcepack/drodis-illagers-fresh-animation) resource
  pack
- Remove game menu logo from [Icons](https://modrinth.com/resourcepack/icons) with a 1x1 texture to remove it completely
  and reduce file size
- Rename `isVersionBigger` to `isVersionGreater`
- Rename `addModsButton` to `addButtons`
- Add dragon.jem to override the vanilla model and achieve resource pack compatibility on Elysium Days with AL' Boss
  Rush combined with Better Ender Dragon
- Add Fancy Menu as incompatible
- Remove Red Button (Replaced with DONT_SHOW_AGAIN_BUTTON)
- Added an icon.png in the .idea directory to display EDT logo on the IDE
- Renamed every directory to be Elysium Core
- Remove MoreMcmeta's internal pack from the Resource Pack Lock feature
- Removed Sponge and Podzol recipe since they felt out of place, vanilla ways making them actually unique to get at
  least
- Removed the lang files for Icons to remove food tooltips as Icons Compats now handles this
- Removed files that removes Icons advertisement logo since Icons 1.12 already removed it
- Remove Rotten Flesh to Leather recipes (Replaced with another mod in Elysium Days)
- Removed Lost Castle Advancement compat since they fixed it by default
- Change Health Bar text to Health Bars
- Change a translation line of Phantasm to add an Easter egg
- Fix Enchantment Descriptions compatibility of Guarding
- Removing some recipes from EMI
- Added prettier banners for [Modern World Creation](https://modrinth.com/mod/modern-world-creation)

</details>

---

<img src="https://raw.githubusercontent.com/Mqxx/GitHub-Markdown/1fd12c475756b54e467799d98eca7b406f109341/blockquotes/badge/dark-theme/info.svg" width="100">

Due to the size of this release many changes are undocumented such as the fixes, or changes.
