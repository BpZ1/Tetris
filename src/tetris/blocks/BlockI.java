package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;
import engine.textures.manager.TextureManager;

public class BlockI extends Block{

	private Sprite sprite;
	
	public BlockI() {
		sprite = TextureManager.getSprite("res/blockOrange.png", 0, 0);
		
		SubBlock block1 = new SubBlock(sprite);
		block1.setPosition(0, 0);
		this.addChild(block1);
		
		SubBlock block2 = new SubBlock(sprite);
		block2.setPosition(0, SubBlock.getWidth());
		this.addChild(block2);
		
		SubBlock block3 = new SubBlock(sprite);
		block3.setPosition(0, 2 * SubBlock.getWidth());
		this.addChild(block3);
		
		SubBlock block4 = new SubBlock(sprite);
		block4.setPosition(0, -SubBlock.getWidth());
		this.addChild(block4);
	}

	@Override
	public void onCollision(GameObject collider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollisionExit(GameObject collider) {
		// TODO Auto-generated method stub
		
	}
}
