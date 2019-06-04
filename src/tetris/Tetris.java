package tetris;

import java.io.FileNotFoundException;

import engine.Engine;
import engine.GameLogic;
import engine.display.Resolution;
import engine.graphics.Color;
import engine.input.Input;
import engine.math.Vector3f;
import engine.objects.scene.SceneManager;
import engine.textures.manager.TextureManager;
import exceptions.InvalidFileException;
import tetris.blocks.Background;
import tetris.blocks.Block;
import tetris.blocks.BlockI;
import tetris.blocks.BlockSquare;
import tetris.blocks.BlockZ1;
import tetris.blocks.BlockZ2;
import tetris.blocks.SubBlock;

public class Tetris implements GameLogic {

	public static final float SCALE = 0.5f ;
	private static final int FIELD_WIDTH_NUMBER = 10;
	private static final long ROTATION_CD = 100;
	private static final long MOVE_CD = 100;
	private long lastRotation = 0;
	private long lastMove = 0;
	private SceneManager manager;
	private Block currentBlock;
	private Engine engine;
	
	private Background background;
	
	public void start() {
		this.engine = new Engine(Resolution.HD, this, 60);
		this.engine.start();
	}
	
	@Override
	public void update() {
		if(currentBlock != null) {
			//currentBlock.changePosition(0f, -0.1f);
		}
		//Button down pressed
		if(Input.keys[Input.KEY_DOWN]) {
			if(currentBlock != null) {
				currentBlock.changePosition(0f, -0.1f);
			}
		}
		//Button up pressed
		if(Input.keys[Input.KEY_UP]) {
			if(currentBlock != null && canRotate()) {
				currentBlock.rotateRight();
			}
		}
		//Button left pressed
		if(Input.keys[Input.KEY_LEFT] && !Input.keys[Input.KEY_RIGHT]) {
			if(currentBlock != null && canMove()) {
				currentBlock.setPosition(
						currentBlock.getPosition().x - SubBlock.getWidth(),
						currentBlock.getPosition().y);
			}	
		}
		//Button right pressed
		if(Input.keys[Input.KEY_RIGHT] && !Input.keys[Input.KEY_LEFT]) {
			if(currentBlock != null && canMove()) {
				currentBlock.setPosition(
						currentBlock.getPosition().x + SubBlock.getWidth(),
						currentBlock.getPosition().y);
			}
		}
	}
	
	private boolean canRotate() {
		long currentTime = System.currentTimeMillis();
		if(currentTime - lastRotation >= ROTATION_CD) {
			lastRotation = currentTime;
			return true;
		}else {
			return false;
		}
	}
	
	private boolean canMove() {
		long currentTime = System.currentTimeMillis();
		if(currentTime - lastMove >= MOVE_CD) {
			lastMove = currentTime;
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void init() {
		try {
			TextureManager.readResourceFile("res/resources");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		background = new Background();
		background.changePosition(0, 0, -1);
		Block test = new BlockI();
		test.setPosition(SubBlock.getWidth()/2, 0);
		currentBlock = test;
		manager = Engine.getSceneManager();
		manager.addGameObject(background);
		manager.addGameObject(test);
	}

	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}

}
