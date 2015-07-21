# IMC Help
IMC is a easy Way to send things like variables to other Mods.

You can send things with an NBTTagCompound
You only have to set variables like Integers or ItemStacks to the NBTTagCompound
FMLInterModComms.sendMessage("advancedvanilla", 'The special String', 'your NBTTagCompound here');

===============
###Thermal Expansion
##### Pulveriser:
int energy, ItemStack input, ItemStack firstOutput and maybe ItemStack secondOutput, int secondOutputChance
Special String: "ThermalExpansionPulveriser"