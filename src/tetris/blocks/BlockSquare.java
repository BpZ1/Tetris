package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;
import engine.textures.manager.TextureManager;

public class BlockSquare extends Block {

	private Sprite sprite1;
	
	public BlockSquare() {
		sprite1 = TextureManager.getSprite("res/blockYellow.png", 0, 0);
		
		SubBlock block1 = new SubBlock(sprite1);
		block1.setPosition(0, 0);
		this.addChild(block1);
		
		SubBlock block2 = new SubBlock(sprite1);
		block2.setPosition(-SubBlock.getWidth(), 0);
		this.addChild(block2);
		
		SubBlock block3 = new SubBlock(sprite1);
		block3.setPosition(-SubBlock.getWidth(), SubBlock.getWidth());
		this.addChild(block3);
		
		SubBlock block4 = new SubBlock(sprite1);
		block4.setPosition(0, SubBlock.getWidth());
		this.addChild(block4);
	}
	
	//No rotation for square!
	@Override
	public void rotateLeft() {};
	@Override
	public void rotateRight() {};
	
	@Override
	public void onCollision(GameObject collider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCollisionExit(GameObject collider) {
		// TODO Auto-generated method stub
		
	}

	
}
