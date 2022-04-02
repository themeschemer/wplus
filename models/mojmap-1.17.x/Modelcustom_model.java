// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelcustom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart head;
	private final ModelPart body;
	private final ModelPart front_leg_left;
	private final ModelPart front_leg_right;
	private final ModelPart back_leg_left;
	private final ModelPart back_leg_right;

	public Modelcustom_model(ModelPart root) {
		this.head = root.getChild("head");
		this.body = root.getChild("body");
		this.front_leg_left = root.getChild("front_leg_left");
		this.front_leg_right = root.getChild("front_leg_right");
		this.back_leg_left = root.getChild("back_leg_left");
		this.back_leg_right = root.getChild("back_leg_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(0, 22)
						.addBox(-4.0F, -3.0F, -6.0F, 4.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).texOffs(0, 6)
						.addBox(-4.0F, -4.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(4, 6)
						.addBox(0.0F, -4.0F, 0.0F, 0.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 13.0F, -6.0F));

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(
				-4.0F, -4.0F, -7.0F, 8.0F, 8.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 16.0F, 1.0F));

		PartDefinition front_leg_left = partdefinition.addOrReplaceChild("front_leg_left", CubeListBuilder.create()
				.texOffs(30, 7).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 19.5F, -4.0F));

		PartDefinition front_leg_right = partdefinition.addOrReplaceChild("front_leg_right", CubeListBuilder.create()
				.texOffs(30, 0).addBox(-1.0F, -0.5F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 19.5F, -4.0F));

		PartDefinition back_leg_left = partdefinition.addOrReplaceChild("back_leg_left", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(2.0F, 19.5F, 5.5F));

		PartDefinition back_leg_right = partdefinition.addOrReplaceChild("back_leg_right", CubeListBuilder.create()
				.texOffs(22, 22).addBox(-1.0F, -0.5F, -1.5F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-2.0F, 19.5F, 5.5F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		head.render(poseStack, buffer, packedLight, packedOverlay);
		body.render(poseStack, buffer, packedLight, packedOverlay);
		front_leg_left.render(poseStack, buffer, packedLight, packedOverlay);
		front_leg_right.render(poseStack, buffer, packedLight, packedOverlay);
		back_leg_left.render(poseStack, buffer, packedLight, packedOverlay);
		back_leg_right.render(poseStack, buffer, packedLight, packedOverlay);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.back_leg_right.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.back_leg_left.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.front_leg_right.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.front_leg_left.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
	}
}