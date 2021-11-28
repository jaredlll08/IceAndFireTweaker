/*
    Adds three recipes to the Fire Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs Red Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

mods.iceandfire.DragonForge.addFireRecipe(<item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>);
mods.iceandfire.DragonForge.addRecipe("fire", <item:minecraft:red_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>);
mods.iceandfire.DragonForge.addFireRecipe(<item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>);

/*
    Adds two recipes to the Ice Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs White Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

mods.iceandfire.DragonForge.addIceRecipe(<item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>);
mods.iceandfire.DragonForge.addRecipe("ice", <item:minecraft:white_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>);
mods.iceandfire.DragonForge.addIceRecipe(<item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>);

/*
    Adds two recipes to the Lightning Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs Blue Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

mods.iceandfire.DragonForge.addLightningRecipe(<item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>);
mods.iceandfire.DragonForge.addRecipe("lightning", <item:minecraft:blue_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>);
mods.iceandfire.DragonForge.addLightningRecipe(<item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>);

/*
    Removes the Fire Dragon Forge recipe that outputs Fire Dragonsteel Ingots.
    Removes the Fire Dragon Forge recipe that outputs a Diamond.
*/

mods.iceandfire.DragonForge.removeFireRecipe(<item:iceandfire:dragonsteel_fire_ingot>);
mods.iceandfire.DragonForge.removeRecipe("fire", <item:minecraft:red_wool>);

/*
    Removes the Ice Dragon Forge recipe that outputs Ice Dragonsteel Ingots.
    Removes the Ice Dragon Forge recipe that outputs a Diamond.
*/

mods.iceandfire.DragonForge.removeIceRecipe(<item:iceandfire:dragonsteel_ice_ingot>);
mods.iceandfire.DragonForge.removeRecipe("ice", <item:minecraft:white_wool>);

/*
    Removes the Lightning Dragon Forge recipe that outputs Lightning Dragonsteel Ingots.
    Removes the Lightning Dragon Forge recipe that outputs a Diamond.
*/

mods.iceandfire.DragonForge.removeLightningRecipe(<item:iceandfire:dragonsteel_lightning_ingot>);
mods.iceandfire.DragonForge.removeRecipe("lightning", <item:minecraft:blue_wool>);

/*
    Removes all Dragon Forge recipes that output a Diamond.
*/

mods.iceandfire.DragonForge.removeRecipe(<item:minecraft:diamond>);
