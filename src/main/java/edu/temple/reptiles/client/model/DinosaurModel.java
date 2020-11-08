package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.DinosaurEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.QuadrupedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

import javax.swing.text.html.parser.Entity;

public class DinosaurModel<T extends DinosaurEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer neck;
    private final ModelRenderer head;
    private final ModelRenderer mouth;
    private final ModelRenderer horns;
    private final ModelRenderer shield;
    private final ModelRenderer leg0;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer tail;
    private final ModelRenderer tail3_r1;
    private final ModelRenderer tail2_r1;
    private final ModelRenderer tail1_r1;

    public DinosaurModel() {
        textureWidth = 128;
        textureHeight = 128;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 5.0F, 2.0F);
        setRotationAngle(body, 1.5708F, 0.0F, 0.0F);
        body.setTextureOffset(0, 55).addBox(-7.0F, -7.0F, -4.0F, 14.0F, 16.0F, 20.0F, 0.0F, false);
        body.setTextureOffset(0, 91).addBox(-6.0F, 9.0F, -4.0F, 12.0F, 13.0F, 18.0F, 0.0F, false);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 6.0F, -20.0F);
        setRotationAngle(neck, 0.2182F, 0.0F, 0.0F);
        neck.setTextureOffset(68, 73).addBox(-5.0F, -11.0F, 10.0F, 10.0F, 10.0F, 18.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, -7.0237F, 9.7836F);
        neck.addChild(head);
        head.setTextureOffset(0, 0).addBox(-8.0F, -1.0F, -14.0F, 16.0F, 15.0F, 16.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-3.0F, 4.0F, -20.0F, 6.0F, 11.0F, 6.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setRotationPoint(0.0F, 13.0F, 0.0F);
        head.addChild(mouth);
        mouth.setTextureOffset(0, 36).addBox(-8.0F, -1.0F, -14.0F, 16.0F, 3.0F, 16.0F, 0.0F, false);

        horns = new ModelRenderer(this);
        horns.setRotationPoint(-5.0F, 1.0F, -9.0F);
        head.addChild(horns);
        setRotationAngle(horns, 1.0472F, 0.0F, 0.0F);
        horns.setTextureOffset(74, 55).addBox(-5.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F, 0.0F, false);
        horns.setTextureOffset(74, 55).addBox(4.0F, -14.5622F, -10.5622F, 2.0F, 12.0F, 2.0F, 0.0F, false);
        horns.setTextureOffset(74, 55).addBox(13.0F, -14.0F, -1.0F, 2.0F, 14.0F, 4.0F, 0.0F, false);

        shield = new ModelRenderer(this);
        shield.setRotationPoint(0.0F, 0.0F, 0.0F);
        neck.addChild(shield);
        shield.setTextureOffset(68, 73).addBox(-15.0F, -21.0F, 10.0F, 30.0F, 20.0F, 3.0F, 0.0F, false);

        leg0 = new ModelRenderer(this);
        leg0.setRotationPoint(-12.0F, -6.0F, 22.0F);
        leg0.setTextureOffset(96, 0).addBox(0.0F, -7.0F, -5.0F, 8.0F, 37.0F, 8.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(4.0F, -6.0F, 22.0F);
        leg1.setTextureOffset(96, 0).addBox(0.0F, -7.0F, -5.0F, 8.0F, 37.0F, 8.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(-4.0F, -2.0F, -4.0F);
        leg2.setTextureOffset(64, 0).addBox(-8.0F, -11.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(-4.0F, -2.0F, -4.0F);
        leg3.setTextureOffset(64, 0).addBox(8.0F, -11.0F, -4.0F, 8.0F, 37.0F, 8.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 0.0F);


        tail3_r1 = new ModelRenderer(this);
        tail3_r1.setRotationPoint(4.0F, -19.0F, 43.0F);
        tail.addChild(tail3_r1);
        setRotationAngle(tail3_r1, -0.3054F, 0.1745F, 0.0F);
        tail3_r1.setTextureOffset(0, 0).addBox(-2.3F, -2.5F, 0.0F, 1.0F, 1.0F, 10.0F, 0.0F, false);

        tail2_r1 = new ModelRenderer(this);
        tail2_r1.setRotationPoint(2.0F, -22.0F, 34.0F);
        tail.addChild(tail2_r1);
        setRotationAngle(tail2_r1, -0.3054F, 0.1745F, 0.0F);
        tail2_r1.setTextureOffset(0, 0).addBox(-3.0F, -3.5F, 0.0F, 3.0F, 3.0F, 10.0F, 0.0F, false);

        tail1_r1 = new ModelRenderer(this);
        tail1_r1.setRotationPoint(2.0F, -23.0F, 25.0F);
        tail.addChild(tail1_r1);
        setRotationAngle(tail1_r1, -0.1745F, 0.0436F, 0.0F);
        tail1_r1.setTextureOffset(0, 0).addBox(-4.5F, -5.0F, 0.0F, 5.0F, 5.0F, 8.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg0.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        neck.render(matrixStack, buffer, packedLight, packedOverlay);
        leg0.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }



}
