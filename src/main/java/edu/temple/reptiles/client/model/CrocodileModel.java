package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.CrocodileEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class CrocodileModel<T extends CrocodileEntity> extends EntityModel<T> {
    private final ModelRenderer headModel;
    private final ModelRenderer cube_r1;
    private final ModelRenderer body;
    private final ModelRenderer scalesLeft;
    private final ModelRenderer scalesRight;
    private final ModelRenderer legFrontRight;
    private final ModelRenderer cube_r2;
    private final ModelRenderer legBackRight;
    private final ModelRenderer cube_r3;
    private final ModelRenderer legFrontLeft;
    private final ModelRenderer cube_r4;
    private final ModelRenderer legBackLeft;
    private final ModelRenderer cube_r5;
    private final ModelRenderer tail;

    public CrocodileModel() {
        textureWidth = 64;
        textureHeight = 64;

        headModel = new ModelRenderer(this);
        headModel.setRotationPoint(0.0F, 20.0F, -8.0F);
        headModel.setTextureOffset(0, 30).addBox(-3.0F, -1.5F, -5.0F, 6.0F, 3.0F, 4.0F, 0.0F, false);
        headModel.setTextureOffset(20, 21).addBox(-2.0F, -1.0F, -13.0F, 4.0F, 1.0F, 8.0F, 0.0F, true);
        headModel.setTextureOffset(20, 30).addBox(-2.0F, -1.0F, -2.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        headModel.setTextureOffset(11, 0).addBox(1.0F, -2.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);
        headModel.setTextureOffset(11, 0).addBox(-2.0F, -2.5F, -4.0F, 1.0F, 1.0F, 2.0F, 0.0F, true);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 0.5F, -4.0F);
        headModel.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0436F, 0.0F, 0.0F);
        cube_r1.setTextureOffset(0, 21).addBox(-2.0F, -0.5F, -9.0F, 4.0F, 1.0F, 8.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 23.0F, 1.0F);
        body.setTextureOffset(0, 0).addBox(-4.0F, -5.0F, -9.0F, 8.0F, 4.0F, 17.0F, 0.0F, false);

        scalesLeft = new ModelRenderer(this);
        scalesLeft.setRotationPoint(1.0F, -5.0F, 6.0F);
        body.addChild(scalesLeft);
        scalesLeft.setTextureOffset(33, 4).addBox(0.0F, -1.0F, -13.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(33, 4).addBox(0.0F, -1.0F, -9.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(33, 4).addBox(0.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);
        scalesLeft.setTextureOffset(33, 4).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, -0.15F, false);

        scalesRight = new ModelRenderer(this);
        scalesRight.setRotationPoint(1.0F, -5.0F, 6.0F);
        body.addChild(scalesRight);
        scalesRight.setTextureOffset(33, 4).addBox(-3.0F, -1.0F, -13.0F, 1.0F, 2.0F, 2.0F, -0.15F, true);
        scalesRight.setTextureOffset(33, 4).addBox(-3.0F, -1.0F, -9.0F, 1.0F, 2.0F, 2.0F, -0.15F, true);
        scalesRight.setTextureOffset(33, 4).addBox(-3.0F, -1.0F, -5.0F, 1.0F, 2.0F, 2.0F, -0.15F, true);
        scalesRight.setTextureOffset(33, 4).addBox(-3.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, -0.15F, true);

        legFrontRight = new ModelRenderer(this);
        legFrontRight.setRotationPoint(-4.0F, 21.0F, -5.0F);
        legFrontRight.setTextureOffset(33, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legFrontRight.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-2.0F, 3.0F, 0.0F);
        legFrontRight.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, 0.3491F, 0.0F);
        cube_r2.setTextureOffset(33, 12).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        legBackRight = new ModelRenderer(this);
        legBackRight.setRotationPoint(-4.0F, 21.0F, 6.0F);
        legBackRight.setTextureOffset(33, 0).addBox(-1.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, false);
        legBackRight.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, false);

        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(-2.0F, 3.0F, 0.0F);
        legBackRight.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, 0.2618F, 0.0F);
        cube_r3.setTextureOffset(33, 12).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);

        legFrontLeft = new ModelRenderer(this);
        legFrontLeft.setRotationPoint(4.0F, 21.0F, -5.0F);
        legFrontLeft.setTextureOffset(33, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
        legFrontLeft.setTextureOffset(0, 6).addBox(1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(2.0F, 3.0F, 0.0F);
        legFrontLeft.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, -0.3491F, 0.0F);
        cube_r4.setTextureOffset(33, 8).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        legBackLeft = new ModelRenderer(this);
        legBackLeft.setRotationPoint(4.0F, 21.0F, 6.0F);
        legBackLeft.setTextureOffset(33, 0).addBox(0.0F, -1.0F, -1.0F, 1.0F, 2.0F, 2.0F, 0.0F, true);
        legBackLeft.setTextureOffset(0, 6).addBox(1.0F, -1.0F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(2.0F, 3.0F, 0.0F);
        legBackLeft.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, -0.2618F, 0.0F);
        cube_r5.setTextureOffset(33, 8).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 1.0F, 3.0F, 0.0F, true);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 20.0F, 8.0F);
        tail.setTextureOffset(50, 0).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        tail.setTextureOffset(50, 5).addBox(-2.0F, -1.0F, 3.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
        tail.setTextureOffset(56, 10).addBox(-1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(56, 14).addBox(-1.0F, -1.0F, 8.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(56, 18).addBox(-1.0F, 0.0F, 10.0F, 2.0F, 1.0F, 2.0F, 0.0F, false);
        tail.setTextureOffset(54, 21).addBox(-1.0F, 0.0F, 12.0F, 2.0F, 1.0F, 3.0F, 0.0F, false);
        tail.setTextureOffset(33, 4).addBox(1.0F, -2.0F, 2.0F, 1.0F, 2.0F, 2.0F, -0.3F, false);
        tail.setTextureOffset(33, 4).addBox(-2.0F, -2.0F, 2.0F, 1.0F, 2.0F, 2.0F, -0.3F, false);
        tail.setTextureOffset(33, 4).addBox(0.0F, -2.0F, 7.0F, 1.0F, 2.0F, 2.0F, -0.4F, false);
        tail.setTextureOffset(33, 4).addBox(-1.0F, -2.0F, 7.0F, 1.0F, 2.0F, 2.0F, -0.4F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageIntTicks, float netHeadYaw, float headPitch){
        this.headModel.rotateAngleX = headPitch * 0.017453292F;
        this.headModel.rotateAngleY = netHeadYaw * 0.017453292F;
        this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.tail.rotateAngleX = headPitch * 0.5F * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        headModel.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
        legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}


