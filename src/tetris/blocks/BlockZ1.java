package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;
import engine.textures.manager.TextureManager;

public class BlockZ1 extends Block {

	private static final String TEXTURE_PATH = "res/blockRed.png";
	private Sprite sprite;
	
	public BlockZ1() {
		sprite = TextureManager.getSprite(TEXTURE_PATH, 0, 0);
		
		SubBlock block1 = new SubBlock(sprite);
		block1.setPosition(0, 0);
		this.addChild(block1);
		
		SubBlock block2 = new SubBlock(sprite);
		block2.setPosition(-SubBlock.getWidth(), 0);
		this.addChild(block2);
		
		SubBlock block3 = new SubBlock(sprite);
		block3.setPosition(0, -SubBlock.getWidth());
		this.addChild(block3);
		
		SubBlock block4 = new SubBlock(sprite);
		block4.setPosition(SubBlock.getWidth(), -SubBlock.getWidth());
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
