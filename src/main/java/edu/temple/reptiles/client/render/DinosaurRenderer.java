package edu.temple.reptiles.client.render;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.client.model.DinosaurModel;
import edu.temple.reptiles.entities.DinosaurEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

    public class DinosaurRenderer extends MobRenderer<DinosaurEntity, DinosaurModel<DinosaurEntity>> {

        protected static final ResourceLocation TEXTURE = new ResourceLocation(Reptiles.MOD_ID, "textures/entity/dinosaur.png");

        public DinosaurRenderer(EntityRendererManager renderManagerIn) {
            super(renderManagerIn, new DinosaurModel<>(), 1.0F);
        }

        @Override
        public ResourceLocation getEntityTexture(DinosaurEntity entity) {
            return TEXTURE;
        }
    }



