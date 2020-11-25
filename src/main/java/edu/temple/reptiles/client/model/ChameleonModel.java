package edu.temple.reptiles.client.model;


import net.minecraft.client.renderer.entity.model.EntityModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;
import edu.temple.reptiles.entities.ChameleonEntity;

public class ChameleonModel extends AnimatedEntityModel<ChameleonEntity> {

    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer leftEye;
    private final AnimatedModelRenderer rightEye;
    private final AnimatedModelRenderer tail;
    private final AnimatedModelRenderer legLeftFront;
    private final AnimatedModelRenderer legtRightFront;
    private final AnimatedModelRenderer legLeftBack;
    private final AnimatedModelRenderer legRightBack;

    public ChameleonModel()
    {
        textureWidth = 16;
        textureHeight = 16;
        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 22.5F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.0F, -1.5F, -3.0F, 4.0F, 2.0F, 6.0F, 0.0F, false);
        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, 0.0F, -2.0F);
        body.addChild(head);
        head.setTextureOffset(0, 0).addBox(-1.5F, -2.0F, -3.0F, 3.0F, 2.0F, 3.0F, 0.0F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        leftEye = new AnimatedModelRenderer(this);
        leftEye.setRotationPoint(0.0F, -1.0F, -1.8F);
        head.addChild(leftEye);
        setRotationAngle(leftEye, 0.0F, -0.1745F, 0.0F);
        leftEye.setTextureOffset(0, 0).addBox(-2.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        leftEye.setModelRendererName("leftEye");
        this.registerModelRenderer(leftEye);

        rightEye = new AnimatedModelRenderer(this);
        rightEye.setRotationPoint(0.0F, -1.0F, -1.8F);
        head.addChild(rightEye);
        setRotationAngle(rightEye, 0.0F, 0.1745F, 0.0F);
        rightEye.setTextureOffset(0, 0).addBox(1.0F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
        rightEye.setModelRendererName("rightEye");
        this.registerModelRenderer(rightEye);

        tail = new AnimatedModelRenderer(this);
        tail.setRotationPoint(0.0F, 0.5F, 2.5F);
        body.addChild(tail);
        tail.setTextureOffset(0, 0).addBox(-1.0F, -2.5F, 0.0F, 2.0F, 3.0F, 3.0F, 0.0F, false);
        tail.setModelRendererName("tail");
        this.registerModelRenderer(tail);

        legLeftFront = new AnimatedModelRenderer(this);
        legLeftFront.setRotationPoint(-1.5F, 0.15F, -2.0F);
        body.addChild(legLeftFront);
        setRotationAngle(legLeftFront, 0.0F, 0.0F, -0.4363F);
        legLeftFront.setTextureOffset(0, 0).addBox(-2.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        legLeftFront.setModelRendererName("legLeftFront");
        this.registerModelRenderer(legLeftFront);

        legtRightFront = new AnimatedModelRenderer(this);
        legtRightFront.setRotationPoint(1.5F, 0.15F, -2.0F);
        body.addChild(legtRightFront);
        setRotationAngle(legtRightFront, 0.0F, 0.0F, 0.4363F);
        legtRightFront.setTextureOffset(0, 0).addBox(0.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
        legtRightFront.setModelRendererName("legtRightFront");
        this.registerModelRenderer(legtRightFront);

        legLeftBack = new AnimatedModelRenderer(this);
        legLeftBack.setRotationPoint(-1.5F, 0.15F, 0.8F);
        body.addChild(legLeftBack);
        setRotationAngle(legLeftBack, 0.0F, 0.0F, -0.4363F);
        legLeftBack.setTextureOffset(0, 0).addBox(-2.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
        legLeftBack.setModelRendererName("legLeftBack");
        this.registerModelRenderer(legLeftBack);

        legRightBack = new AnimatedModelRenderer(this);
        legRightBack.setRotationPoint(1.5F, 0.15F, 0.8F);
        body.addChild(legRightBack);
        setRotationAngle(legRightBack, 0.0F, 0.0F, 0.4363F);
        legRightBack.setTextureOffset(0, 0).addBox(0.3F, -0.65F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, true);
        legRightBack.setModelRendererName("legRightBack");
        this.registerModelRenderer(legRightBack);

        this.rootBones.add(body);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation("reptiles", "animations/chameleon.json");
    }
}
