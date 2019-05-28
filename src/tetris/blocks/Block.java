package tetris.blocks;

import engine.math.Vector3f;
import engine.objects.GameObject;

public abstract class Block extends GameObject {
	
	public void rotateLeft() {
		if((int)this.rotation.z == 0) {
			this.setRotation(new Vector3f(0,0,-90));
		}else if((int)rotation.z == -90) {
			this.setRotation(new Vector3f(0,0,-180));
		}else if((int)rotation.z == -180) {
			this.setRotation(new Vector3f(0,0,-270));
		}else if((int)rotation.z == -270) {
			this.setRotation(new Vector3f(0,0,0));
		}
	}
	
	public void rotateRight() {
		if((int)this.rotation.z == 0) {
			this.setRotation(new Vector3f(0,0,90));
		}else if((int)rotation.z == 90) {
			this.setRotation(new Vector3f(0,0,180));
		}else if((int)rotation.z == 180) {
			this.setRotation(new Vector3f(0,0,270));
		}else if((int)rotation.z == 270) {
			this.setRotation(new Vector3f(0,0,0));
		}
	}
	
}
