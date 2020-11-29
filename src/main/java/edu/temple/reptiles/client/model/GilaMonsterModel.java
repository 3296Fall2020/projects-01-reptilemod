// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package edu.temple.reptiles.client.model;

import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.GilaMonsterEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class GilaMonsterModel extends AnimatedEntityModel<GilaMonsterEntity> {

    private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer legFrontRight;
	private final AnimatedModelRenderer bone;
	private final AnimatedModelRenderer bone2;
	private final AnimatedModelRenderer legFrontLeft;
	private final AnimatedModelRenderer bone7;
	private final AnimatedModelRenderer bone8;
	private final AnimatedModelRenderer legBackRight;
	private final AnimatedModelRenderer bone3;
	private final AnimatedModelRenderer bone4;
	private final AnimatedModelRenderer legBackLeft;
	private final AnimatedModelRenderer bone5;
	private final AnimatedModelRenderer bone6;
	private final AnimatedModelRenderer tail;

    public GilaMonsterModel()
    {
        textureWidth = 32;
    	textureHeight = 32;
    	head = new AnimatedModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(14, 0).addBox(-2.0F, -2.6F, -5.65F, 3.0F, 2.0F, 2.0F, -0.1F, false);
		head.setTextureOffset(0, 16).addBox(-2.0F, -1.775F, -7.3F, 3.0F, 1.0F, 2.0F, -0.25F, false);
		head.setTextureOffset(14, 4).addBox(-2.0F, -2.325F, -7.35F, 3.0F, 1.0F, 2.0F, -0.2F, false);
		head.setTextureOffset(20, 14).addBox(-1.475F, -1.775F, -7.8F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		head.setTextureOffset(18, 19).addBox(-1.475F, -2.275F, -7.875F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		head.setTextureOffset(10, 10).addBox(-0.075F, -2.775F, -6.25F, 1.0F, 1.0F, 1.0F, -0.3F, false);
		head.setTextureOffset(4, 3).addBox(-1.875F, -2.775F, -6.25F, 1.0F, 1.0F, 1.0F, -0.3F, false);
		head.setTextureOffset(0, 0).addBox(-1.475F, -2.775F, -7.225F, 2.0F, 1.0F, 2.0F, -0.3F, false);
		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-2.0F, -2.5F, -4.0F, 3.0F, 2.0F, 8.0F, -0.2F, false);
		body.setTextureOffset(10, 10).addBox(-2.5F, -2.4F, -2.15F, 1.0F, 2.0F, 4.0F, -0.3F, false);
		body.setTextureOffset(0, 10).addBox(0.5F, -2.4F, -2.15F, 1.0F, 2.0F, 4.0F, -0.3F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		legFrontRight = new AnimatedModelRenderer(this);
		legFrontRight.setRotationPoint(-1.8125F, 22.7625F, -2.725F);
		legFrontRight.setTextureOffset(12, 21).addBox(-0.9875F, -0.4875F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		legFrontRight.setModelRendererName("legFrontRight");
		this.registerModelRenderer(legFrontRight);

		bone = new AnimatedModelRenderer(this);
		bone.setRotationPoint(-0.475F, -0.225F, 0.0F);
		legFrontRight.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, 0.9599F);
		bone.setTextureOffset(8, 21).addBox(-0.4029F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);
		bone.setModelRendererName("bone");
		this.registerModelRenderer(bone);

		bone2 = new AnimatedModelRenderer(this);
		bone2.setRotationPoint(0.1623F, 1.0966F, -0.025F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.1484F, 0.0F, 0.6109F);
		bone2.setTextureOffset(16, 16).addBox(-0.1424F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);
		bone2.setModelRendererName("bone2");
		this.registerModelRenderer(bone2);

		legFrontLeft = new AnimatedModelRenderer(this);
		legFrontLeft.setRotationPoint(0.8F, 22.7875F, -2.7125F);
		legFrontLeft.setTextureOffset(14, 16).addBox(0.0F, -0.5125F, -0.5125F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		legFrontLeft.setModelRendererName("legFrontLeft");
		this.registerModelRenderer(legFrontLeft);

		bone7 = new AnimatedModelRenderer(this);
		bone7.setRotationPoint(0.5375F, -0.25F, 5.3625F);
		legFrontLeft.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.0F, -0.9599F);
		bone7.setTextureOffset(0, 10).addBox(-0.5971F, -0.1007F, -5.875F, 1.0F, 2.0F, 1.0F, -0.11F, false);
		bone7.setModelRendererName("bone7");
		this.registerModelRenderer(bone7);

		bone8 = new AnimatedModelRenderer(this);
		bone8.setRotationPoint(-0.1623F, 1.0966F, -0.025F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.1484F, 0.0F, -0.6109F);
		bone8.setTextureOffset(0, 3).addBox(-0.8576F, -0.761F, -6.691F, 1.0F, 1.0F, 2.0F, -0.15F, false);
		bone8.setModelRendererName("bone8");
		this.registerModelRenderer(bone8);

		legBackRight = new AnimatedModelRenderer(this);
		legBackRight.setRotationPoint(-1.8F, 22.6875F, 2.65F);
		legBackRight.setTextureOffset(20, 16).addBox(-1.0F, -0.4125F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		legBackRight.setModelRendererName("legBackRight");
		this.registerModelRenderer(legBackRight);

		bone3 = new AnimatedModelRenderer(this);
		bone3.setRotationPoint(-0.4875F, -0.15F, 0.0F);
		legBackRight.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.9599F);
		bone3.setTextureOffset(4, 21).addBox(-0.4029F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);
		bone3.setModelRendererName("bone3");
		this.registerModelRenderer(bone3);

		bone4 = new AnimatedModelRenderer(this);
		bone4.setRotationPoint(0.1623F, 1.0966F, -0.025F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.1484F, 0.0F, 0.6109F);
		bone4.setTextureOffset(10, 16).addBox(-0.1424F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);
		bone4.setModelRendererName("bone4");
		this.registerModelRenderer(bone4);

		legBackLeft = new AnimatedModelRenderer(this);
		legBackLeft.setRotationPoint(0.8F, 22.7375F, 2.675F);
		legBackLeft.setTextureOffset(8, 16).addBox(0.0F, -0.4625F, -0.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		legBackLeft.setModelRendererName("legBackLeft");
		this.registerModelRenderer(legBackLeft);

		bone5 = new AnimatedModelRenderer(this);
		bone5.setRotationPoint(0.5375F, -0.2F, -0.025F);
		legBackLeft.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.9599F);
		bone5.setTextureOffset(0, 21).addBox(-0.5971F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);
		bone5.setModelRendererName("bone5");
		this.registerModelRenderer(bone5);

		bone6 = new AnimatedModelRenderer(this);
		bone6.setRotationPoint(-0.1623F, 1.0966F, -0.025F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.1484F, 0.0F, -0.6109F);
		bone6.setTextureOffset(6, 10).addBox(-0.8576F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);
		bone6.setModelRendererName("bone6");
		this.registerModelRenderer(bone6);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(-0.5F, 22.5F, 3.8667F);
		tail.setTextureOffset(12, 19).addBox(-1.0F, -0.5F, -0.1417F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		tail.setTextureOffset(6, 19).addBox(-1.0F, -0.5F, 0.7083F, 2.0F, 1.0F, 1.0F, -0.1F, false);
		tail.setTextureOffset(0, 19).addBox(-1.0F, -0.5F, 1.3833F, 2.0F, 1.0F, 1.0F, -0.2F, false);
		tail.setTextureOffset(16, 12).addBox(-1.0F, -0.5F, 1.9333F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		tail.setTextureOffset(16, 10).addBox(-1.0F, -0.5F, 2.3833F, 2.0F, 1.0F, 1.0F, -0.3F, false);
		tail.setTextureOffset(0, 6).addBox(-1.0F, -0.5F, 2.7333F, 2.0F, 1.0F, 1.0F, -0.35F, false);
		tail.setModelRendererName("tail");
		this.registerModelRenderer(tail);

    this.rootBones.add(head);
		this.rootBones.add(body);
		this.rootBones.add(legFrontRight);
		this.rootBones.add(legFrontLeft);
		this.rootBones.add(legBackRight);
		this.rootBones.add(legBackLeft);
		this.rootBones.add(tail);
  }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation(Reptiles.MOD_ID, "animations/gila_monster.json");
    }
}