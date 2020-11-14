package edu.temple.reptiles.client.model;

import edu.temple.reptiles.entities.ChameleonEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ChameleonModel<T extends ChameleonEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer eyeRight_r1;
    private final ModelRenderer eyeLeft_r1;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer legFrontLeft_r1;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer legFrontRight_r1;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer legBackLeft_r1;
    private final ModelRenderer legBackRight;
    private final ModelRenderer legBackRight_r1;

    public ChameleonModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 21.5F, -3.5F);
        head.setTextureOffset(0, 8).addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, false);

        eyeRight_r1 = new ModelRenderer(this);
        eyeRight_r1.setRotationPoint(1.275F, 0.0F, -0.7865F);
        head.addChild(eyeRight_r1);
        setRotationAngle(eyeRight_r1, 0.0F, 0.1745F, 0.0F);
        eyeRight_r1.setTextureOffset(0, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        eyeLeft_r1 = new ModelRenderer(this);
        eyeLeft_r1.setRotationPoint(-1.275F, 0.0F, -0.7865F);
        head.addChild(eyeLeft_r1);
        setRotationAngle(eyeLeft_r1, 0.0F, -0.1745F, 0.0F);
        eyeLeft_r1.setTextureOffset(4, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 0.0F);
        tail.setTextureOffset(9, 10).addBox(-1.0F, -3.5F, 2.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(0.0F, 24.0F, 0.0F);


        legFrontLeft_r1 = new ModelRenderer(this);
        legFrontLeft_r1.setRotationPoint(-2.3498F, -0.78F, -1.5F);
        legFrontLeft.addChild(legFrontLeft_r1);
        setRotationAngle(legFrontLeft_r1, 0.0F, 0.0F, -0.4363F);
        legFrontLeft_r1.setTextureOffset(9, 8).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(1.8F, 22.3F, -1.5F);


        legFrontRight_r1 = new ModelRenderer(this);
        legFrontRight_r1.setRotationPoint(0.5498F, 0.92F, 0.0F);
        legFrontRight.addChild(legFrontRight_r1);
        setRotationAngle(legFrontRight_r1, 0.0F, 0.0F, 0.4363F);
        legFrontRight_r1.setTextureOffset(0, 4).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(0.0F, 24.0F, 0.0F);


        legBackLeft_r1 = new ModelRenderer(this);
        legBackLeft_r1.setRotationPoint(-2.3498F, -0.78F, 1.5F);
        legBackLeft.addChild(legBackLeft_r1);
        setRotationAngle(legBackLeft_r1, 0.0F, 0.0F, -0.4363F);
        legBackLeft_r1.setTextureOffset(0, 2).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(0.0F, 24.0F, 0.0F);


        legBackRight_r1 = new ModelRenderer(this);
        legBackRight_r1.setRotationPoint(2.3498F, -0.78F, 1.5F);
        legBackRight.addChild(legBackRight_r1);
        setRotationAngle(legBackRight_r1, 0.0F, 0.0F, 0.4363F);
        legBackRight_r1.setTextureOffset(0, 0).addBox(-1.0F, -0.5F, -0.5F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
