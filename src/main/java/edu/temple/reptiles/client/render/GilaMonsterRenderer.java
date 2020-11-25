package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.GilaMonsterModel;
import edu.temple.reptiles.entities.GilaMonsterEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class GilaMonsterRenderer extends MobRenderer<GilaMonsterEntity, GilaMonsterModel<GilaMonsterEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/gila_monster.png");

    public GilaMonsterRenderer(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new GilaMonsterModel<>(), 0.0f);
    }

    @Override
    public ResourceLocation getEntityTexture(GilaMonsterEntity entity){
        return TEXTURE;
    }

}
