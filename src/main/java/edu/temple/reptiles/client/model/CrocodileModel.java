package edu.temple.reptiles.client.model;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.CrocodileEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class CrocodileModel extends AnimatedEntityModel<CrocodileEntity> {

    private final AnimatedModelRenderer headModel;
    private final AnimatedModelRenderer jawTop;
    private final AnimatedModelRenderer jawBottom;
    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer scalesLeft;
    private final AnimatedModelRenderer scalesRight;
    private final AnimatedModelRenderer legFrontRight;
    private final AnimatedModelRenderer legBackRight;
    private final AnimatedModelRenderer legFrontLeft;
    private final AnimatedModelRenderer legBackLeft;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer tailSection1;
    private final AnimatedModelRenderer tailSection2;
    private final AnimatedModelRenderer tailSection3;

    public CrocodileModel()
    {
        textureWidth = 64;
        textureHeight = 64;
        headModel = new AnimatedModelRenderer(this);
        headModel.setRotationPoint(0.0F, 20.0F, -8.0F);
        headModel.setTextureOffset(0, 31).addBox(-3.0F, -1.5F, -5.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);
        headModel.setTextureOffset(33, 6).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        headModel.setTextureOffset(17, 26).addBox(-3.0F, -3.0F, -4.0F, 2.0F, 2.0F, 2.0F, -0.5F, false);
        headModel.setTextureOffset(0, 26).addBox(1.0F, -3.0F, -4.0F, 2.0F, 2.0F, 2.0F, -0.5F, false);
        headModel.setModelRendererName("headModel");
        this.registerModelRenderer(headModel);

        jawTop = new AnimatedModelRenderer(this);
        jawTop.setRotationPoint(0.0F, -1.0F, -5.0F);
        headModel.addChild(jawTop);
        jawTop.setTextureOffset(17, 22).addBox(-2.0F, 0.0F, -8.0F, 4.0F, 1.0F, 9.0F, 0.0F, false);
        jawTop.setTextureOffset(16, 32).addBox(0.1F, 0.5F, -8.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(4, 14).addBox(-1.1F, 0.5F, -8.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(7, 38).addBox(1.225F, 0.675F, -8.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(0, 14).addBox(-2.225F, 0.675F, -8.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(0, 31).addBox(1.225F, 0.675F, -6.125F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(12, 9).addBox(-2.225F, 0.675F, -6.125F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(12, 14).addBox(1.225F, 0.675F, -4.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(12, 7).addBox(-2.225F, 0.675F, -4.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(8, 14).addBox(1.225F, 0.675F, -2.125F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setTextureOffset(12, 2).addBox(-2.225F, 0.675F, -2.125F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawTop.setModelRendererName("jawTop");
        this.registerModelRenderer(jawTop);

        jawBottom = new AnimatedModelRenderer(this);
        jawBottom.setRotationPoint(0.0F, 1.0F, -5.0F);
        headModel.addChild(jawBottom);
        jawBottom.setTextureOffset(0, 21).addBox(-2.0F, -0.8F, -8.0F, 4.0F, 1.0F, 9.0F, 0.0F, false);
        jawBottom.setTextureOffset(35, 32).addBox(1.175F, -1.5F, -7.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(0, 2).addBox(-2.175F, -1.5F, -7.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(34, 29).addBox(1.175F, -1.5F, -5.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(0, 7).addBox(-2.175F, -1.5F, -5.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(19, 33).addBox(1.175F, -1.5F, -3.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(0, 9).addBox(-2.175F, -1.5F, -3.1F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(0, 33).addBox(1.175F, -1.5F, -1.2F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(12, 0).addBox(-2.175F, -1.5F, -1.2F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(31, 32).addBox(0.675F, -1.5F, -8.175F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setTextureOffset(0, 0).addBox(-1.675F, -1.5F, -8.175F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        jawBottom.setModelRendererName("jawBottom");
        this.registerModelRenderer(jawBottom);

        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 23.0F, 1.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -9.0F, 8.0F, 4.0F, 17.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        scalesLeft = new AnimatedModelRenderer(this);
        scalesLeft.setRotationPoint(1.0F, -5.0F, 6.0F);
        body.addChild(scalesLeft);
        scalesLeft.setTextureOffset(18, 43).addBox(0.0F, -1.0F, -13.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(42, 23).addBox(0.0F, -1.0F, -9.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(12, 42).addBox(0.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(6, 42).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setModelRendererName("scalesLeft");
        this.registerModelRenderer(scalesLeft);

        scalesRight = new AnimatedModelRenderer(this);
        scalesRight.setRotationPoint(1.0F, -5.0F, 6.0F);
        body.addChild(scalesRight);
        scalesRight.setTextureOffset(0, 42).addBox(-3.0F, -1.0F, -13.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesRight.setTextureOffset(41, 30).addBox(-3.0F, -1.0F, -9.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesRight.setTextureOffset(40, 41).addBox(-3.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesRight.setTextureOffset(36, 39).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesRight.setModelRendererName("scalesRight");
        this.registerModelRenderer(scalesRight);

        legFrontRight = new AnimatedModelRenderer(this);
        legFrontRight.setRotationPoint(-4.0F, 21.0F, -5.0F);
        legFrontRight.setTextureOffset(44, 44).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legFrontRight.setTextureOffset(28, 38).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        legFrontRight.setTextureOffset(10, 38).addBox(-3.0F, 2.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        legFrontRight.setModelRendererName("legFrontRight");
        this.registerModelRenderer(legFrontRight);

        legBackRight = new AnimatedModelRenderer(this);
        legBackRight.setRotationPoint(-4.0F, 21.0F, 6.0F);
        legBackRight.setTextureOffset(36, 43).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legBackRight.setTextureOffset(20, 38).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        legBackRight.setTextureOffset(0, 38).addBox(-3.0F, 2.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        legBackRight.setModelRendererName("legBackRight");
        this.registerModelRenderer(legBackRight);

        legFrontLeft = new AnimatedModelRenderer(this);
        legFrontLeft.setRotationPoint(4.0F, 21.0F, -5.0F);
        legFrontLeft.setTextureOffset(30, 43).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legFrontLeft.setTextureOffset(17, 21).addBox(1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        legFrontLeft.setTextureOffset(34, 25).addBox(1.0F, 2.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        legFrontLeft.setModelRendererName("legFrontLeft");
        this.registerModelRenderer(legFrontLeft);

        legBackLeft = new AnimatedModelRenderer(this);
        legBackLeft.setRotationPoint(4.0F, 21.0F, 6.0F);
        legBackLeft.setTextureOffset(24, 43).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legBackLeft.setTextureOffset(0, 21).addBox(1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);
        legBackLeft.setTextureOffset(34, 21).addBox(1.0F, 2.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        legBackLeft.setModelRendererName("legBackLeft");
        this.registerModelRenderer(legBackLeft);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, 20.5F, 8.0F);

        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        tailSection1 = new AnimatedModelRenderer(this);
        tailSection1.setRotationPoint(0.0F, -0.5F, 1.0F);
        tail.addChild(tailSection1);
        tailSection1.setTextureOffset(0, 7).addBox(-2.0F, -1.5F, -1.0F, 4.0F, 3.0F, 4.0F, -0.01F, false);
        tailSection1.setTextureOffset(0, 0).addBox(-2.0F, -1.4F, 2.0F, 4.0F, 3.0F, 4.0F, -0.2F, false);
        tailSection1.setModelRendererName("tailSection1");
        this.registerModelRenderer(tailSection1);

        tailSection2 = new AnimatedModelRenderer(this);
        tailSection2.setRotationPoint(0.0F, -0.4F, 6.8F);
        tail.addChild(tailSection2);
        tailSection2.setTextureOffset(33, 0).addBox(-2.0F, -1.4F, -0.8F, 4.0F, 3.0F, 3.0F, -0.4F, false);
        tailSection2.setTextureOffset(20, 32).addBox(-2.0F, -1.3F, 1.2F, 4.0F, 3.0F, 3.0F, -0.6F, false);
        tailSection2.setModelRendererName("tailSection2");
        this.registerModelRenderer(tailSection2);

        tailSection3 = new AnimatedModelRenderer(this);
        tailSection3.setRotationPoint(0.0F, -0.05F, 10.0F);
        tail.addChild(tailSection3);
        tailSection3.setTextureOffset(34, 34).addBox(-1.5F, -1.05F, -0.4F, 3.0F, 2.0F, 3.0F, -0.4F, false);
        tailSection3.setTextureOffset(33, 11).addBox(-1.5F, -0.95F, 1.6F, 3.0F, 2.0F, 3.0F, -0.6F, false);
        tailSection3.setModelRendererName("tailSection3");
        this.registerModelRenderer(tailSection3);

        this.rootBones.add(headModel);
        this.rootBones.add(body);
        this.rootBones.add(legFrontRight);
        this.rootBones.add(legBackRight);
        this.rootBones.add(legFrontLeft);
        this.rootBones.add(legBackLeft);
        this.rootBones.add(tail);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation(Reptiles.MOD_ID, "animations/crocodile.json");
    }
}


