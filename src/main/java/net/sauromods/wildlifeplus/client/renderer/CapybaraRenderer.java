package net.sauromods.wildlifeplus.client.renderer;

import net.sauromods.wildlifeplus.entity.CapybaraEntity;
import net.sauromods.wildlifeplus.client.model.Modelcustom_model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class CapybaraRenderer extends MobRenderer<CapybaraEntity, Modelcustom_model<CapybaraEntity>> {
	public CapybaraRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CapybaraEntity entity) {
		return new ResourceLocation("wildlifeplus:textures/capybara.png");
	}
}
