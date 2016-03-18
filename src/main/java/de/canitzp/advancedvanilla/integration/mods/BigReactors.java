package de.canitzp.advancedvanilla.integration.mods;

import de.canitzp.advancedvanilla.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla.util.AVOreDictionary;

/**
 * @author canitzp
 */
@SuppressWarnings("unchecked")
public class BigReactors{

    public static void postInit(){
        CheckLoadedMods.modList.add("BigReactors");

        AVOreDictionary.AVODBlock("oreUranium", "BigReactors:YelloriteOre");
        AVOreDictionary.AVODItem("bucketCyanite", "BigReactors:bucketCyanite");
        AVOreDictionary.AVODItem("bucketYellorium", "BigReactors:bucketYellorium");
        AVOreDictionary.AVODItem("bucketUranium", "BigReactors:bucketYellorium");
        AVOreDictionary.WildcardBlock("hardenedGlass", "BigReactors:BRMultiblockGlass");

    }

}
