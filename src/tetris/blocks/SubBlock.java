package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;

public class SubBlock extends GameObject {

	public static final int BLOCK_WIDTH = 100;
	public static final float SCALE = 0.5f;
	
	public SubBlock(Sprite sprite) {
		super(sprite);
		this.setScale(SCALE, SCALE);
	}
	
	public static final int getWidth() {
		return (int) (BLOCK_WIDTH * SCALE);
	}
	
	@Override
	public void onCollision(GameObject collider) {
	}

	@Override
	public void onCollisionExit(GameObject collider) {
	}

}
