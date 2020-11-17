package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.BeardedDragonEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BeardedDragonModel<T extends BeardedDragonEntity> extends EntityModel<T> {
    private final ModelRenderer head;
    private final ModelRenderer head_r1;
    private final ModelRenderer mouth;
    private final ModelRenderer mouth_bottom;
    private final ModelRenderer mouth2_top_r1;
    private final ModelRenderer mouth_r1;
    private final ModelRenderer mouth_top;
    private final ModelRenderer mouth2_r1;
    private final ModelRenderer mouth_top_r1;
    private final ModelRenderer body;
    private final ModelRenderer tail;
    private final ModelRenderer cube_r1;
    private final ModelRenderer front_left_leg;
    private final ModelRenderer foot_r1;
    private final ModelRenderer two_r1;
    private final ModelRenderer front_right_leg;
    private final ModelRenderer foot_r2;
    private final ModelRenderer two_r2;
    private final ModelRenderer back_left_leg;
    private final ModelRenderer foot_r3;
    private final ModelRenderer two_r3;
    private final ModelRenderer back_right_leg;
    private final ModelRenderer foot_r4;
    private final ModelRenderer two_r4;

    public BeardedDragonModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(-0.84F, 20.083F, -6.1317F);


        head_r1 = new ModelRenderer(this);
        head_r1.setRotationPoint(0.03F, -0.637F, -1.2117F);
        head.addChild(head_r1);
        setRotationAngle(head_r1, -0.1745F, 0.0F, 0.0F);
        head_r1.setTextureOffset(13, 21).addBox(-2.57F, -1.38F, -1.62F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        mouth = new ModelRenderer(this);
        mouth.setRotationPoint(0.84F, 3.917F, 6.1317F);
        head.addChild(mouth);


        mouth_bottom = new ModelRenderer(this);
        mouth_bottom.setRotationPoint(-0.94F, -3.5182F, -9.3337F);
        mouth.addChild(mouth_bottom);
        //setRotationAngle(mouth_bottom, 0.1745F, 0.0F, 0.0F);


        mouth2_top_r1 = new ModelRenderer(this);
        mouth2_top_r1.setRotationPoint(0.94F, -0.2308F, -2.4832F);
        mouth_bottom.addChild(mouth2_top_r1);
        setRotationAngle(mouth2_top_r1, -0.2094F, 0.0F, 0.0F);
        mouth2_top_r1.setTextureOffset(18, 27).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        mouth_r1 = new ModelRenderer(this);
        mouth_r1.setRotationPoint(0.44F, 0.3292F, -0.1032F);
        mouth_bottom.addChild(mouth_r1);
        setRotationAngle(mouth_r1, -0.2182F, 0.0F, 0.0F);
        mouth_r1.setTextureOffset(29, 23).addBox(-2.38F, -0.9964F, -1.6475F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        mouth_top = new ModelRenderer(this);
        mouth_top.setRotationPoint(-0.75F, -4.5F, -9.0F);
        mouth.addChild(mouth_top);


        mouth2_r1 = new ModelRenderer(this);
        mouth2_r1.setRotationPoint(0.75F, -0.3F, -2.7F);
        mouth_top.addChild(mouth2_r1);
        setRotationAngle(mouth2_r1, -0.2094F, 0.0F, 0.0F);
        mouth2_r1.setTextureOffset(8, 32).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);

        mouth_top_r1 = new ModelRenderer(this);
        mouth_top_r1.setRotationPoint(0.25F, 0.26F, -0.32F);
        mouth_top.addChild(mouth_top_r1);
        setRotationAngle(mouth_top_r1, -0.2182F, 0.0F, 0.0F);
        mouth_top_r1.setTextureOffset(26, 15).addBox(-2.38F, -0.9964F, -1.6475F, 4.0F, 1.0F, 2.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-4.76F, -4.62F, -3.24F, 8.0F, 3.0F, 8.0F, 0.0F, false);
        body.setTextureOffset(0, 18).addBox(-3.38F, -4.62F, -6.18F, 5.0F, 3.0F, 3.0F, 0.0F, false);
        body.setTextureOffset(13, 15).addBox(-3.38F, -4.62F, 4.66F, 5.0F, 3.0F, 3.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-1.3F, 24.0F, 7.0F);
        setRotationAngle(tail, 0.0F, 0.2182F, 0.0F);
        tail.setTextureOffset(0, 11).addBox(-1.1F, -4.12F, 0.5F, 3.0F, 2.0F, 5.0F, 0.0F, false);

        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.2F, -3.0F, 5.4F);
        tail.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, 0.3491F, 0.0F);
        cube_r1.setTextureOffset(0, 24).addBox(-0.8F, -1.0F, 0.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);

        front_left_leg = new ModelRenderer(this);
        front_left_leg.setRotationPoint(1.6F, 21.25F, -3.75F);
        front_left_leg.setTextureOffset(25, 11).addBox(-1.578F, -0.951F, -1.11F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        foot_r1 = new ModelRenderer(this);
        foot_r1.setRotationPoint(3.765F, 1.035F, -2.216F);
        front_left_leg.addChild(foot_r1);
        setRotationAngle(foot_r1, 0.0F, -0.3491F, 0.0F);
        foot_r1.setTextureOffset(28, 31).addBox(-0.9341F, -0.38F, -1.5223F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        two_r1 = new ModelRenderer(this);
        two_r1.setRotationPoint(2.007F, -0.061F, -0.51F);
        front_left_leg.addChild(two_r1);
        setRotationAngle(two_r1, 0.5236F, -0.6545F, 0.0F);
        two_r1.setTextureOffset(18, 29).addBox(-0.597F, -1.2885F, -2.9205F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        front_right_leg = new ModelRenderer(this);
        front_right_leg.setRotationPoint(-3.5F, 21.25F, -4.0F);
        front_right_leg.setTextureOffset(24, 4).addBox(-3.12F, -0.87F, -0.86F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        foot_r2 = new ModelRenderer(this);
        foot_r2.setRotationPoint(-4.0652F, 1.94F, -3.2162F);
        front_right_leg.addChild(foot_r2);
        setRotationAngle(foot_r2, 0.0F, 0.3491F, 0.0F);
        foot_r2.setTextureOffset(0, 30).addBox(-1.19F, -1.19F, -0.81F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        two_r2 = new ModelRenderer(this);
        two_r2.setRotationPoint(-2.9477F, 0.635F, -1.3783F);
        front_right_leg.addChild(two_r2);
        setRotationAngle(two_r2, 0.3927F, 0.5236F, 0.0F);
        two_r2.setTextureOffset(11, 27).addBox(-1.19F, -1.19F, -1.62F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        back_left_leg = new ModelRenderer(this);
        back_left_leg.setRotationPoint(-3.5F, 21.25F, 6.0F);
        back_left_leg.setTextureOffset(24, 0).addBox(3.522F, -0.951F, -1.34F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        foot_r3 = new ModelRenderer(this);
        foot_r3.setRotationPoint(-4.8752F, 1.94F, 1.5258F);
        back_left_leg.addChild(foot_r3);
        setRotationAngle(foot_r3, 0.0F, 0.7418F, 0.0F);
        foot_r3.setTextureOffset(0, 4).addBox(-1.19F, -1.19F, -0.81F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        two_r3 = new ModelRenderer(this);
        two_r3.setRotationPoint(-2.251F, 0.239F, 0.156F);
        back_left_leg.addChild(two_r3);
        setRotationAngle(two_r3, 0.4451F, 2.2253F, 0.0F);
        two_r3.setTextureOffset(26, 18).addBox(-0.597F, -1.2885F, -2.9205F, 2.0F, 2.0F, 3.0F, 0.0F, false);

        back_right_leg = new ModelRenderer(this);
        back_right_leg.setRotationPoint(1.75F, 21.25F, 5.5F);
        back_right_leg.setTextureOffset(11, 11).addBox(-8.208F, -0.951F, -0.64F, 5.0F, 2.0F, 2.0F, 0.0F, false);

        foot_r4 = new ModelRenderer(this);
        foot_r4.setRotationPoint(5.5888F, 1.94F, 1.4258F);
        back_right_leg.addChild(foot_r4);
        setRotationAngle(foot_r4, 0.0F, 0.9163F, 0.0F);
        foot_r4.setTextureOffset(0, 0).addBox(-1.19F, -1.19F, -0.81F, 2.0F, 2.0F, 2.0F, 0.0F, false);

        two_r4 = new ModelRenderer(this);
        two_r4.setRotationPoint(3.353F, 0.239F, -0.416F);
        back_right_leg.addChild(two_r4);
        setRotationAngle(two_r4, 0.4451F, -2.1817F, 0.0F);
        two_r4.setTextureOffset(26, 26).addBox(-0.597F, -1.2885F, -2.9205F, 2.0F, 2.0F, 3.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
        front_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        front_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        back_left_leg.render(matrixStack, buffer, packedLight, packedOverlay);
        back_right_leg.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}