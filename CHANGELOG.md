# <img src="https://cdn.modrinth.com/data/cached_images/2de4b8628d72b2cdebcc8310ff7e69a542faed0c.png" width="60"> 8.0.0 Update

<details>  
<summary>🛠️ What's Fixed:</summary>

### Fyoncle:

- Fixed Eye Spy Advancement Failing if Lost Castle structure not found. (1.21.1)
- Fixed Ram Warning Screen can be closed with hitting ESC
- Replaced @Overwrite with @Inject in SplashTextRendererMixin, injecting then canceling execution for removing splashes now to fix crashes with other mods.
- Removed Edition text through @WrapOperation instead of overwriting the texture

### VipCoder:

- Fixed an issue where the mod fails to pin the resource pack to the top as intended.
- Fixed an issue with the update checker crashing the game if Modrinth is down
- Fixed MC-220390

</details>

<details>
<summary>✨ What's Changed:</summary>

- Added Translations For RAM Warning Screen:
  - English (en_us) by Fyoncle
  - Turkish (tr_tr) by Fyoncle
  - Spanish (es_es) by puffymaria
  - Catalan (ca_es) by puffymaria
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
- Redesigned the Ignore, Don't Show Again, and Open Guide Button!
- Added Quit Game Button on RAM Warning Screen
- Added End Remastered loot tables for Friends & Foes to add compat!
- Updated Recipes
  - Backported the official Saddle recipe
  - Rebalanced Rotten Flesh to Leather recipes and added normal furnace and smelting variants
  - Rebalanced the Horse Armor recipes completely
- Updated Christmas Panorama
- Updated the Wiki link for the RAM guide
- Change "Show Guide" text to "Open Guide"

</details>

<details>
<summary>⚙️ Other:</summary>

- Add a Wiki button in the main menu
- Fix a few wrong pixels on the focused Discord Button
- Nerf Bygone Nether's Wither Skeleton Horses through a mixin (VipCoder)
- Update License to [Fyoncle's Custom License](https://github.com/Fyoncle/ElysiumDaysTweaks/blob/1.20.1/LICENSE)
- Rewrote a part of the RAM Warning Screen to make it translatable
- Bump Version To 8.0.0
- Bump Loader Version
- Update Constants Wiki link
- Separated Spawn Animations Compat to another mod
- Separated Backported Wolves Compat to another mod
- Remove Iceologers from [Drodi's Illagers x Fresh Animations](https://modrinth.com/resourcepack/drodis-illagers-fresh-animation) resource pack
- Remove game menu logo from [Icons](https://modrinth.com/resourcepack/icons) with a 1x1 texture to remove it completely and reduce file size
- Rename `isVersionBigger` to `isVersionGreater`
- Rename `addModsButton` to `addButtons`
- Rename `elysiumdays` directory to `elysiumdaystweaks`
- Add dragon.jem to override the vanilla model and achieve resource pack compatibility on Elysium Days with AL' Boss Rush combined with Better Ender Dragon
- Add Fancy Menu as incompatible
- Remove Red Button (Replaced with DONT_SHOW_AGAIN_BUTTON)

</details>