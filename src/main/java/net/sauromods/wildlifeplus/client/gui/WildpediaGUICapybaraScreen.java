
package net.sauromods.wildlifeplus.client.gui;

import net.sauromods.wildlifeplus.world.inventory.WildpediaGUICapybaraMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WildpediaGUICapybaraScreen extends AbstractContainerScreen<WildpediaGUICapybaraMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public WildpediaGUICapybaraScreen(WildpediaGUICapybaraMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 270;
		this.imageHeight = 170;
	}

	private static final ResourceLocation texture = new ResourceLocation("wildlifeplus:textures/wildpedia_gui_capybara.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("wildlifeplus:textures/wildpedia_gui.png"));
		this.blit(ms, this.leftPos + 0, this.topPos + -7, 0, 0, 271, 180, 271, 180);

		RenderSystem.setShaderTexture(0, new ResourceLocation("wildlifeplus:textures/wdpd_capybara.png"));
		this.blit(ms, this.leftPos + 26, this.topPos + 38, 0, 0, 91, 86, 91, 86);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Capybara", 174, 17, -13421773);
		this.font.draw(poseStack, "The capybara is a", 146, 44, -13421773);
		this.font.draw(poseStack, "giant cavy rodent", 146, 56, -13421773);
		this.font.draw(poseStack, "native to South", 146, 69, -13421773);
		this.font.draw(poseStack, "America. It is the", 146, 82, -13421773);
		this.font.draw(poseStack, "largest living", 146, 95, -13421773);
		this.font.draw(poseStack, "rodent and a", 146, 108, -13421773);
		this.font.draw(poseStack, "member of the genus", 146, 121, -13421773);
		this.font.draw(poseStack, "Hydrochoerus.", 146, 134, -13421773);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
