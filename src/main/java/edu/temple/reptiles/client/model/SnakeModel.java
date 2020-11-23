package edu.temple.reptiles.client.model;


import edu.temple.reptiles.Reptiles;
import edu.temple.reptiles.entities.SnakeEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib.animation.model.AnimatedEntityModel;
import software.bernie.geckolib.animation.render.AnimatedModelRenderer;

public class SnakeModel extends AnimatedEntityModel<SnakeEntity> {

    private final AnimatedModelRenderer head;
    private final AnimatedModelRenderer body;
    private final AnimatedModelRenderer bone;
    private final AnimatedModelRenderer bone2;
    private final AnimatedModelRenderer bone3;
    private final AnimatedModelRenderer bone4;
    private final AnimatedModelRenderer bone5;
    private final AnimatedModelRenderer bone6;
    private final AnimatedModelRenderer bone7;
    private final AnimatedModelRenderer bone8;
    private final AnimatedModelRenderer bone9;
    private final AnimatedModelRenderer bone10;
    private final AnimatedModelRenderer bone11;
    private final AnimatedModelRenderer bone12;
    private final AnimatedModelRenderer bone13;
    private final AnimatedModelRenderer bone14;
    private final AnimatedModelRenderer bone15;
    private final AnimatedModelRenderer bone16;
    private final AnimatedModelRenderer bone17;
    private final AnimatedModelRenderer bone18;
    private final AnimatedModelRenderer bone19;
    private final AnimatedModelRenderer bone20;
    private final AnimatedModelRenderer bone21;
    private final AnimatedModelRenderer bone22;
    private final AnimatedModelRenderer bone23;
    private final AnimatedModelRenderer bone24;
    private final AnimatedModelRenderer bone25;
    private final AnimatedModelRenderer bone26;

