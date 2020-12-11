// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.12.2 or 1.15.2 (same format for both) for entity models animated with GeckoLib
// Paste this class into your mod and follow the documentation for GeckoLib to use animations. You can find the documentation here: https://github.com/bernie-g/geckolib
// Blockbench plugin created by Gecko
package edu.temple.reptiles.client.model;

import edu.temple.reptiles.entities.BeardedDragonEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class BeardedDragonModel<T extends BeardedDragonEntity> extends AnimatedEntityModel<T>{

	private final AnimatedModelRenderer head;
	private final AnimatedModelRenderer head_r1;
	private final AnimatedModelRenderer mouth;
	private final AnimatedModelRenderer mouth_bottom;
	private final AnimatedModelRenderer mouth2_top_r1;
	private final AnimatedModelRenderer mouth_r1;
	private final AnimatedModelRenderer mouth_top;
	private final AnimatedModelRenderer mouth2_r1;
	private final AnimatedModelRenderer mouth_top_r1;
	private final AnimatedModelRenderer body;
	private final AnimatedModelRenderer tail;
	private final AnimatedModelRenderer cube_r1;
	private final AnimatedModelRenderer Front_Left;
	private final AnimatedModelRenderer Front_Right;
	private final AnimatedModelRenderer Back_Left;
	private final AnimatedModelRenderer Back_Right;

	public BeardedDragonModel()
	{
		textureWidth = 64;
		textureHeight = 64;
		head = new AnimatedModelRenderer(this);
		head.setRotationPoint(-0.64F, 20.083F, -6.1317F);

		head.setModelRendererName("head");
		this.registerModelRenderer(head);

		head_r1 = new AnimatedModelRenderer(this);
		head_r1.setRotationPoint(0.03F, -0.637F, -1.2117F);
		head.addChild(head_r1);
		setRotationAngle(head_r1, -0.1745F, 0.0F, 0.0F);
		head_r1.setTextureOffset(32, 11).addBox(-2.57F, -1.38F, -1.62F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		head_r1.setModelRendererName("head_r1");
		this.registerModelRenderer(head_r1);

		mouth = new AnimatedModelRenderer(this);
		mouth.setRotationPoint(0.84F, 3.917F, 6.1317F);
		head.addChild(mouth);

		mouth.setModelRendererName("mouth");
		this.registerModelRenderer(mouth);

		mouth_bottom = new AnimatedModelRenderer(this);
		mouth_bottom.setRotationPoint(-0.94F, -3.5182F, -9.3337F);
		mouth.addChild(mouth_bottom);
		setRotationAngle(mouth_bottom, 0.0436F, 0.0F, 0.0F);

		mouth_bottom.setModelRendererName("mouth_bottom");
		this.registerModelRenderer(mouth_bottom);

		mouth2_top_r1 = new AnimatedModelRenderer(this);
		mouth2_top_r1.setRotationPoint(0.94F, -0.2308F, -2.4832F);
		mouth_bottom.addChild(mouth2_top_r1);
		setRotationAngle(mouth2_top_r1, -0.2094F, 0.0F, 0.0F);
		mouth2_top_r1.setTextureOffset(6, 29).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		mouth2_top_r1.setModelRendererName("mouth2_top_r1");
		this.registerModelRenderer(mouth2_top_r1);

		mouth_r1 = new AnimatedModelRenderer(this);
		mouth_r1.setRotationPoint(0.44F, 0.3292F, -0.1032F);
		mouth_bottom.addChild(mouth_r1);
		setRotationAngle(mouth_r1, -0.2182F, 0.0F, 0.0F);
		mouth_r1.setTextureOffset(14, 20).addBox(-2.38F, -0.9964F, -1.6475F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		mouth_r1.setModelRendererName("mouth_r1");
		this.registerModelRenderer(mouth_r1);

		mouth_top = new AnimatedModelRenderer(this);
		mouth_top.setRotationPoint(-0.75F, -4.5F, -9.0F);
		mouth.addChild(mouth_top);
		setRotationAngle(mouth_top, 0.0436F, 0.0F, 0.0F);

		mouth_top.setModelRendererName("mouth_top");
		this.registerModelRenderer(mouth_top);

		mouth2_r1 = new AnimatedModelRenderer(this);
		mouth2_r1.setRotationPoint(0.75F, -0.3F, -2.7F);
		mouth_top.addChild(mouth2_r1);
		setRotationAngle(mouth2_r1, -0.2094F, 0.0F, 0.0F);
		mouth2_r1.setTextureOffset(0, 29).addBox(-2.0F, -1.0F, 0.0F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		mouth2_r1.setModelRendererName("mouth2_r1");
		this.registerModelRenderer(mouth2_r1);

		mouth_top_r1 = new AnimatedModelRenderer(this);
		mouth_top_r1.setRotationPoint(0.25F, 0.26F, -0.32F);
		mouth_top.addChild(mouth_top_r1);
		setRotationAngle(mouth_top_r1, -0.2182F, 0.0F, 0.0F);
		mouth_top_r1.setTextureOffset(14, 17).addBox(-2.38F, -0.9964F, -1.6475F, 4.0F, 1.0F, 2.0F, 0.0F, false);
		mouth_top_r1.setModelRendererName("mouth_top_r1");
		this.registerModelRenderer(mouth_top_r1);

		body = new AnimatedModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-4.76F, -4.62F, -3.24F, 8.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(16, 11).addBox(-3.18F, -4.62F, -6.18F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 11).addBox(-3.38F, -4.62F, 4.66F, 5.0F, 3.0F, 3.0F, 0.0F, false);
		body.setModelRendererName("body");
		this.registerModelRenderer(body);

		tail = new AnimatedModelRenderer(this);
		tail.setRotationPoint(-1.3F, 21.0F, 7.5F);
		setRotationAngle(tail, 0.0F, 0.2182F, 0.0F);
		tail.setTextureOffset(32, 0).addBox(-0.9918F, -1.12F, 0.0119F, 3.0F, 2.0F, 5.0F, 0.0F, false);
		tail.setModelRendererName("tail");
		this.registerModelRenderer(tail);

		cube_r1 = new AnimatedModelRenderer(this);
		cube_r1.setRotationPoint(0.3082F, 0.0F, 4.9119F);
		tail.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.3491F, 0.0F);
		cube_r1.setTextureOffset(0, 17).addBox(-0.8F, -1.0F, 0.0F, 2.0F, 1.0F, 5.0F, 0.0F, false);
		cube_r1.setModelRendererName("cube_r1");
		this.registerModelRenderer(cube_r1);

		Front_Left = new AnimatedModelRenderer(this);
		Front_Left.setRotationPoint(2.3F, 20.9F, -4.1F);
		Front_Left.setTextureOffset(24, 23).addBox(-1.1F, -0.9F, -1.1F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		Front_Left.setModelRendererName("Front_Left");
		this.registerModelRenderer(Front_Left);

		Front_Right = new AnimatedModelRenderer(this);
		Front_Right.setRotationPoint(-4.0F, 21.0F, -4.1F);
		Front_Right.setTextureOffset(16, 23).addBox(-0.6F, -1.0F, -1.1F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		Front_Right.setModelRendererName("Front_Right");
		this.registerModelRenderer(Front_Right);

		Back_Left = new AnimatedModelRenderer(this);
		Back_Left.setRotationPoint(2.4F, 20.9F, 5.8F);
		Back_Left.setTextureOffset(8, 23).addBox(-1.2F, -0.9F, -1.1F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		Back_Left.setModelRendererName("Back_Left");
		this.registerModelRenderer(Back_Left);

		Back_Right = new AnimatedModelRenderer(this);
		Back_Right.setRotationPoint(-4.1F, 20.9F, 5.7F);
		Back_Right.setTextureOffset(0, 23).addBox(-0.7F, -0.9F, -1.0F, 2.0F, 4.0F, 2.0F, 0.0F, false);
		Back_Right.setModelRendererName("Back_Right");
		this.registerModelRenderer(Back_Right);

		this.rootBones.add(head);
		this.rootBones.add(body);
		this.rootBones.add(tail);
		this.rootBones.add(Front_Left);
		this.rootBones.add(Front_Right);
		this.rootBones.add(Back_Left);
		this.rootBones.add(Back_Right);
	}


	@Override
	public ResourceLocation getAnimationFileLocation()
	{
		return new ResourceLocation("reptiles", "animations/bearded_dragon_model.json");
	}
}