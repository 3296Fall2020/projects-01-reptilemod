package edu.temple.reptiles.client.model;

import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import edu.temple.reptiles.entities.ChameleonEntity;

public class ChameleonModel<T extends ChameleonEntity> extends EntityModel<T> {
    private final ModelRenderer body;
    private final ModelRenderer head;
    private final ModelRenderer leftEye;
    private final ModelRenderer rightEye;
    private final ModelRenderer tail;
    private final ModelRenderer legLeftFront;
    private final ModelRenderer legRightFront;
    private final ModelRenderer legLeftBack;
    private final ModelRenderer legRightBack;

    public ChameleonModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 22.5F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, -2.0F);
        body.addChild(head);
        head.setTextureOffset(0, 8).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);

        leftEye = new ModelRenderer(this);
        leftEye.setRotationPoint(0.0F, -1.0F, -1.8F);
        head.addChild(leftEye);
        setRotationAngle(leftEye, 0.0F, -0.1745F, 0.0F);
        leftEye.setTextureOffset(4, 13).addBox(-2.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        rightEye = new ModelRenderer(this);
        rightEye.setRotationPoint(0.0F, -1.0F, -1.8F);
        head.addChild(rightEye);
        setRotationAngle(rightEye, 0.0F, 0.1745F, 0.0F);
        rightEye.setTextureOffset(0, 13).addBox(1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.5F, 2.5F);
        body.addChild(tail);
        tail.setTextureOffset(9, 10).addBox(-1.0F, -2.5F, 0.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);

        legLeftFront = new ModelRenderer(this);
        legLeftFront.setRotationPoint(-1.5F, 0.15F, -2.0F);
        body.addChild(legLeftFront);
        setRotationAngle(legLeftFront, 0.0F, 0.0F, -0.4363F);
        legLeftFront.setTextureOffset(9, 8).addBox(-2.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legRightFront = new ModelRenderer(this);
        legRightFront.setRotationPoint(1.5F, 0.15F, -2.0F);
        body.addChild(legRightFront);
        setRotationAngle(legRightFront, 0.0F, 0.0F, 0.4363F);
        legRightFront.setTextureOffset(0, 4).addBox(0.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legLeftBack = new ModelRenderer(this);
        legLeftBack.setRotationPoint(-1.5F, 0.15F, 0.8F);
        body.addChild(legLeftBack);
        setRotationAngle(legLeftBack, 0.0F, 0.0F, -0.4363F);
        legLeftBack.setTextureOffset(0, 2).addBox(-2.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        legRightBack = new ModelRenderer(this);
        legRightBack.setRotationPoint(1.5F, 0.15F, 0.8F);
        body.addChild(legRightBack);
        setRotationAngle(legRightBack, 0.0F, 0.0F, 0.4363F);
        legRightBack.setTextureOffset(0, 0).addBox(0.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(ChameleonEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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