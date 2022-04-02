
package net.sauromods.wildlifeplus.client.gui;

public class AnimalBookScreen extends AbstractContainerScreen<AnimalBookMenu> {

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	EditBox AAAAAAAAAAAAAA;

	public AnimalBookScreen(AnimalBookMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("wildlifeplus:textures/animal_book.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);

		AAAAAAAAAAAAAA.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		if (AAAAAAAAAAAAAA.isFocused())
			return AAAAAAAAAAAAAA.keyPressed(key, b, c);

		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		AAAAAAAAAAAAAA.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Dog Be Shitting", 48, 147, -12829636);
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

		this.addRenderableWidget(new Button(this.leftPos + 11, this.topPos + 7, 150, 20, new TextComponent("Click to roast Jellybean"), e -> {
		}));
		AAAAAAAAAAAAAA = new EditBox(this.font, this.leftPos + 32, this.topPos + 30, 120, 20, new TextComponent(""));
		AnimalBookMenu.guistate.put("text:AAAAAAAAAAAAAA", AAAAAAAAAAAAAA);
		AAAAAAAAAAAAAA.setMaxLength(32767);
		this.addWidget(this.AAAAAAAAAAAAAA);
	}

}