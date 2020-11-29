package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.CrocodileModel;
import edu.temple.reptiles.entities.CrocodileEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CrocodileRenderer extends MobRenderer<CrocodileEntity, CrocodileModel> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/crocodile.png");

    public CrocodileRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new CrocodileModel(), 0.7F);
    }

    @Override
    public ResourceLocation getEntityTexture(CrocodileEntity entity) {
        return TEXTURE;
    }
}
