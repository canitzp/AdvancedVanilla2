# IMC Help
IMC is a easy Way to send things like variables to other Mods.

===============
###Thermal Expansion
##### Pulveriser:
You need a NBTTagCompound with int energy, ItemStack input, ItemStack firstOutput and maybe ItemStack secondOutput and int secondOutputChance
FMLInterModComms.sendMessage("advancedvanilla", "ThermalExpansionPulveriser", 'your NBTTagCompound here');