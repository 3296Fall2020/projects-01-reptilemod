package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.NessieEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NessieModel<T extends NessieEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer body_r1;
    private final ModelRenderer neckSegmentOne;
    private final ModelRenderer neckSegmentOne_r1;
    private final ModelRenderer neckSegmentTwo;
    private final ModelRenderer neckSegmentTwo_r1;
    private final ModelRenderer neckSegmentThree;
    private final ModelRenderer neckSegmentThree_r1;
    private final ModelRenderer neckSegmentFour;
    private final ModelRenderer neckSegmentFour_r1;
    private final ModelRenderer neckSegmentFive;
    private final ModelRenderer neckSegmentFive_r1;
    private final ModelRenderer neckSegmentSix;
    private final ModelRenderer headBase;
    private final ModelRenderer lowerJaw;
    private final ModelRenderer lowerJaw_r1;
    private final ModelRenderer leftEye;
    private final ModelRenderer rightEye;
    private final ModelRenderer tailSegmentOne;
    private final ModelRenderer tailSegmentOne_r1;
    private final ModelRenderer tailSegmentTwo;
    private final ModelRenderer tailSegmentTwo_r1;
    private final ModelRenderer tailSegmentThree;
    private final ModelRenderer tailSegmentThree_r1;
    private final ModelRenderer tailSegmentFour;
    private final ModelRenderer tailSegmentFour_r1;
    private final ModelRenderer tailSegmentFive;
    private final ModelRenderer tailSegmentFive_r1;
    private final ModelRenderer flippers;
    private final ModelRenderer flippersLeft;
    private final ModelRenderer flipperFrontLeft;
    private final ModelRenderer flipperFrontLeft_r1;
    private final ModelRenderer flipperBackLeft;
    private final ModelRenderer flipperBackLeft_r1;
    private final ModelRenderer flippersRight;
    private final ModelRenderer flipperFrontRight;
    private final ModelRenderer flipperFrontRight_r1;
    private final ModelRenderer flipperBackRight;
    private final ModelRenderer flipperBackRight_r1;

    public NessieModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 23.5707F, -0.7385F);


        body_r1 = new ModelRenderer(this);
        body_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(body_r1);
        setRotationAngle(body_r1, 0.0436F, 0.0F, 0.0F);
        body_r1.setTextureOffset(0, 0).addBox(-6.0F, -2.5F, -8.5F, 12.0F, 5.0F, 17.0F, 0.0F, false);

        neckSegmentOne = new ModelRenderer(this);
        neckSegmentOne.setRotationPoint(0.0F, -2.0707F, -6.0615F);
        body.addChild(neckSegmentOne);


        neckSegmentOne_r1 = new ModelRenderer(this);
        neckSegmentOne_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        neckSegmentOne.addChild(neckSegmentOne_r1);
        setRotationAngle(neckSegmentOne_r1, -0.0873F, 0.0F, 0.0F);
        neckSegmentOne_r1.setTextureOffset(27, 28).addBox(-3.5F, -1.3F, -2.2F, 7.0F, 4.0F, 5.0F, 0.0F, false);

        neckSegmentTwo = new ModelRenderer(this);
        neckSegmentTwo.setRotationPoint(0.0F, -1.1F, 0.3F);
        neckSegmentOne.addChild(neckSegmentTwo);


        neckSegmentTwo_r1 = new ModelRenderer(this);
        neckSegmentTwo_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        neckSegmentTwo.addChild(neckSegmentTwo_r1);
        setRotationAngle(neckSegmentTwo_r1, -0.3054F, 0.0F, 0.0F);
        neckSegmentTwo_r1.setTextureOffset(0, 0).addBox(-2.0F, -4.4F, -2.0F, 4.0F, 5.0F, 4.0F, 0.0F, false);

        neckSegmentThree = new ModelRenderer(this);
        neckSegmentThree.setRotationPoint(0.0F, -4.1F, 1.2F);
        neckSegmentTwo.addChild(neckSegmentThree);


        neckSegmentThree_r1 = new ModelRenderer(this);
        neckSegmentThree_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        neckSegmentThree.addChild(neckSegmentThree_r1);
        setRotationAngle(neckSegmentThree_r1, -0.3491F, 0.0F, 0.0F);
        neckSegmentThree_r1.setTextureOffset(22, 43).addBox(-1.5F, -6.9741F, -1.5483F, 3.0F, 9.0F, 3.0F, 0.03F, false);

        neckSegmentFour = new ModelRenderer(this);
        neckSegmentFour.setRotationPoint(0.0F, -6.3F, 2.1F);
        neckSegmentThree.addChild(neckSegmentFour);


        neckSegmentFour_r1 = new ModelRenderer(this);
        neckSegmentFour_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        neckSegmentFour.addChild(neckSegmentFour_r1);
        setRotationAngle(neckSegmentFour_r1, 0.3491F, 0.0F, 0.0F);
        neckSegmentFour_r1.setTextureOffset(48, 48).addBox(-1.5F, -4.3F, -1.5F, 3.0F, 5.0F, 3.0F, 0.02F, false);

        neckSegmentFive = new ModelRenderer(this);
        neckSegmentFive.setRotationPoint(0.0F, -4.0F, -2.0F);
        neckSegmentFour.addChild(neckSegmentFive);


        neckSegmentFive_r1 = new ModelRenderer(this);
        neckSegmentFive_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        neckSegmentFive.addChild(neckSegmentFive_r1);
        setRotationAngle(neckSegmentFive_r1, -0.4363F, 0.0F, 0.0F);
        neckSegmentFive_r1.setTextureOffset(34, 46).addBox(-1.5F, -1.3F, -2.4F, 3.0F, 3.0F, 4.0F, 0.01F, false);

        neckSegmentSix = new ModelRenderer(this);
        neckSegmentSix.setRotationPoint(0.0F, -0.5F, -2.0F);
        neckSegmentFive.addChild(neckSegmentSix);
        setRotationAngle(neckSegmentSix, -0.0436F, 0.0F, 0.0F);
        neckSegmentSix.setTextureOffset(48, 25).addBox(-1.5F, -1.7F, -2.6F, 3.0F, 3.0F, 3.0F, 0.0F, false);

        headBase = new ModelRenderer(this);
        headBase.setRotationPoint(0.0F, -0.0017F, -3.9365F);
        neckSegmentSix.addChild(headBase);
        setRotationAngle(headBase, 0.0873F, 0.0F, 0.0F);
        headBase.setTextureOffset(41, 6).addBox(-2.5F, -2.025F, -4.0011F, 5.0F, 3.0F, 6.0F, 0.01F, false);

        lowerJaw = new ModelRenderer(this);
        lowerJaw.setRotationPoint(0.0F, 0.6295F, 1.629F);
        headBase.addChild(lowerJaw);


        lowerJaw_r1 = new ModelRenderer(this);
        lowerJaw_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        lowerJaw.addChild(lowerJaw_r1);
        setRotationAngle(lowerJaw_r1, 0.6109F, 0.0F, 0.0F);
        lowerJaw_r1.setTextureOffset(0, 42).addBox(-2.5F, 0.2028F, -5.6456F, 5.0F, 1.0F, 6.0F, 0.0F, false);

        leftEye = new ModelRenderer(this);
        leftEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        headBase.addChild(leftEye);
        leftEye.setTextureOffset(0, 33).addBox(-3.0F, -2.1309F, -2.9971F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        rightEye = new ModelRenderer(this);
        rightEye.setRotationPoint(0.0F, 0.0F, 0.0F);
        headBase.addChild(rightEye);
        rightEye.setTextureOffset(0, 22).addBox(2.0F, -2.1309F, -2.9971F, 1.0F, 2.0F, 2.0F, 0.0F, false);

        tailSegmentOne = new ModelRenderer(this);
        tailSegmentOne.setRotationPoint(0.0F, -0.5707F, 8.5385F);
        body.addChild(tailSegmentOne);


        tailSegmentOne_r1 = new ModelRenderer(this);
        tailSegmentOne_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tailSegmentOne.addChild(tailSegmentOne_r1);
        setRotationAngle(tailSegmentOne_r1, -0.0436F, 0.0F, 0.0F);
        tailSegmentOne_r1.setTextureOffset(0, 22).addBox(-4.5F, -1.75F, -1.9F, 9.0F, 4.0F, 7.0F, 0.0F, false);

        tailSegmentTwo = new ModelRenderer(this);
        tailSegmentTwo.setRotationPoint(0.0F, 0.5006F, 4.8341F);
        tailSegmentOne.addChild(tailSegmentTwo);


        tailSegmentTwo_r1 = new ModelRenderer(this);
        tailSegmentTwo_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tailSegmentTwo.addChild(tailSegmentTwo_r1);
        setRotationAngle(tailSegmentTwo_r1, -0.1047F, 0.0F, 0.0F);
        tailSegmentTwo_r1.setTextureOffset(0, 33).addBox(-3.0F, -1.5102F, -1.9901F, 6.0F, 3.0F, 6.0F, 0.0F, false);

        tailSegmentThree = new ModelRenderer(this);
        tailSegmentThree.setRotationPoint(0.0F, 0.2757F, 4.1495F);
        tailSegmentTwo.addChild(tailSegmentThree);


        tailSegmentThree_r1 = new ModelRenderer(this);
        tailSegmentThree_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tailSegmentThree.addChild(tailSegmentThree_r1);
        setRotationAngle(tailSegmentThree_r1, -0.2182F, 0.0F, 0.0F);
        tailSegmentThree_r1.setTextureOffset(0, 9).addBox(-2.0F, -1.0212F, -0.9804F, 4.0F, 2.0F, 4.0F, 0.0F, false);

        tailSegmentFour = new ModelRenderer(this);
        tailSegmentFour.setRotationPoint(0.0F, 0.4715F, 2.951F);
        tailSegmentThree.addChild(tailSegmentFour);


        tailSegmentFour_r1 = new ModelRenderer(this);
        tailSegmentFour_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tailSegmentFour.addChild(tailSegmentFour_r1);
        setRotationAngle(tailSegmentFour_r1, -0.3927F, 0.0F, 0.0F);
        tailSegmentFour_r1.setTextureOffset(47, 33).addBox(-1.0F, -0.5197F, -0.3846F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        tailSegmentFive = new ModelRenderer(this);
        tailSegmentFive.setRotationPoint(0.0F, 1.2526F, 3.2363F);
        tailSegmentFour.addChild(tailSegmentFive);


        tailSegmentFive_r1 = new ModelRenderer(this);
        tailSegmentFive_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        tailSegmentFive.addChild(tailSegmentFive_r1);
        setRotationAngle(tailSegmentFive_r1, -0.6545F, 0.0F, 0.0F);
        tailSegmentFive_r1.setTextureOffset(0, 26).addBox(-0.5F, -0.4501F, -0.0794F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        flippers = new ModelRenderer(this);
        flippers.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(flippers);


        flippersLeft = new ModelRenderer(this);
        flippersLeft.setRotationPoint(-5.0F, -0.1F, 0.0F);
        flippers.addChild(flippersLeft);


        flipperFrontLeft = new ModelRenderer(this);
        flipperFrontLeft.setRotationPoint(0.0F, 0.5293F, -4.2615F);
        flippersLeft.addChild(flipperFrontLeft);


        flipperFrontLeft_r1 = new ModelRenderer(this);
        flipperFrontLeft_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        flipperFrontLeft.addChild(flipperFrontLeft_r1);
        setRotationAngle(flipperFrontLeft_r1, 0.0436F, 0.1309F, -0.0873F);
        flipperFrontLeft_r1.setTextureOffset(41, 0).addBox(-8.3F, -0.6F, -2.6F, 8.0F, 1.0F, 5.0F, 0.0F, false);

        flipperBackLeft = new ModelRenderer(this);
        flipperBackLeft.setRotationPoint(0.0F, -0.0707F, 3.9885F);
        flippersLeft.addChild(flipperBackLeft);


        flipperBackLeft_r1 = new ModelRenderer(this);
        flipperBackLeft_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        flipperBackLeft.addChild(flipperBackLeft_r1);
        setRotationAngle(flipperBackLeft_r1, 0.0436F, 0.1309F, -0.0873F);
        flipperBackLeft_r1.setTextureOffset(40, 40).addBox(-8.3F, -0.5F, -2.5F, 8.0F, 1.0F, 5.0F, 0.0F, false);

        flippersRight = new ModelRenderer(this);
        flippersRight.setRotationPoint(5.0F, -0.1F, 0.0F);
        flippers.addChild(flippersRight);


        flipperFrontRight = new ModelRenderer(this);
        flipperFrontRight.setRotationPoint(0.0F, 0.5293F, -4.2615F);
        flippersRight.addChild(flipperFrontRight);


        flipperFrontRight_r1 = new ModelRenderer(this);
        flipperFrontRight_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        flipperFrontRight.addChild(flipperFrontRight_r1);
        setRotationAngle(flipperFrontRight_r1, 0.0436F, -0.1309F, 0.0873F);
        flipperFrontRight_r1.setTextureOffset(19, 37).addBox(0.3F, -0.6F, -2.6F, 8.0F, 1.0F, 5.0F, 0.0F, false);

        flipperBackRight = new ModelRenderer(this);
        flipperBackRight.setRotationPoint(0.0F, -0.0707F, 3.9885F);
        flippersRight.addChild(flipperBackRight);


        flipperBackRight_r1 = new ModelRenderer(this);
        flipperBackRight_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
        flipperBackRight.addChild(flipperBackRight_r1);
        setRotationAngle(flipperBackRight_r1, 0.0436F, -0.1309F, 0.0873F);
        flipperBackRight_r1.setTextureOffset(25, 22).addBox(0.3F, -0.5F, -2.5F, 8.0F, 1.0F, 5.0F, 0.0F, true);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
