package canitzp.advancedvanilla.worldGen;


import canitzp.advancedvanilla.util.AVStrings;
import cpw.mods.fml.common.registry.VillagerRegistry;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class AASHHandler implements VillagerRegistry.IVillageCreationHandler{

    public static void init(){
        VillagerRegistry.instance().registerVillageCreationHandler(new AASHHandler());
        MapGenStructureIO.func_143031_a(ActuallyAdditionsSpecialHouse.class, AVStrings.texture + "jamHouseStructure");
    }
    @Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int i) {
        return new StructureVillagePieces.PieceWeight(ActuallyAdditionsSpecialHouse.class, 5, 1);
    }

    @Override
    public Class<?> getComponentClass() {
        return ActuallyAdditionsSpecialHouse.class;
    }

    @Override
    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) {
        return ActuallyAdditionsSpecialHouse.buildComponent(pieces, p1, p2, p3, p4);
    }
}
