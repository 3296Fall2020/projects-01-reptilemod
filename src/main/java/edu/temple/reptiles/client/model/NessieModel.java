package edu.temple.reptiles.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.NessieEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class NessieModel<T extends NessieEntity> extends EntityModel<T> {
    private final ModelRenderer nessie;
    private final ModelRenderer tailSegmentOne;
    private final ModelRenderer tailSegmentTwo;
    private final ModelRenderer tailSegmentThree;
    private final ModelRenderer tailSegmentFour;
    private final ModelRenderer tailSegmentFive;
    private final ModelRenderer neckSegmentOne;
    private final ModelRenderer flippers;

    public NessieModel() {
        textureWidth = 128;
        textureHeight = 128;

        nessie = new ModelRenderer(this);
        nessie.setRotationPoint(0.0F, 21.5F, 1.25F);
        setRotationAngle(nessie, 0.0436F, 0.0F, 0.0F);
        nessie.setTextureOffset(0, 0).addBox(-24.0F, -17.5F, -35.25F, 48.0F, 20.0F, 78.0F, 0.0F, false);

        tailSegmentOne = new ModelRenderer(this);
        tailSegmentOne.setRotationPoint(0.0F, -7.0F, 37.0F);
        nessie.addChild(tailSegmentOne);
        setRotationAngle(tailSegmentOne, -0.0436F, 0.0F, 0.0F);
        tailSegmentOne.setTextureOffset(0, 0).addBox(-18.0F, -8.0048F, -0.2181F, 36.0F, 15.0F, 28.0F, 0.0F, false);

        tailSegmentTwo = new ModelRenderer(this);
        tailSegmentTwo.setRotationPoint(0.0F, -1.0F, 24.0F);
        tailSegmentOne.addChild(tailSegmentTwo);
        setRotationAngle(tailSegmentTwo, -0.1309F, 0.0F, 0.0F);
        tailSegmentTwo.setTextureOffset(0, 0).addBox(-12.0F, -6.1848F, -0.1736F, 24.0F, 12.0F, 24.0F, 0.0F, false);

        tailSegmentThree = new ModelRenderer(this);
        tailSegmentThree.setRotationPoint(0.0F, 0.0F, 19.0F);
        tailSegmentTwo.addChild(tailSegmentThree);
        setRotationAngle(tailSegmentThree, -0.1745F, 0.0F, 0.0F);
        tailSegmentThree.setTextureOffset(0, 0).addBox(-8.0F, -4.9879F, 0.2214F, 16.0F, 8.0F, 16.0F, 0.0F, false);

        tailSegmentFour = new ModelRenderer(this);
        tailSegmentFour.setRotationPoint(0.0F, 0.0F, 13.0F);
        tailSegmentThree.addChild(tailSegmentFour);
        setRotationAngle(tailSegmentFour, -0.1309F, 0.0F, 0.0F);
        tailSegmentFour.setTextureOffset(0, 0).addBox(-4.0F, -3.7713F, -0.0374F, 8.0F, 4.0F, 16.0F, 0.0F, false);

        tailSegmentFive = new ModelRenderer(this);
        tailSegmentFive.setRotationPoint(0.0F, -1.5F, 12.0F);
        tailSegmentFour.addChild(tailSegmentFive);
        setRotationAngle(tailSegmentFive, -0.0873F, 0.0F, 0.0F);
        tailSegmentFive.setTextureOffset(0, 0).addBox(-2.0F, -2.4085F, 2.2676F, 4.0F, 4.0F, 8.0F, -0.1F, false);

        neckSegmentOne = new ModelRenderer(this);
        neckSegmentOne.setRotationPoint(0.0F, 2.5F, -1.25F);
        nessie.addChild(neckSegmentOne);


        flippers = new ModelRenderer(this);
        flippers.setRotationPoint(0.0F, 2.5F, -1.25F);
        nessie.addChild(flippers);

    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        nessie.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
