package tetris;

import java.util.LinkedList;
import java.util.List;

import engine.objects.GameObject;
import engine.textures.Sprite;
import engine.textures.manager.TextureManager;
import tetris.blocks.Block;
import tetris.blocks.SubBlock;

public class Background extends GameObject {

	private Sprite sprite;
	private List<SubBlock> blocks = new LinkedList<SubBlock>();
	
	public Background() {
		this.sprite = TextureManager.getSprite("res/background.png", 0, 0);
		this.setSprite(sprite);
	}
	
	public void addBlock(Block block) {
		for(GameObject child : block.getChildren()) {
			blocks.add((SubBlock)child);
		}
		block.clearChildren();
		block.delete();
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
