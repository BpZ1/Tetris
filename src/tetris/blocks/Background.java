package tetris.blocks;

import engine.objects.GameObject;
import engine.textures.Sprite;
import engine.textures.manager.TextureManager;
import tetris.Tetris;

public class Background extends GameObject {

	private Sprite sprite;
	
	public Background() {
		this.sprite = TextureManager.getSprite("res/background.png", 0, 0);
		this.setSprite(sprite);
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
