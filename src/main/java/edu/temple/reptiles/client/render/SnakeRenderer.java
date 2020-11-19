package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.SnakeModel;
import edu.temple.reptiles.entities.SnakeEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SnakeRenderer extends MobRenderer<SnakeEntity, SnakeModel> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/snake.png");

    public SnakeRenderer(EntityRendererManager renderManagerIn){
        super(renderManagerIn, new SnakeModel(), 0.3F);
    }

    @Override
    public ResourceLocation getEntityTexture(SnakeEntity entity){
        return TEXTURE;
    }
}
