package tetris.blocks;

import engine.objects.GameObject;

public abstract class Block extends GameObject {
	
	public void rotateLeft() {
		if(this.rotation.z == 0) {
			rotation.z = 90;
		}else if(rotation.z == 90) {
			rotation.z = 180;
		}else if(rotation.z == 180) {
			rotation.z = 270;
		}else if(rotation.z == 270) {
			rotation.z = 0;
		}
	}
	
	public void rotateRight() {
		if(this.rotation.z == 0) {
			rotation.z = -90;
		}else if(rotation.z == -90) {
			rotation.z = -180;
		}else if(rotation.z == -180) {
			rotation.z = -270;
		}else if(rotation.z == -270) {
			rotation.z = 0;
		}
	}
	
}
