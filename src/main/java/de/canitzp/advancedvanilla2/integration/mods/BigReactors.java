package de.canitzp.advancedvanilla2.integration.mods;

import de.canitzp.advancedvanilla2.integration.CheckLoadedMods;
import de.canitzp.advancedvanilla2.util.AVOreDictionary;

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
