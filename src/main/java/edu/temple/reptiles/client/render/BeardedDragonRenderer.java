package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.BeardedDragonModel;
import edu.temple.reptiles.entities.BeardedDragonEntity;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class BeardedDragonRenderer extends MobRenderer<BeardedDragonEntity, BeardedDragonModel<BeardedDragonEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/bearded_dragon.png");
    protected static final ResourceLocation ANGRY_TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/bearded_dragon2.png");

    public BeardedDragonRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BeardedDragonModel<>(), 0.7F);
    }

    public ResourceLocation getEntityTexture(BeardedDragonEntity entity) {

        return entity.getAngerTime() > 0 ? ANGRY_TEXTURE : TEXTURE;
    }

}
