package canitzp.advancedvanilla.worldGen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;

import java.util.List;
import java.util.Random;

public class ActuallyAdditionsSpecialHouse extends StructureVillagePieces.House1{

    private static final int xSize = 14;
    private static final int ySize = 8;
    private static final int zSize = 6;
    private int averageGroundLevel = -1;



    public ActuallyAdditionsSpecialHouse(StructureBoundingBox sbb, int coord)
    {
        this.coordBaseMode = coord;
        this.boundingBox = sbb;
    }

    public static ActuallyAdditionsSpecialHouse buildComponent(List pieces, int p1, int p2, int p3, int p4){
        StructureBoundingBox boundingBox = StructureBoundingBox.getComponentToAddBoundingBox(p1, p2, p3, 0, 0, 0, xSize, ySize, zSize, p4);
        return canVillageGoDeeper(boundingBox) && StructureComponent.findIntersecting(pieces, boundingBox) == null ? new ActuallyAdditionsSpecialHouse(boundingBox, p4) : null;
    }



    public boolean addComponentParts(World world, Random random, StructureBoundingBox sbb)
    {
        if(this.averageGroundLevel < 0){
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if(this.averageGroundLevel < 0) return true;
            this.boundingBox.offset(0, this.averageGroundLevel-this.boundingBox.maxY+ySize-1, 0);
        }

        this.fillWithBlocks(world, sbb, 0, 0, 0, xSize - 1, ySize - 1, zSize - 1, Blocks.air);

        //Layer1:


        this.fillBlockStair(world, sbb, 0, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 5);
        this.fillBlockStair(world, sbb, 1, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 2, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 3, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 4, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 5, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 5);
        this.fillBlockStair(world, sbb, 6, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 2);
        this.fillBlockStair(world, sbb, 7, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 2);
        this.fillBlockStair(world, sbb, 8, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 5);
        this.fillBlockStair(world, sbb, 9, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 10, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 11, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 12, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 5);
        this.fillBlockStair(world, sbb, 13, 0, 0, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 5);

        this.fillBlockStair(world, sbb, 0, 0, 1, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 7);
        this.fillBlockStair(world, sbb, 13, 0, 1, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 6);
        this.fillWithBlocks(world, sbb, 1, 0, 1, 12, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteWall"));

        this.fillBlockStair(world, sbb, 0, 0, 2, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 7);
        this.fillBlockStair(world, sbb, 13, 0, 2, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 6);

        this.fillBlockStair(world, sbb, 0, 0, 3, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 7);
        this.fillBlockStair(world, sbb, 13, 0, 3, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 6);

        this.fillBlockStair(world, sbb, 0, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 7);
        this.fillBlockStair(world, sbb, 13, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 6);

        this.fillBlockStair(world, sbb, 0, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);
        this.fillBlockStair(world, sbb, 1, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 2, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 3, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 4, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 5, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);
        this.fillBlockStair(world, sbb, 6, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);
        this.fillBlockStair(world, sbb, 7, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);
        this.fillBlockStair(world, sbb, 8, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);
        this.fillBlockStair(world, sbb, 9, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 10, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 11, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 12, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"), 4);
        this.fillBlockStair(world, sbb, 13, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"), 4);



        /*

        this.fillWithBlocks(world, sbb, 0, 0, 1, 0, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 1, 0, 1, 12, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteWall"));
        this.fillWithBlocks(world, sbb, 13, 0, 1, 13, 0, 4, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));

        this.fillWithBlocks(world, sbb, 0, 0, 5, 0, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 1, 0, 5, 4, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 5, 0, 5, 8, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        this.fillWithBlocks(world, sbb, 9, 0, 5, 12, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksGreenStairs"));
        this.fillWithBlocks(world, sbb, 13, 0, 5, 13, 0, 5, Block.getBlockFromName("ActuallyAdditions:blockTestifiBucksWhiteStairs"));
        */

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
    public void fillBlockStair(World world, StructureBoundingBox sbb, int x, int y, int z, Block block, int meta){
        this.placeBlockAtCurrentPosition(world, block, this.getMetadataWithOffset(block, meta), x, y, z, sbb);
    }
}
