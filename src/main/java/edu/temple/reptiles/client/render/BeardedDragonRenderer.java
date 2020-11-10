package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.BeardedDragonModel;
import edu.temple.reptiles.entities.BeardedDragonEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BeardedDragonRenderer extends MobRenderer<BeardedDragonEntity, BeardedDragonModel<BeardedDragonEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/beardeddragon.png");

    public BeardedDragonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BeardedDragonModel<>(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(BeardedDragonEntity entity) {
        return TEXTURE;
    }

}
