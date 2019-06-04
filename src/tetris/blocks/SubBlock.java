package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;
import tetris.Tetris;

public class SubBlock extends GameObject {

	public static final int BLOCK_WIDTH = 100;
	
	public SubBlock(Sprite sprite) {
		super(sprite);
		this.setScale(Tetris.SCALE, Tetris.SCALE);
	}
	
	public static final int getWidth() {
		return (int) (BLOCK_WIDTH * Tetris.SCALE);
	}
	
	@Override
	public void onCollision(GameObject collider) {
	}

	@Override
	public void onCollisionExit(GameObject collider) {
	}

}
