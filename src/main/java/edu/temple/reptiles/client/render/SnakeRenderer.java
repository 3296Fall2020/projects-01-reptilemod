package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.SnakeModel;
import edu.temple.reptiles.entities.SnakeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public class SnakeRenderer extends MobRenderer<SnakeEntity, SnakeModel> {

    protected static ResourceLocation TEXTURE;
    protected static final ResourceLocation DESERT_TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/snake/snake_desert.png");

    public SnakeRenderer(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new SnakeModel(), 0.0F);
    }

    @Override
    public ResourceLocation getEntityTexture(SnakeEntity entity){
        TEXTURE = getTexture(entity);
        return TEXTURE;
    }

    public ResourceLocation getTexture(SnakeEntity entity) {
        Biome.Category category = entity.getEntityWorld()
                .getBiome(entity.getPosition()).getCategory();
        if (category == Biome.Category.DESERT) {
            return DESERT_TEXTURE;
//        } else if(category == Biome.Category.JUNGLE) {
//            return JUNGLE_TEXTURE;
//        } else if(category == Biome.Category.SWAMP) {
//            return SWAMP_TEXTURE;
        } else {
            return DESERT_TEXTURE;
        }
    }
}
