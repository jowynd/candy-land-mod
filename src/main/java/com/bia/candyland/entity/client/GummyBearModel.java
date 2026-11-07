package com.bia.candyland.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class GummyBearModel<T extends Entity> extends HierarchicalModel<T> {
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath("candyland", "gummybear"), "main");

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart L_arm;
    private final ModelPart R_arm;
    private final ModelPart L_leg;
    private final ModelPart R_leg;

    public GummyBearModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.L_arm = root.getChild("L_arm");
        this.R_arm = root.getChild("R_arm");
        this.L_leg = root.getChild("L_leg");
        this.R_leg = root.getChild("R_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition head = partDefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(34, 7).addBox(3.22F, -7.0F, -1.16F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 12).addBox(-2.94F, -5.78F, -2.9F, 7.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
                        .texOffs(34, 10).addBox(-4.32F, -7.0F, -1.16F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-0.58F, 9.86F, 0.0F));

        PartDefinition body = partDefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(24, 16).addBox(-2.58F, -3.0F, -2.0F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(18, 23).addBox(-3.0F, -3.0F, -1.42F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 23).addBox(-3.42F, -4.0F, -0.84F, 7.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(24, 0).addBox(-3.0F, -3.0F, 0.98F, 6.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(28, 30).addBox(-2.58F, -3.0F, 1.81F, 5.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(30, 30).addBox(-1.08F, 1.0F, 2.81F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-0.1F, 14.04F, -0.9F));

        PartDefinition L_arm = partDefinition.addOrReplaceChild("L_arm",
                CubeListBuilder.create()
                        .texOffs(8, 32).addBox(-1.42F, -1.0F, -1.74F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-4.06F, 11.04F, 0.0F));

        PartDefinition R_arm = partDefinition.addOrReplaceChild("R_arm",
                CubeListBuilder.create()
                        .texOffs(0, 32).addBox(-0.42F, -1.0F, -0.74F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
                        .texOffs(0, 0).addBox(-0.12F, 4.26F, -7.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                        .texOffs(32, 23).addBox(-0.12F, 3.26F, -8.0F, 1.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(3.92F, 11.04F, -1.0F));

        PartDefinition L_leg = partDefinition.addOrReplaceChild("L_leg",
                CubeListBuilder.create()
                        .texOffs(24, 7).addBox(-1.84F, 0.0F, -0.74F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-1.74F, 17.0F, -1.0F));

        PartDefinition R_leg = partDefinition.addOrReplaceChild("R_leg",
                CubeListBuilder.create()
                        .texOffs(18, 30).addBox(-1.42F, 0.0F, -0.74F, 3.0F, 7.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.9F, 17.0F, -1.0F));

        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                           float netHeadYaw, float headPitch) {
        this.head.yRot = netHeadYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;

        this.L_leg.xRot = limbSwingAmount * 0.6F;
        this.R_leg.xRot = limbSwingAmount * -0.6F;
        this.L_arm.xRot = limbSwingAmount * -0.6F;
        this.R_arm.xRot = limbSwingAmount * 0.6F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight,
                                int packedOverlay, float red, float green, float blue, float alpha) {
        head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        L_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        R_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        L_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        R_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return this.body;
    }
}
