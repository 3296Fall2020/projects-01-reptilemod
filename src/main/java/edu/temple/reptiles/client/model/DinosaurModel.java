package edu.temple.reptiles.client.model;

import edu.temple.reptiles.entities.DinosaurEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import edu.temple.reptiles.Reptiles;

public class DinosaurModel<T extends DinosaurEntity> extends AnimatedEntityModel<T> {

    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer neck;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer mouth;
    private final AnimatedModelRenderer horns;
    private final AnimatedModelRenderer shield;
    private final AnimatedModelRenderer leg0;
    private final AnimatedModelRenderer leg1;
    private final AnimatedModelRenderer leg2;
    private final AnimatedModelRenderer leg3;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer tail2;
    private final AnimatedModelRenderer tail3;

    public DinosaurModel()
    {
        textureWidth = 256;
        textureHeight = 256;
        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 5.0F, 2.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-7.0F, -7.0F, -4.0F, 14.0F, 16.0F, 20.0F, 0.0F, false);
        body.setTextureOffset(46, 49).addBox(-6.0F, 9.0F, -4.0F, 12.0F, 13.0F, 18.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        neck = new AnimatedModelRenderer(this);
        neck.setRotationPoint(0.0F, 6.0F, -20.0F);
        setRotationAngle(neck, 0.2182F, 0.0F, 0.0F);
        neck.setTextureOffset(0, 67).addBox(-5.0F, -11.0F, 10.0F, 10.0F, 10.0F, 18.0F, 0.0F, false);
        neck.setModelRendererName("neck");
        this.registerModelRenderer(neck);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, -7.0237F, 9.7836F);
        neck.addChild(head);
        setRotationAngle(head, 0.0F, 0.0F, 0.0F);
        head.setTextureOffset(0, 36).addBox(-8.0F, -1.0F, -14.0F, 16.0F, 15.0F, 16.0F, 0.0F, false);
        head.setTextureOffset(88, 42).addBox(-3.0F, 4.0F, -20.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        mouth = new AnimatedModelRenderer(this);
        mouth.setRotationPoint(0.0F, 13.0F, 0.0F);
        head.addChild(mouth);
        setRotationAngle(mouth, 0.1309F, 0.0F, 0.0F);
        mouth.setTextureOffset(52, 23).addBox(-8.0F, -1.0F, -14.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);
        mouth.setModelRendererName("mouth");
        this.registerModelRenderer(mouth);

        horns = new AnimatedModelRenderer(this);
        horns.setRotationPoint(-9.0F, 1.0F, -9.0F);
        head.addChild(horns);
        setRotationAngle(horns, 1.0472F, 0.0F, 0.0F);
        horns.setTextureOffset(0, 0).addBox(-1.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F, 0.0F, false);
        horns.setTextureOffset(12, 0).addBox(8.0F, -14.5622F, -10.5622F, 2.0F, 12.0F, 2.0F, 0.0F, false);
        horns.setTextureOffset(0, 0).addBox(17.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F, 0.0F, false);
        horns.setModelRendererName("horns");
        this.registerModelRenderer(horns);

        shield = new AnimatedModelRenderer(this);
        shield.setRotationPoint(0.0F, -1.0F, 11.0F);
        neck.addChild(shield);
        shield.setTextureOffset(68, 0).addBox(-15.0F, -20.0F, -1.0F, 30.0F, 20.0F, 3.0F, 0.0F, false);
        shield.setModelRendererName("shield");
        this.registerModelRenderer(shield);

        leg0 = new AnimatedModelRenderer(this);
        leg0.setRotationPoint(-4.0F, -6.0F, 22.0F);
        leg0.setTextureOffset(88, 88).addBox(-8.0F, -3.0F, -5.0F, 8.0F, 33.0F, 8.0F, 0.0F, false);
        leg0.setModelRendererName("leg0");
        this.registerModelRenderer(leg0);

        leg1 = new AnimatedModelRenderer(this);
        leg1.setRotationPoint(4.0F, -6.0F, 22.0F);
        leg1.setTextureOffset(88, 88).addBox(0.0F, -3.0F, -5.0F, 8.0F, 33.0F, 8.0F, 0.0F, false);
        leg1.setModelRendererName("leg1");
        this.registerModelRenderer(leg1);

        leg2 = new AnimatedModelRenderer(this);
        leg2.setRotationPoint(-4.0F, -2.0F, -4.0F);
        leg2.setTextureOffset(56, 80).addBox(-8.0F, -8.0F, -4.0F, 8.0F, 34.0F, 8.0F, 0.0F, false);
        leg2.setModelRendererName("leg2");
        this.registerModelRenderer(leg2);

        leg3 = new AnimatedModelRenderer(this);
        leg3.setRotationPoint(4.0F, -2.0F, -4.0F);
        leg3.setTextureOffset(56, 80).addBox(0.0F, -8.0F, -4.0F, 8.0F, 34.0F, 8.0F, 0.0F, false);
        leg3.setModelRendererName("leg3");
        this.registerModelRenderer(leg3);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, -1.0F, 24.0F);
        setRotationAngle(tail, 0.0F, 0.0F, 0.0F);
        tail.setTextureOffset(26, 95).addBox(-2.5F, -2.0F, -1.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        tail2 = new AnimatedModelRenderer(this);
        tail2.setRotationPoint(0.0F, 1.0F, 6.0F);
        tail.addChild(tail2);
        setRotationAngle(tail2, 0.0F, 0.0F, 0.0F);
        tail2.setTextureOffset(0, 95).addBox(-1.5F, -2.0F, 0.0F, 3.0F, 3.0F, 10.0F, 0.0F, false);
        tail2.setModelRendererName("tail2");
        this.registerModelRenderer(tail2);

        tail3 = new AnimatedModelRenderer(this);
        tail3.setRotationPoint(0.0F, 2.0F, 10.0F);
        tail2.addChild(tail3);
        tail3.setTextureOffset(96, 70).addBox(-0.5F, -3.0F, -1.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);
        tail3.setModelRendererName("tail3");
        this.registerModelRenderer(tail3);

        this.rootBones.add(body);
        this.rootBones.add(neck);
        this.rootBones.add(leg0);
        this.rootBones.add(leg1);
        this.rootBones.add(leg2);
        this.rootBones.add(leg3);
        this.rootBones.add(tail);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation(Reptiles.MOD_ID, "animations/dinosaur.json");
    }

}
