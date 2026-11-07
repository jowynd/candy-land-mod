package com.bia.candyland.entity.client;

import com.bia.candyland.CandyLandMod;
import com.bia.candyland.entity.custom.GummyBearEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GummyBearRenderer extends MobRenderer<GummyBearEntity, GummyBearModel<GummyBearEntity>> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(CandyLandMod.MOD_ID, "textures/entity/gummy_bear.png");

    public GummyBearRenderer(EntityRendererProvider.Context context) {
        super(context, new GummyBearModel<>(context.bakeLayer(GummyBearModel.LAYER_LOCATION)), 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(GummyBearEntity entity) {
        return TEXTURE;
    }
}
