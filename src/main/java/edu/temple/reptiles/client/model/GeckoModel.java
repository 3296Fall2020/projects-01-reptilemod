package edu.temple.reptiles.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.GeckoEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;


@OnlyIn(Dist.CLIENT)
public class GeckoModel extends SegmentedModel<GeckoEntity> {
    private final ModelRenderer head;
    private final ModelRenderer body;
    private final ModelRenderer rightBackLeg;
    private final ModelRenderer right_back_leg_r1;
    private final ModelRenderer leftBackLeg;
    private final ModelRenderer left_back_leg_r1;
    private final ModelRenderer rightFrontLeg;
    private final ModelRenderer right_front_leg_r1;
    private final ModelRenderer leftFrontLeg;
    private final ModelRenderer left_front_leg_r1;
    private final ModelRenderer tail;

    public GeckoModel(){
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this);
        head.setRotationPoint(-0.9F, 22.5F, -6.4F);
        head.setTextureOffset(0, 11).addBox(-2.0F, -1.5F, -1.5F, 4.0F, 3.0F, 3.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(-1.0F, 23.0F, -1.5F);
        body.setTextureOffset(2, 0).addBox(-1.5F, -1.0F, -4.5F, 3.0F, 2.0F, 9.0F, 0.0F, false);

        rightBackLeg = new ModelRenderer(this);
        rightBackLeg.setRotationPoint(-2.1F, 23.6172F, 2.544F);


        right_back_leg_r1 = new ModelRenderer(this);
        right_back_leg_r1.setRotationPoint(0.0F, 0.0F, -1.0F);
        rightBackLeg.addChild(right_back_leg_r1);
        setRotationAngle(right_back_leg_r1, 1.5708F, 0.6545F, -1.5708F);
        right_back_leg_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        leftBackLeg = new ModelRenderer(this);
        leftBackLeg.setRotationPoint(-0.3887F, 23.6164F, 2.5753F);


        left_back_leg_r1 = new ModelRenderer(this);
        left_back_leg_r1.setRotationPoint(0.2887F, 0.0637F, -0.9972F);
        leftBackLeg.addChild(left_back_leg_r1);
        setRotationAngle(left_back_leg_r1, -1.6144F, -0.48F, -1.6144F);
        left_back_leg_r1.setTextureOffset(0, 0).addBox(-0.7887F, -0.5637F, -0.0028F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        rightFrontLeg = new ModelRenderer(this);
        rightFrontLeg.setRotationPoint(-2.3237F, 24.004F, -1.8513F);


        right_front_leg_r1 = new ModelRenderer(this);
        right_front_leg_r1.setRotationPoint(0.25F, -0.4617F, -0.887F);
        rightFrontLeg.addChild(right_front_leg_r1);
        setRotationAngle(right_front_leg_r1, 2.0508F, -0.3491F, -1.5708F);
        right_front_leg_r1.setTextureOffset(0, 0).addBox(-0.75F, -0.0383F, -0.113F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        leftFrontLeg = new ModelRenderer(this);
        leftFrontLeg.setRotationPoint(0.0037F, 23.0173F, -2.0F);


        left_front_leg_r1 = new ModelRenderer(this);
        left_front_leg_r1.setRotationPoint(0.0F, 0.3827F, -0.9239F);
        leftFrontLeg.addChild(left_front_leg_r1);
        setRotationAngle(left_front_leg_r1, -1.9635F, -0.5236F, -1.5708F);
        left_front_leg_r1.setTextureOffset(0, 0).addBox(-0.5F, -0.8827F, -0.0761F, 1.0F, 1.0F, 2.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-1.0F, 23.5F, 5.5F);
        tail.setTextureOffset(11, 13).addBox(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(GeckoEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleX = headPitch * 0.000453292F;
        this.head.rotateAngleY = netHeadYaw * 0.000453292F;
        this.rightFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.09F) * limbSwingAmount;
        this.leftFrontLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.09F + (float)Math.PI) * limbSwingAmount;
        this.rightBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.09F + (float)Math.PI) *  limbSwingAmount;
        this.leftBackLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.09F) * limbSwingAmount;
        this.tail.rotateAngleX = headPitch * 0.5F * 0.007453292F;
    }




    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.body,  this.leftFrontLeg, this. rightFrontLeg, this.tail, this.head, this.leftBackLeg, this.rightBackLeg);
    }
    public void setLivingAnimations(GeckoEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        this.setLivingAnimations(getGeckoState(entityIn));
    }


    public void renderOnShoulder(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float p_228284_5_, float p_228284_6_, float p_228284_7_, float p_228284_8_, int p_228284_9_) {
        this.setLivingAnimations(GeckoModel.State.ON_SHOULDER);
        this.setRotationAngles(GeckoModel.State.ON_SHOULDER, p_228284_9_, p_228284_5_, p_228284_6_, 0.0F, p_228284_7_, p_228284_8_);
        this.getParts().forEach((p_228285_4_) -> {
            p_228285_4_.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        });
    }




   private void setRotationAngles(GeckoModel.State p_217162_1_, int p_217162_2_, float p_217162_3_, float p_217162_4_, float p_217162_5_, float p_217162_6_, float p_217162_7_) {

        this.head.rotateAngleX = p_217162_7_ * 0.000453292F;
        this.head.rotateAngleY = p_217162_6_ * 0.000453292F;
       this.rightFrontLeg.rotateAngleX =  MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
       this.leftFrontLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
       this.rightBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
       this.leftBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
       this.tail.rotateAngleX = p_217162_7_  * 0.5F * 0.007453292F;
       switch (p_217162_1_) {
            case SITTING:
                break;
            case PARTY:
                this.head.rotateAngleX = p_217162_7_ * 0.000453292F;
                this.head.rotateAngleY = p_217162_6_ * 0.000453292F;
                this.rightFrontLeg.rotateAngleX =  MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.leftFrontLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.rightBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.leftBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.tail.rotateAngleX = p_217162_7_  * 0.5F * 0.007453292F;

                break;
            case STANDING:
                this.leftBackLeg.rotateAngleX += MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.rightBackLeg.rotateAngleX += MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
            case ON_SHOULDER:

            default:
                this.head.rotateAngleX = p_217162_7_ * 0.000453292F;
                this.head.rotateAngleY = p_217162_6_ * 0.000453292F;
                this.rightFrontLeg.rotateAngleX =  MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.leftFrontLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.rightBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.leftBackLeg.rotateAngleX = MathHelper.cos(p_217162_2_ * 0.09F) * p_217162_3_;
                this.tail.rotateAngleX = p_217162_7_  * 0.5F * 0.007453292F;
        }
    }





    private void setLivingAnimations(GeckoModel.State p_217160_1_) {
        this.leftFrontLeg.rotateAngleX = -2F;
        this.leftFrontLeg.rotateAngleY = -(float)Math.PI;
        this.rightFrontLeg.rotateAngleX = -2F;
        this.rightFrontLeg.rotateAngleY = -(float)Math.PI;
        this.leftBackLeg.rotateAngleX = -0.0299F;
        switch(p_217160_1_) {
            case SITTING:
                float f = 1.9F;
                this.tail.rotateAngleX = 1.5388988F;
                this.leftFrontLeg.rotateAngleZ = -0.0873F;
                this.rightFrontLeg.rotateAngleZ = 0.0873F;
                ++this.leftBackLeg.rotateAngleX;
                ++this.rightBackLeg.rotateAngleX;
                break;
            case PARTY:
                this.leftBackLeg.rotateAngleZ = -0.34906584F;
                this.rightBackLeg.rotateAngleZ = 0.34906584F;
            case STANDING:
            case ON_SHOULDER:
            default:
                break;
        }

    }



    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    private static GeckoModel.State getGeckoState(GeckoEntity p_217158_0_) {
        if (p_217158_0_.isPartying()) {
            return GeckoModel.State.PARTY;
        } else if (p_217158_0_.func_233684_eK_()) {
            return GeckoModel.State.SITTING;
        } else {
            return GeckoModel.State.STANDING;
        }
    }



    @OnlyIn(Dist.CLIENT)
    public static enum State {
        STANDING,
        SITTING,
        PARTY,
        ON_SHOULDER;
    }
}
