package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.NessieModel;
import edu.temple.reptiles.entities.NessieEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class NessieRenderer extends MobRenderer<NessieEntity, NessieModel<NessieEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/nessie.png");

    public NessieRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new NessieModel<>(), 2f);
    }

    @Override
    public ResourceLocation getEntityTexture(NessieEntity entity) { return TEXTURE; }
}
