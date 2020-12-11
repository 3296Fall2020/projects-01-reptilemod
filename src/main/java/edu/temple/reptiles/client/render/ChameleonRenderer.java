package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.ChameleonModel;
import edu.temple.reptiles.entities.ChameleonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

public class ChameleonRenderer extends MobRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {

    protected static ResourceLocation TEXTURE;

    protected static final ResourceLocation DEFAULT_TEXTURE =
            new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon/default_chameleon.png");
    protected static final ResourceLocation SANDY_TEXTURE =
            new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon/sandy_chameleon.png");
    protected static final ResourceLocation JUNGLE_TEXTURE =
            new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon/jungle_chameleon.png");
    protected static final ResourceLocation SWAMP_TEXTURE =
            new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon/swamp_chameleon.png");
    protected static final ResourceLocation SWIMMING_TEXTURE =
            new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon/swimming_chameleon.png");

    public ChameleonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ChameleonModel(), 0.3f);
    }

    @Override
    public ResourceLocation getEntityTexture(ChameleonEntity entity) {
        TEXTURE = getTexture(entity);
        return TEXTURE;
    }

    public ResourceLocation getTexture(ChameleonEntity entity) {
        Biome.Category category = entity.getEntityWorld()
                .getBiome(entity.getPosition()).getCategory();
        if(category == Biome.Category.BEACH || category == Biome.Category.DESERT) {
            return SANDY_TEXTURE;
        } else if(category == Biome.Category.JUNGLE) {
            return JUNGLE_TEXTURE;
        } else if(category == Biome.Category.SWAMP) {
            return SWAMP_TEXTURE;
        } else if(category == Biome.Category.ICY || category == Biome.Category.OCEAN
            || category == Biome.Category.RIVER) {
            return SWIMMING_TEXTURE;
        }
        return DEFAULT_TEXTURE;
    }
}
