package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.ChameleonModel;
import edu.temple.reptiles.entities.ChameleonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class ChameleonRenderer extends MobRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/chameleon.png");

    public ChameleonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ChameleonModel<>(), 0.5f);
    }

    @Override
    public ResourceLocation getEntityTexture(ChameleonEntity entity) {
        return TEXTURE;
    }
}
