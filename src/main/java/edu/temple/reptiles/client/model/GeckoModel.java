package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.GeckoEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.swing.text.html.parser.Entity;

public class GeckoModel <T extends GeckoEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer leftFrontLeg;
    private final ModelRenderer left_front_leg_r1;
    private final ModelRenderer rightFrontLeg;
    private final ModelRenderer right_front_leg_r1;
    private final ModelRenderer leftBackLeg;
    private final ModelRenderer left_back_leg_r1;
    private final ModelRenderer rightBackLeg;
    private final ModelRenderer right_back_leg_r1;
    private final ModelRenderer tail;

    public GeckoModel() {
        textureWidth = 6;
        textureHeight = 6;

        head = new ModelRenderer(this);
        head.setRotationPoint(2.1F, 24.0F, 3.0F);
        head.setTextureOffset(0, 0).addBox(-6.0F, -4.0F, -13.0F, 6.0F, 4.0F, 5.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -6.0F, 4.0F, 3.0F, 10.0F, 0.0F, false);

        leftFrontLeg = new ModelRenderer(this);
        leftFrontLeg.setRotationPoint(0.0F, 24.0F, 0.0F);


        left_front_leg_r1 = new ModelRenderer(this);
        left_front_leg_r1.setRotationPoint(-2.2431F, -0.5F, -0.3309F);
        leftFrontLeg.addChild(left_front_leg_r1);
        setRotationAngle(left_front_leg_r1, 0.0F, 0.733F, 0.0F);
        left_front_leg_r1.setTextureOffset(0, 0).addBox(-3.9123F, -0.5F, -0.926F, 5.0F, 1.0F, 2.0F, 0.0F, false);

        rightFrontLeg = new ModelRenderer(this);
        rightFrontLeg.setRotationPoint(0.0F, 24.0F, 0.0F);


        right_front_leg_r1 = new ModelRenderer(this);
        right_front_leg_r1.setRotationPoint(-0.1184F, -0.4666F, -0.6786F);
        rightFrontLeg.addChild(right_front_leg_r1);
        setRotationAngle(right_front_leg_r1, 0.1047F, -0.6981F, 0.0873F);
        right_front_leg_r1.setTextureOffset(0, 0).addBox(0.169F, -0.7272F, -1.4936F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        leftBackLeg = new ModelRenderer(this);
        leftBackLeg.setRotationPoint(0.0F, 24.0F, 0.0F);


        left_back_leg_r1 = new ModelRenderer(this);
        left_back_leg_r1.setRotationPoint(-3.5F, -0.5F, -3.0F);
        leftBackLeg.addChild(left_back_leg_r1);
        setRotationAngle(left_back_leg_r1, 0.0F, 0.48F, 0.0F);
        left_back_leg_r1.setTextureOffset(0, 0).addBox(-2.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        rightBackLeg = new ModelRenderer(this);
        rightBackLeg.setRotationPoint(0.0F, 24.0F, 0.0F);


        right_back_leg_r1 = new ModelRenderer(this);
        right_back_leg_r1.setRotationPoint(1.5F, -0.5F, -4.0F);
        rightBackLeg.addChild(right_back_leg_r1);
        setRotationAngle(right_back_leg_r1, 0.0F, -0.5236F, 0.0F);
        right_back_leg_r1.setTextureOffset(0, 0).addBox(-1.5F, -0.5F, -1.0F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 0.0F);
        tail.setTextureOffset(0, 0).addBox(-1.5F, -1.0F, 3.0F, 1.0F, 1.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch *  0.007453292F;
        this.head.rotateAngleY = netHeadYaw *  0.007453292F;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.1112F) * 1.4F * limbSwingAmount;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.1112F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.1112F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.1112F) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleX = headPitch * 0.5F * 0.017453292F;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        leftFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightFrontLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        leftBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightBackLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
