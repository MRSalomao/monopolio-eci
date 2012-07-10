/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package monopoly;

import java.io.IOException;
import java.io.InputStream;

import monopoly.camera.CameraHandler;
import monopoly.logic.Level;
import monopoly.objects.AnimatedElement;
import monopoly.objects.AnimatedObject;
import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;
import monopoly.objects.ObjectRenderer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.loaders.ModelLoaderOld;
import com.badlogic.gdx.math.Vector2;

public class HelloWorld implements ApplicationListener, InputProcessor {
	
	public static Camera camera;
	float number;
	InanimatedObject hotel;
	InanimatedObject house;
	InanimatedObject board;
	InanimatedElement inEle1;
	InanimatedElement inEle2;
	InanimatedElement inEle3;
	static ObjectRenderer objRenderer;
	
	
	@Override
	public void create () {
		
		try
		{
			hotel = new InanimatedObject("hotel", "hotel2.png", false);
			
			house = new InanimatedObject("house", "house.png", false);
			
			board = new InanimatedObject("board", "board3.png", false);
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		inEle1 = new InanimatedElement(hotel); 
		inEle2 = new InanimatedElement(house);
		inEle3 = new InanimatedElement(board);
		
		inEle2.position.add(0f, 2f, 0.5f);
		
		
		Gdx.input.setInputProcessor(this);
		
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		camera.position.set(15, 13, 15);
		camera.lookAt(0, 3, 0);
		camera.up.set(0, 0, 1);
		camera.far = 120.0f;
		camera.near = 0.1f;
		camera.update();
		camera.apply(Gdx.graphics.getGL10());
	}

	@Override
	public void render () {		

		CameraHandler.getSharedInstance().orbitalCameraUpdate();
		

		
		ObjectRenderer.getSharedInstance().drawAll();
	}

	
	
	@Override
	public void resize (int width, int height) {
		Gdx.graphics.getGL10().glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	@Override
	public void pause () {

	}

	@Override
	public void resume () {

	}

	@Override
	public void dispose () {

	}

	@Override
	public boolean keyDown(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer)
	{
		// TODO Auto-generated method stub
		CameraHandler.getSharedInstance().orbitalCameraHandler();
		return false;
	}

	@Override
	public boolean touchMoved(int x, int y)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		// TODO Auto-generated method stub
		CameraHandler.getSharedInstance().orbitalCameraZoomHandler(amount);
		return false;
	}

}
