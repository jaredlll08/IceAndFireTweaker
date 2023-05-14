/*
    Adds three recipes to the Fire Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs Red Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

<recipetype:iceandfire:dragonforge>.addFireRecipe("fire_recipe_test_1", <item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>, 200);
<recipetype:iceandfire:dragonforge>.addRecipe("fire_recipe_test_2", "fire", <item:minecraft:red_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>, 200);
<recipetype:iceandfire:dragonforge>.addFireRecipe("fire_recipe_test_3", <item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>, 200);

/*
    Adds two recipes to the Ice Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs White Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

<recipetype:iceandfire:dragonforge>.addIceRecipe("ice_recipe_test_1", <item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>, 200);
<recipetype:iceandfire:dragonforge>.addRecipe("ice_recipe_test_2", "ice", <item:minecraft:white_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>, 200);
<recipetype:iceandfire:dragonforge>.addIceRecipe("ice_recipe_test_3", <item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>, 200);

/*
    Adds two recipes to the Ice Dragon Forge.
    The first recipe outputs Dirt when a Stick is used as an input and a Diamond is used as blood.
    The second recipe outputs Blue Wool when Glowstone is used as an input and Glass is used as blood.
    The third recipe outputs a Diamond when Red Wool is used as an input and Blue Wool is used as blood.

    The second and third recipes will be removed by a line lower down in the script!
*/

<recipetype:iceandfire:dragonforge>.addLightningRecipe("lightning_recipe_test_1", <item:minecraft:dirt>, <item:minecraft:stick>, <item:minecraft:diamond>, 200);
<recipetype:iceandfire:dragonforge>.addRecipe("lightning_recipe_test_2", "lightning", <item:minecraft:blue_wool>, <item:minecraft:glowstone>, <item:minecraft:glass>, 200);
<recipetype:iceandfire:dragonforge>.addLightningRecipe("lightning_recipe_test_3", <item:minecraft:diamond>, <item:minecraft:red_wool>, <item:minecraft:blue_wool>, 200);

/*
    Removes the Fire Dragon Forge recipe that outputs Fire Dragonsteel Ingots.
    Removes the Fire Dragon Forge recipe that outputs a Diamond.
*/

<recipetype:iceandfire:dragonforge>.removeFireRecipe(<item:iceandfire:dragonsteel_fire_ingot>);
<recipetype:iceandfire:dragonforge>.removeRecipe("fire", <item:minecraft:red_wool>);

/*
    Removes the Ice Dragon Forge recipe that outputs Ice Dragonsteel Ingots.
    Removes the Ice Dragon Forge recipe that outputs a Diamond.
*/

<recipetype:iceandfire:dragonforge>.removeIceRecipe(<item:iceandfire:dragonsteel_ice_ingot>);
<recipetype:iceandfire:dragonforge>.removeRecipe("ice", <item:minecraft:white_wool>);

/*
    Removes the Lightning Dragon Forge recipe that outputs Lightning Dragonsteel Ingots.
    Removes the Lightning Dragon Forge recipe that outputs a Diamond.
*/

<recipetype:iceandfire:dragonforge>.removeLightningRecipe(<item:iceandfire:dragonsteel_lightning_ingot>);
<recipetype:iceandfire:dragonforge>.removeRecipe("lightning", <item:minecraft:blue_wool>);

/*
    Removes all Dragon Forge recipes that output a Diamond.
*/

<recipetype:iceandfire:dragonforge>.removeRecipe(<item:minecraft:diamond>);