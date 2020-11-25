package edu.temple.reptiles.client.model;



import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import edu.temple.reptiles.entities.GilaMonsterEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class GilaMonsterModel<T extends GilaMonsterEntity> extends EntityModel<GilaMonsterEntity> {
	private final ModelRenderer head;
	private final ModelRenderer body;
	private final ModelRenderer legFrontRight;
	private final ModelRenderer bone;
	private final ModelRenderer bone2;
	private final ModelRenderer legFrontLeft;
	private final ModelRenderer bone7;
	private final ModelRenderer bone8;
	private final ModelRenderer legBackRight;
	private final ModelRenderer bone3;
	private final ModelRenderer bone4;
	private final ModelRenderer legBackLeft;
	private final ModelRenderer bone5;
	private final ModelRenderer bone6;
	private final ModelRenderer tail;

	public GilaMonsterModel() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 24.0F, 0.0F);
		head.setTextureOffset(14, 0).addBox(-2.0F, -2.6F, -5.65F, 3.0F, 2.0F, 2.0F, -0.1F, false);
		head.setTextureOffset(0, 16).addBox(-2.0F, -1.775F, -7.3F, 3.0F, 1.0F, 2.0F, -0.25F, false);
		head.setTextureOffset(14, 4).addBox(-2.0F, -2.325F, -7.35F, 3.0F, 1.0F, 2.0F, -0.2F, false);
		head.setTextureOffset(20, 14).addBox(-1.475F, -1.775F, -7.8F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		head.setTextureOffset(18, 19).addBox(-1.475F, -2.275F, -7.875F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		head.setTextureOffset(10, 10).addBox(-0.075F, -2.775F, -6.25F, 1.0F, 1.0F, 1.0F, -0.3F, false);
		head.setTextureOffset(4, 3).addBox(-1.875F, -2.775F, -6.25F, 1.0F, 1.0F, 1.0F, -0.3F, false);
		head.setTextureOffset(0, 0).addBox(-1.475F, -2.775F, -7.225F, 2.0F, 1.0F, 2.0F, -0.3F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-2.0F, -2.5F, -4.0F, 3.0F, 2.0F, 8.0F, -0.2F, false);
		body.setTextureOffset(10, 10).addBox(-2.5F, -2.4F, -2.15F, 1.0F, 2.0F, 4.0F, -0.3F, false);
		body.setTextureOffset(0, 10).addBox(0.5F, -2.4F, -2.15F, 1.0F, 2.0F, 4.0F, -0.3F, false);

		legFrontRight = new ModelRenderer(this);
		legFrontRight.setRotationPoint(-1.8125F, 22.7625F, -2.725F);
		legFrontRight.setTextureOffset(12, 21).addBox(-0.9875F, -0.4875F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-0.475F, -0.225F, 0.0F);
		legFrontRight.addChild(bone);
		setRotationAngle(bone, 0.0F, 0.0F, 0.9599F);
		bone.setTextureOffset(8, 21).addBox(-0.4029F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.1623F, 1.0966F, -0.025F);
		bone.addChild(bone2);
		setRotationAngle(bone2, 0.1484F, 0.0F, 0.6109F);
		bone2.setTextureOffset(16, 16).addBox(-0.1424F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);

		legFrontLeft = new ModelRenderer(this);
		legFrontLeft.setRotationPoint(0.8F, 22.7875F, -2.7125F);
		legFrontLeft.setTextureOffset(14, 16).addBox(0.0F, -0.5125F, -0.5125F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone7 = new ModelRenderer(this);
		bone7.setRotationPoint(0.5375F, -0.25F, 5.3625F);
		legFrontLeft.addChild(bone7);
		setRotationAngle(bone7, 0.0F, 0.0F, -0.9599F);
		bone7.setTextureOffset(0, 10).addBox(-0.5971F, -0.1007F, -5.875F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		bone8 = new ModelRenderer(this);
		bone8.setRotationPoint(-0.1623F, 1.0966F, -0.025F);
		bone7.addChild(bone8);
		setRotationAngle(bone8, 0.1484F, 0.0F, -0.6109F);
		bone8.setTextureOffset(0, 3).addBox(-0.8576F, -0.761F, -6.691F, 1.0F, 1.0F, 2.0F, -0.15F, false);

		legBackRight = new ModelRenderer(this);
		legBackRight.setRotationPoint(-1.8F, 22.6875F, 2.65F);
		legBackRight.setTextureOffset(20, 16).addBox(-1.0F, -0.4125F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone3 = new ModelRenderer(this);
		bone3.setRotationPoint(-0.4875F, -0.15F, 0.0F);
		legBackRight.addChild(bone3);
		setRotationAngle(bone3, 0.0F, 0.0F, 0.9599F);
		bone3.setTextureOffset(4, 21).addBox(-0.4029F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		bone4 = new ModelRenderer(this);
		bone4.setRotationPoint(0.1623F, 1.0966F, -0.025F);
		bone3.addChild(bone4);
		setRotationAngle(bone4, 0.1484F, 0.0F, 0.6109F);
		bone4.setTextureOffset(10, 16).addBox(-0.1424F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);

		legBackLeft = new ModelRenderer(this);
		legBackLeft.setRotationPoint(0.8F, 22.7375F, 2.675F);
		legBackLeft.setTextureOffset(8, 16).addBox(0.0F, -0.4625F, -0.525F, 1.0F, 1.0F, 1.0F, 0.0F, false);

		bone5 = new ModelRenderer(this);
		bone5.setRotationPoint(0.5375F, -0.2F, -0.025F);
		legBackLeft.addChild(bone5);
		setRotationAngle(bone5, 0.0F, 0.0F, -0.9599F);
		bone5.setTextureOffset(0, 21).addBox(-0.5971F, -0.1007F, -0.5F, 1.0F, 2.0F, 1.0F, -0.11F, false);

		bone6 = new ModelRenderer(this);
		bone6.setRotationPoint(-0.1623F, 1.0966F, -0.025F);
		bone5.addChild(bone6);
		setRotationAngle(bone6, 0.1484F, 0.0F, -0.6109F);
		bone6.setTextureOffset(6, 10).addBox(-0.8576F, 0.0334F, -1.375F, 1.0F, 1.0F, 2.0F, -0.15F, false);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 24.0F, 0.0F);
		tail.setTextureOffset(12, 19).addBox(-1.5F, -2.0F, 3.725F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		tail.setTextureOffset(6, 19).addBox(-1.5F, -2.0F, 4.575F, 2.0F, 1.0F, 1.0F, -0.1F, false);
		tail.setTextureOffset(0, 19).addBox(-1.5F, -2.0F, 5.25F, 2.0F, 1.0F, 1.0F, -0.2F, false);
		tail.setTextureOffset(16, 12).addBox(-1.5F, -2.0F, 5.8F, 2.0F, 1.0F, 1.0F, -0.25F, false);
		tail.setTextureOffset(16, 10).addBox(-1.5F, -2.0F, 6.25F, 2.0F, 1.0F, 1.0F, -0.3F, false);
		tail.setTextureOffset(0, 6).addBox(-1.5F, -2.0F, 6.6F, 2.0F, 1.0F, 1.0F, -0.35F, false);
	}

	@Override
	public void setRotationAngles(GilaMonsterEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		this.head.rotateAngleX = headPitch * 0.000453292F;
		this.head.rotateAngleY = netHeadYaw * 0.000453292F;
		this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.09F) * limbSwingAmount;
		this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.09F + (float)Math.PI) * limbSwingAmount;
		this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.09F + (float)Math.PI) *  limbSwingAmount;
		this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.09F) * limbSwingAmount;
		this.tail.rotateAngleX = headPitch * 0.5F * 0.007453292F;
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legFrontLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackRight.render(matrixStack, buffer, packedLight, packedOverlay);
		legBackLeft.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}