package tetris.blocks;

import engine.objects.GameObject;

public abstract class Block extends GameObject {
	
	public void rotateLeft() {
		this.changeRotation(-90);
	}
	
	public void rotateRight() {
		this.changeRotation(90);
	}
	
}
