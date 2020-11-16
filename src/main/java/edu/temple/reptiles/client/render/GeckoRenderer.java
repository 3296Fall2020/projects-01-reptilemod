package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.GeckoModel;
import edu.temple.reptiles.entities.GeckoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GeckoRenderer extends MobRenderer<GeckoEntity, GeckoModel<GeckoEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/gecko.png");



    public GeckoRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn,
                new GeckoModel<>(),
                0.4F);
    }

    @Override
    public ResourceLocation getEntityTexture(GeckoEntity entity) {
        return TEXTURE;
    }
}



