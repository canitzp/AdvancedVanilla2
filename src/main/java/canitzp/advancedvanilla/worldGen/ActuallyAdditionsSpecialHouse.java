package canitzp.advancedvanilla.worldGen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.Random;

public class ActuallyAdditionsSpecialHouse extends StructureVillagePieces.House1{

    private static final int xSize = 13;
    private static final int ySize = 7;
    private static final int zSize = 5;
    private int averageGroundLevel = 0;


    public ActuallyAdditionsSpecialHouse() {}

    public ActuallyAdditionsSpecialHouse(StructureBoundingBox sbb, int coord)
    {
        this.coordBaseMode = coord;
        this.boundingBox = sbb;
    }


    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes
     * Mineshafts at the end, it adds Fences...
     */
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb)
    {
        if(this.averageGroundLevel < 0){
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if(this.averageGroundLevel < 0) return true;
            this.boundingBox.offset(0, this.averageGroundLevel-this.boundingBox.maxY+ySize-1, 0);
        }

        this.fillWithBlocks(world, sbb, 0, 0, 0, xSize - 1, ySize - 1, zSize - 1, Blocks.air);

        //Layer1:
        this.fillWithMetadataBlocks(world, sbb, 0, 0, 0, 0, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), this.getMetadataWithOffset(Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 3), Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), this.getMetadataWithOffset(Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 3), false);
        this.fillWithBlocks(world, sbb, 1, 0, 0, 4, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 5, 0, 0, 5, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 6, 0, 0, 7, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 8, 0, 0, 8, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 9, 0, 0, 12, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 13, 0, 0, 13, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));

        this.fillWithBlocks(world, sbb, 0, 0, 1, 0, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 1, 0, 1, 12, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteWall"));
        this.fillWithBlocks(world, sbb, 13, 0, 1, 13, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));

        this.fillWithBlocks(world, sbb, 0, 0, 5, 0, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 1, 0, 5, 4, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 5, 0, 5, 8, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 9, 0, 5, 12, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 13, 0, 5, 13, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));

        for (int i = 0; i < xSize; i++){
            for(int j = 0; j < zSize; j++){
                this.clearCurrentPositionBlocksUpwards(world, i, ySize, j, sbb);
                this.func_151554_b(world, Blocks.cobblestone, 0, i, -1, j, sbb);
            }
        }

        this.spawnVillagers(world, sbb, 3, 1, 3, 1);
        return true;
    }
    public void fillWithBlocks(World world, StructureBoundingBox sbb, int minX, int minY, int minZ, int maxX, int maxY, int maxZ, Block block){
        this.fillWithBlocks(world, sbb, minX, minY, minZ, maxX, maxY, maxZ, block, block, false);
    }
}
