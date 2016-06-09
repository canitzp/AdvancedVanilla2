package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.IMod;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

/**
 * @author canitzp
 */
public class VanillaNetherMetals implements IMod{ //Version: 1.0

    public void postInit(){
        AVOreDictionary.AVODBlock("oreNetherIron", "vanillanethermetals:nether_iron_ore");
        AVOreDictionary.AVODBlock("oreNetherGold", "vanillanethermetals:nether_gold_ore");
        AVOreDictionary.AVODBlock("oreNetherLapis", "vanillanethermetals:nether_lapis_ore");
        AVOreDictionary.AVODBlock("oreNetherDiamond", "vanillanethermetals:nether_diamond_ore");
        AVOreDictionary.AVODBlock("oreNetherRedstone", "vanillanethermetals:nether_redstone_ore");
        AVOreDictionary.AVODBlock("oreNetherCoal", "vanillanethermetals:nether_coal_ore");
    }

}
