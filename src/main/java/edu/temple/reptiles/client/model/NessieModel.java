package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.NessieEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NessieModel<T extends NessieEntity> extends EntityModel<T> {

    private final ModelRenderer nessieBody;

    private final ModelRenderer neckSegmentOne;
    private final ModelRenderer neckSegmentTwo;
    private final ModelRenderer neckSegmentThree;
    private final ModelRenderer neckSegmentFour;
    private final ModelRenderer neckSegmentFive;
    private final ModelRenderer neckSegmentSix;

    private final ModelRenderer headBase;
    private final ModelRenderer lowerJaw;
    private final ModelRenderer leftEye;
    private final ModelRenderer rightEye;

    private final ModelRenderer tailSegmentOne;
    private final ModelRenderer tailSegmentTwo;
    private final ModelRenderer tailSegmentThree;
    private final ModelRenderer tailSegmentFour;
    private final ModelRenderer tailSegmentFive;

    private final ModelRenderer flipperFrontLeft;
    private final ModelRenderer flipperFrontRight;
    private final ModelRenderer flipperBackLeft;
    private final ModelRenderer flipperBackRight;

    public NessieModel() {
        textureWidth = 512;
        textureHeight = 512;

        nessieBody = new ModelRenderer(this);
        nessieBody.setRotationPoint(0.0F, 22.5F, -0.5F);
        setRotationAngle(nessieBody, 0.0436F, 0.0F, 0.0F);
        nessieBody.setTextureOffset(0, 0).addBox(-33.4F, -8.4F, -47.6F, 67.0F, 28.0F, 95.0F, 0.0F, false);

        neckSegmentOne = new ModelRenderer(this);
        neckSegmentOne.setRotationPoint(0.0F, -10.82F, -37.58F);
        nessieBody.addChild(neckSegmentOne);
        setRotationAngle(neckSegmentOne, -0.0873F, 0.0F, 0.0F);
        neckSegmentOne.setTextureOffset(0, 184).addBox(-19.4F, -3.7909F, -8.2834F, 39.0F, 22.0F, 28.0F, 0.0F, false);

        neckSegmentTwo = new ModelRenderer(this);
        neckSegmentTwo.setRotationPoint(0.0F, -7.84F, 1.68F);
        neckSegmentOne.addChild(neckSegmentTwo);
        setRotationAngle(neckSegmentTwo, -0.2182F, 0.0F, 0.0F);
        neckSegmentTwo.setTextureOffset(0, 0).addBox(-10.8F, -19.7573F, -7.9382F, 22.0F, 28.0F, 22.0F, 0.0F, false);

        neckSegmentThree = new ModelRenderer(this);
        neckSegmentThree.setRotationPoint(0.0F, -22.96F, 1.12F);
        neckSegmentTwo.addChild(neckSegmentThree);
        setRotationAngle(neckSegmentThree, -0.0436F, 0.0F, 0.0F);
        neckSegmentThree.setTextureOffset(0, 268).addBox(-8.6F, -35.5408F, -6.7087F, 17.0F, 50.0F, 17.0F, 0.0F, false);

        neckSegmentFour = new ModelRenderer(this);
        neckSegmentFour.setRotationPoint(0.0F, -31.5205F, -3.9227F);
        neckSegmentThree.addChild(neckSegmentFour);
        setRotationAngle(neckSegmentFour, 0.6981F, 0.0F, 0.0F);
        neckSegmentFour.setTextureOffset(263, 184).addBox(-8.646F, -21.2731F, -3.8143F, 17.0F, 28.0F, 17.0F, -0.01F, false);

        neckSegmentFive = new ModelRenderer(this);
        neckSegmentFive.setRotationPoint(0.0F, -24.5068F, 7.1234F);
        neckSegmentFour.addChild(neckSegmentFive);
        setRotationAngle(neckSegmentFive, -0.6545F, 0.0F, 0.0F);
        neckSegmentFive.setTextureOffset(246, 123).addBox(-8.692F, -1.6859F, -15.5047F, 17.0F, 17.0F, 22.0F, -0.02F, false);

        neckSegmentSix = new ModelRenderer(this);
        neckSegmentSix.setRotationPoint(0.0F, 1.1148F, -15.4942F);
        neckSegmentFive.addChild(neckSegmentSix);
        setRotationAngle(neckSegmentSix, 0.2618F, 0.0F, 0.0F);
        neckSegmentSix.setTextureOffset(202, 235).addBox(-8.738F, -1.8135F, -13.8568F, 17.0F, 17.0F, 17.0F, -0.03F, false);

        headBase = new ModelRenderer(this);
        headBase.setRotationPoint(0.0F, -2.0834F, -13.949F);
        neckSegmentSix.addChild(headBase);
        setRotationAngle(headBase, 0.2182F, 0.0F, 0.0F);
        headBase.setTextureOffset(112, 235).addBox(-14.0F, -0.4351F, -29.2337F, 28.0F, 17.0F, 34.0F, 0.0F, false);

        lowerJaw = new ModelRenderer(this);
        lowerJaw.setRotationPoint(0.0F, 7.073F, -2.1224F);
        headBase.addChild(lowerJaw);
        setRotationAngle(lowerJaw, 0.2182F, 0.0F, 0.0F);
        lowerJaw.setTextureOffset(236, 236).addBox(-14.046F, 8.4005F, -29.2749F, 28.0F, 6.0F, 34.0F, -0.01F, false);

        leftEye = new ModelRenderer(this);
        leftEye.setRotationPoint(-13.44F, -1.12F, -25.2F);
        headBase.addChild(leftEye);
        leftEye.setTextureOffset(139, 139).addBox(-6.0F, 0.0393F, 0.0456F, 6.0F, 11.0F, 11.0F, 0.0F, false);

        rightEye = new ModelRenderer(this);
        rightEye.setRotationPoint(13.44F, -1.12F, -25.2F);
        headBase.addChild(rightEye);
        rightEye.setTextureOffset(0, 123).addBox(-0.4F, 0.0393F, 0.0456F, 6.0F, 11.0F, 11.0F, 0.0F, false);

        tailSegmentOne = new ModelRenderer(this);
        tailSegmentOne.setRotationPoint(0.0F, -3.9637F, 41.702F);
        nessieBody.addChild(tailSegmentOne);
        setRotationAngle(tailSegmentOne, -0.0436F, 0.0F, 0.0F);
        tailSegmentOne.setTextureOffset(0, 123).addBox(-24.8F, -1.1013F, -8.4011F, 50.0F, 22.0F, 39.0F, 0.0F, false);

        tailSegmentTwo = new ModelRenderer(this);
        tailSegmentTwo.setRotationPoint(0.0F, 2.24F, 24.08F);
        tailSegmentOne.addChild(tailSegmentTwo);
        setRotationAngle(tailSegmentTwo, -0.0611F, 0.0F, 0.0F);
        tailSegmentTwo.setTextureOffset(144, 150).addBox(-17.2F, -1.6969F, 2.2415F, 34.0F, 17.0F, 34.0F, 0.0F, false);

        tailSegmentThree = new ModelRenderer(this);
        tailSegmentThree.setRotationPoint(0.0F, 0.0F, 28.0F);
        tailSegmentTwo.addChild(tailSegmentThree);
        setRotationAngle(tailSegmentThree, -0.1309F, 0.0F, 0.0F);
        tailSegmentThree.setTextureOffset(0, 50).addBox(-10.8F, 1.4693F, 2.8854F, 22.0F, 11.0F, 22.0F, 0.0F, false);

        tailSegmentFour = new ModelRenderer(this);
        tailSegmentFour.setRotationPoint(0.0F, 0.0F, 16.8F);
        tailSegmentThree.addChild(tailSegmentFour);
        setRotationAngle(tailSegmentFour, -0.0436F, 0.0F, 0.0F);
        tailSegmentFour.setTextureOffset(68, 268).addBox(-5.4F, 3.8447F, 1.4115F, 11.0F, 6.0F, 22.0F, 0.0F, false);

        tailSegmentFive = new ModelRenderer(this);
        tailSegmentFive.setRotationPoint(0.0F, 0.0F, 16.8F);
        tailSegmentFour.addChild(tailSegmentFive);
        setRotationAngle(tailSegmentFive, -0.0873F, 0.0F, 0.0F);
        tailSegmentFive.setTextureOffset(0, 145).addBox(-3.384F, 3.1545F, 5.3207F, 6.0F, 6.0F, 11.0F, -0.04F, false);

        flipperFrontLeft = new ModelRenderer(this);
        flipperFrontLeft.setRotationPoint(-28.0F, 1.6221F, -31.9827F);
        nessieBody.addChild(flipperFrontLeft);
        setRotationAngle(flipperFrontLeft, 0.0436F, 0.1309F, -0.0873F);
        flipperFrontLeft.setTextureOffset(0, 234).addBox(-43.4825F, 1.4996F, -10.0265F, 45.0F, 6.0F, 28.0F, 0.0F, false);

        flipperFrontRight = new ModelRenderer(this);
        flipperFrontRight.setRotationPoint(28.0F, 1.6221F, -31.9827F);
        nessieBody.addChild(flipperFrontRight);
        setRotationAngle(flipperFrontRight, 0.0436F, -0.1309F, 0.0873F);
        flipperFrontRight.setTextureOffset(134, 201).addBox(-1.7175F, 1.4996F, -10.0265F, 45.0F, 6.0F, 28.0F, 0.0F, false);

        flipperBackLeft = new ModelRenderer(this);
        flipperBackLeft.setRotationPoint(-28.0F, 0.2101F, 24.6326F);
        nessieBody.addChild(flipperBackLeft);
        setRotationAngle(flipperBackLeft, 0.0436F, 0.1309F, -0.0873F);
        flipperBackLeft.setTextureOffset(229, 34).addBox(-42.9114F, 0.6046F, -13.8413F, 45.0F, 6.0F, 28.0F, 0.0F, false);

        flipperBackRight = new ModelRenderer(this);
        flipperBackRight.setRotationPoint(28.0F, 0.2101F, 24.6326F);
        nessieBody.addChild(flipperBackRight);
        setRotationAngle(flipperBackRight, 0.0436F, -0.1309F, 0.0873F);
        flipperBackRight.setTextureOffset(229, 0).addBox(-2.2886F, 0.6046F, -13.8413F, 45.0F, 6.0F, 28.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        nessieBody.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
