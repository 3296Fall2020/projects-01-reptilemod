package edu.temple.reptiles.client.model;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.SnakeEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SnakeModel extends AnimatedEntityModel<SnakeEntity>{
    private final AnimatedModelRenderer body1;
    private final AnimatedModelRenderer body2;
    private final AnimatedModelRenderer body3;
    private final AnimatedModelRenderer body4;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer tail2;
    private final AnimatedModelRenderer tail3;
    private final AnimatedModelRenderer tail4;
    private final AnimatedModelRenderer tail5;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer jawTop;
    private final AnimatedModelRenderer jawBot;

    public SnakeModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        body1 = new AnimatedModelRenderer(this);
        body1.setRotationPoint(0.05F, 23.225F, -2.75F);
        body1.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.65F, 2.0F, 2.0F, 2.0F, -0.28F, false);
        body1.setModelRendererName("body1");
        this.registerModelRenderer(body1);

        body2 = new AnimatedModelRenderer(this);
        body2.setRotationPoint(0.05F, 23.225F, -1.25F);
        body2.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.75F, 2.0F, 2.0F, 2.0F, -0.26F, false);
        body2.setModelRendererName("body2");
        this.registerModelRenderer(body2);

        body3 = new AnimatedModelRenderer(this);
        body3.setRotationPoint(0.05F, 23.225F, 0.25F);
        body3.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.775F, 2.0F, 2.0F, 2.0F, -0.261F, false);
        body3.setModelRendererName("body3");
        this.registerModelRenderer(body3);

        body4 = new AnimatedModelRenderer(this);
        body4.setRotationPoint(0.05F, 23.225F, 1.7F);
        body4.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.75F, 2.0F, 2.0F, 2.0F, -0.26F, false);
        body4.setModelRendererName("body4");
        this.registerModelRenderer(body4);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.05F, 23.25F, 3.125F);
        tail.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.7F, 2.0F, 2.0F, 2.0F, -0.28F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        tail2 = new AnimatedModelRenderer(this);
        tail2.setRotationPoint(0.05F, 23.275F, 4.55F);
        tail2.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.7F, 2.0F, 2.0F, 2.0F, -0.3F, false);
        tail2.setModelRendererName("tail2");
        this.registerModelRenderer(tail2);

        tail3 = new AnimatedModelRenderer(this);
        tail3.setRotationPoint(0.05F, 23.35F, 5.725F);
        tail3.setTextureOffset(0, 0).addBox(-1.0F, -1.0F, -1.6F, 2.0F, 2.0F, 2.0F, -0.4F, false);
        tail3.setModelRendererName("tail3");
        this.registerModelRenderer(tail3);

        tail4 = new AnimatedModelRenderer(this);
        tail4.setRotationPoint(0.05F, 23.425F, 6.725F);
        tail4.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        tail4.setModelRendererName("tail4");
        this.registerModelRenderer(tail4);

        tail5 = new AnimatedModelRenderer(this);
        tail5.setRotationPoint(0.05F, 23.5F, 7.5F);
        tail5.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, -0.9F, 1.0F, 1.0F, 1.0F, -0.1F, false);
        tail5.setModelRendererName("tail5");
        this.registerModelRenderer(tail5);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0187F, 23.3375F, -4.125F);
        head.setTextureOffset(0, 0).addBox(-1.1688F, -1.1625F, -1.225F, 1.0F, 1.0F, 1.0F, -0.2F, false);
        head.setTextureOffset(0, 0).addBox(0.2063F, -1.1625F, -1.225F, 1.0F, 1.0F, 1.0F, -0.2F, true);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        jawTop = new AnimatedModelRenderer(this);
        jawTop.setRotationPoint(-0.1187F, 0.6625F, 4.1F);
        head.addChild(jawTop);
        jawTop.setTextureOffset(0, 0).addBox(-1.35F, -2.075F, -6.5F, 3.0F, 2.0F, 3.0F, -0.6F, false);
        jawTop.setTextureOffset(0, 0).addBox(-0.85F, -1.5F, -7.7F, 2.0F, 1.0F, 2.0F, -0.22F, false);
        jawTop.setModelRendererName("jawTop");
        this.registerModelRenderer(jawTop);

        jawBot = new AnimatedModelRenderer(this);
        jawBot.setRotationPoint(-0.0187F, 0.6625F, 4.125F);
        head.addChild(jawBot);
        jawBot.setTextureOffset(0, 0).addBox(-0.95F, -0.875F, -5.925F, 2.0F, 1.0F, 2.0F, -0.2F, false);
        jawBot.setTextureOffset(0, 0).addBox(-0.95F, -0.95F, -7.475F, 2.0F, 1.0F, 2.0F, -0.24F, false);
        jawBot.setModelRendererName("jawBot");
        this.registerModelRenderer(jawBot);

        this.rootBones.add(body1);
        this.rootBones.add(body2);
        this.rootBones.add(body3);
        this.rootBones.add(body4);
        this.rootBones.add(tail);
        this.rootBones.add(tail2);
        this.rootBones.add(tail3);
        this.rootBones.add(tail4);
        this.rootBones.add(tail5);
        this.rootBones.add(head);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation(Reptiles.MOD_ID, "animations/snake.json");
    }
}