    public SnakeModel()
    {
        textureWidth = 32;
        textureHeight = 32;
        head = new AnimatedModelRenderer(this);
        head.setRotationPoint(0.0F, 23.4937F, -6.775F);
        head.setTextureOffset(0, 3).addBox(-1.0F, -0.7188F, 0.1F, 2.0F, 1.0F, 1.0F, -0.1F, false);
        head.setTextureOffset(16, 0).addBox(-1.0F, -0.2687F, -0.7F, 2.0F, 1.0F, 2.0F, -0.36F, false);
        head.setTextureOffset(8, 0).addBox(-1.0F, -0.6938F, -1.475F, 2.0F, 1.0F, 2.0F, -0.3F, false);
        head.setTextureOffset(0, 0).addBox(-1.0F, -0.3188F, -1.425F, 2.0F, 1.0F, 2.0F, -0.35F, false);
        head.setTextureOffset(10, 3).addBox(-0.9F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        head.setTextureOffset(6, 3).addBox(-0.1F, -1.0F, -0.5F, 1.0F, 1.0F, 1.0F, -0.3F, false);
        head.setModelRendererName("head");
        this.registerModelRenderer(head);

        body = new AnimatedModelRenderer(this);
        body.setRotationPoint(0.0F, 24.0F, 0.0F);

        body.setModelRendererName("body");
        this.registerModelRenderer(body);

        bone = new AnimatedModelRenderer(this);
        bone.setRotationPoint(0.1F, -0.5F, -5.9F);
        body.addChild(bone);
        setRotationAngle(bone, 0.0F, 0.2356F, 0.0F);
        bone.setTextureOffset(12, 13).addBox(-0.5649F, -0.5F, -0.2071F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone.setModelRendererName("bone");
        this.registerModelRenderer(bone);

        bone2 = new AnimatedModelRenderer(this);
        bone2.setRotationPoint(0.4803F, -0.5F, -4.8719F);
        body.addChild(bone2);
        setRotationAngle(bone2, 0.0F, 0.6545F, 0.0F);
        bone2.setTextureOffset(8, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone2.setModelRendererName("bone2");
        this.registerModelRenderer(bone2);

        bone3 = new AnimatedModelRenderer(this);
        bone3.setRotationPoint(1.0251F, -0.5F, -4.3506F);
        body.addChild(bone3);
        setRotationAngle(bone3, 0.0F, 1.0036F, 0.0F);
        bone3.setTextureOffset(4, 13).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone3.setModelRendererName("bone3");
        this.registerModelRenderer(bone3);

        bone4 = new AnimatedModelRenderer(this);
        bone4.setRotationPoint(1.677F, -0.5F, -3.9678F);
        body.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 1.1432F, 0.0F);
        bone4.setTextureOffset(0, 13).addBox(-0.4585F, -0.5F, -0.409F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone4.setModelRendererName("bone4");
        this.registerModelRenderer(bone4);

        bone5 = new AnimatedModelRenderer(this);
        bone5.setRotationPoint(2.3F, -0.5F, -3.6F);
        body.addChild(bone5);
        setRotationAngle(bone5, 0.0F, 0.9163F, 0.0F);
        bone5.setTextureOffset(16, 11).addBox(-0.4041F, -0.5F, -0.416F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone5.setModelRendererName("bone5");
        this.registerModelRenderer(bone5);

        bone6 = new AnimatedModelRenderer(this);
        bone6.setRotationPoint(2.8F, -0.5F, -3.1F);
        body.addChild(bone6);
        setRotationAngle(bone6, 0.0F, 0.5236F, 0.0F);
        bone6.setTextureOffset(12, 11).addBox(-0.3975F, -0.5F, -0.5275F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone6.setModelRendererName("bone6");
        this.registerModelRenderer(bone6);

        bone7 = new AnimatedModelRenderer(this);
        bone7.setRotationPoint(3.0F, -0.5F, -2.7F);
        body.addChild(bone7);
        setRotationAngle(bone7, 0.0F, 0.2618F, 0.0F);
        bone7.setTextureOffset(8, 11).addBox(-0.456F, -0.5F, -0.3133F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone7.setModelRendererName("bone7");
        this.registerModelRenderer(bone7);

        bone8 = new AnimatedModelRenderer(this);
        bone8.setRotationPoint(3.0F, -0.5F, -2.0F);
        body.addChild(bone8);
        setRotationAngle(bone8, 0.0F, -0.2443F, 0.0F);
        bone8.setTextureOffset(4, 11).addBox(-0.3909F, -0.5F, -0.3726F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone8.setModelRendererName("bone8");
        this.registerModelRenderer(bone8);

        bone9 = new AnimatedModelRenderer(this);
        bone9.setRotationPoint(2.6F, -0.5F, -1.0F);
        body.addChild(bone9);
        setRotationAngle(bone9, 0.0F, -0.6109F, 0.0F);
        bone9.setTextureOffset(0, 11).addBox(-0.5295F, -0.5F, -0.7187F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone9.setModelRendererName("bone9");
        this.registerModelRenderer(bone9);

        bone10 = new AnimatedModelRenderer(this);
        bone10.setRotationPoint(2.2F, -0.5F, -0.8F);
        body.addChild(bone10);
        setRotationAngle(bone10, 0.0F, -0.8727F, 0.0F);
        bone10.setTextureOffset(16, 9).addBox(-0.4073F, -0.5F, -0.4549F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone10.setModelRendererName("bone10");
        this.registerModelRenderer(bone10);

        bone11 = new AnimatedModelRenderer(this);
        bone11.setRotationPoint(1.5F, -0.5F, -0.3F);
        body.addChild(bone11);
        setRotationAngle(bone11, 0.0F, -1.117F, 0.0F);
        bone11.setTextureOffset(12, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone11.setModelRendererName("bone11");
        this.registerModelRenderer(bone11);

        bone12 = new AnimatedModelRenderer(this);
        bone12.setRotationPoint(0.763F, -0.5F, -0.0522F);
        body.addChild(bone12);
        setRotationAngle(bone12, 0.0F, -1.3614F, 0.0F);
        bone12.setTextureOffset(8, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone12.setModelRendererName("bone12");
        this.registerModelRenderer(bone12);

        bone13 = new AnimatedModelRenderer(this);
        bone13.setRotationPoint(-0.1F, -0.5F, 0.125F);
        body.addChild(bone13);
        setRotationAngle(bone13, 0.0F, -1.3701F, 0.0F);
        bone13.setTextureOffset(4, 9).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone13.setModelRendererName("bone13");
        this.registerModelRenderer(bone13);

        bone14 = new AnimatedModelRenderer(this);
        bone14.setRotationPoint(-0.8F, -0.5F, 0.4F);
        body.addChild(bone14);
        setRotationAngle(bone14, 0.0F, -1.1781F, 0.0F);
        bone14.setTextureOffset(0, 9).addBox(-0.5749F, -0.5F, -0.4498F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone14.setModelRendererName("bone14");
        this.registerModelRenderer(bone14);

        bone15 = new AnimatedModelRenderer(this);
        bone15.setRotationPoint(-1.5923F, -0.5F, 0.8473F);
        body.addChild(bone15);
        setRotationAngle(bone15, 0.0F, -1.0036F, 0.0F);
        bone15.setTextureOffset(16, 7).addBox(-0.6189F, -0.5F, -0.5461F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone15.setModelRendererName("bone15");
        this.registerModelRenderer(bone15);

        bone16 = new AnimatedModelRenderer(this);
        bone16.setRotationPoint(-2.3F, -0.5F, 1.5F);
        body.addChild(bone16);
        setRotationAngle(bone16, 0.0F, 0.9599F, 0.0F);
        bone16.setTextureOffset(12, 7).addBox(-0.1565F, -0.5F, -0.5276F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone16.setModelRendererName("bone16");
        this.registerModelRenderer(bone16);

        bone17 = new AnimatedModelRenderer(this);
        bone17.setRotationPoint(-2.3F, -0.5F, 2.0F);
        body.addChild(bone17);
        setRotationAngle(bone17, 0.0F, 1.3003F, 0.0F);
        bone17.setTextureOffset(8, 7).addBox(-0.515F, -0.5F, -0.6761F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone17.setModelRendererName("bone17");
        this.registerModelRenderer(bone17);

        bone18 = new AnimatedModelRenderer(this);
        bone18.setRotationPoint(-2.525F, -0.5F, 2.625F);
        body.addChild(bone18);
        setRotationAngle(bone18, 0.0F, 1.6755F, 0.0F);
        bone18.setTextureOffset(4, 7).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone18.setModelRendererName("bone18");
        this.registerModelRenderer(bone18);

        bone19 = new AnimatedModelRenderer(this);
        bone19.setRotationPoint(-2.325F, -0.5F, 3.275F);
        body.addChild(bone19);
        setRotationAngle(bone19, 0.0F, 0.48F, 0.0F);
        bone19.setTextureOffset(0, 7).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone19.setModelRendererName("bone19");
        this.registerModelRenderer(bone19);

        bone20 = new AnimatedModelRenderer(this);
        bone20.setRotationPoint(-1.825F, -0.5F, 3.875F);
        body.addChild(bone20);
        setRotationAngle(bone20, 0.0F, 0.829F, 0.0F);
        bone20.setTextureOffset(16, 5).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone20.setModelRendererName("bone20");
        this.registerModelRenderer(bone20);

        bone21 = new AnimatedModelRenderer(this);
        bone21.setRotationPoint(-1.15F, -0.5F, 4.325F);
        body.addChild(bone21);
        setRotationAngle(bone21, 0.0F, 1.0036F, 0.0F);
        bone21.setTextureOffset(12, 5).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
        bone21.setModelRendererName("bone21");
        this.registerModelRenderer(bone21);

        bone22 = new AnimatedModelRenderer(this);
        bone22.setRotationPoint(-0.6F, -0.5F, 4.625F);
        body.addChild(bone22);
        setRotationAngle(bone22, 0.0F, 1.1345F, 0.0F);
        bone22.setTextureOffset(8, 5).addBox(-0.5031F, -0.5F, -0.3882F, 1.0F, 1.0F, 1.0F, -0.01F, false);
        bone22.setModelRendererName("bone22");
        this.registerModelRenderer(bone22);

        bone23 = new AnimatedModelRenderer(this);
        bone23.setRotationPoint(0.0986F, -0.5F, 5.038F);
        body.addChild(bone23);
        setRotationAngle(bone23, 0.0F, 1.0123F, 0.0F);
        bone23.setTextureOffset(4, 5).addBox(-0.4426F, -0.5F, -0.4181F, 1.0F, 1.0F, 1.0F, -0.05F, false);
        bone23.setModelRendererName("bone23");
        this.registerModelRenderer(bone23);

        bone24 = new AnimatedModelRenderer(this);
        bone24.setRotationPoint(0.7F, -0.5F, 5.55F);
        body.addChild(bone24);
        setRotationAngle(bone24, 0.0F, 0.8465F, 0.0F);
        bone24.setTextureOffset(0, 5).addBox(-0.3598F, -0.5F, -0.5185F, 1.0F, 1.0F, 1.0F, -0.1F, false);
        bone24.setModelRendererName("bone24");
        this.registerModelRenderer(bone24);

        bone25 = new AnimatedModelRenderer(this);
        bone25.setRotationPoint(1.2F, -0.5F, 5.875F);
        body.addChild(bone25);
        setRotationAngle(bone25, 0.0F, 0.5672F, 0.0F);
        bone25.setTextureOffset(18, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.15F, false);
        bone25.setModelRendererName("bone25");
        this.registerModelRenderer(bone25);

        bone26 = new AnimatedModelRenderer(this);
        bone26.setRotationPoint(1.4729F, -0.5F, 6.3979F);
        body.addChild(bone26);
        setRotationAngle(bone26, 0.0F, 0.3927F, 0.0F);
        bone26.setTextureOffset(14, 3).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, -0.2F, false);
        bone26.setModelRendererName("bone26");
        this.registerModelRenderer(bone26);

        this.rootBones.add(head);
        this.rootBones.add(body);
    }


    @Override
    public ResourceLocation getAnimationFileLocation()
    {
        return new ResourceLocation(Reptiles.MOD_ID, "animations/snake.json");
    }
}
