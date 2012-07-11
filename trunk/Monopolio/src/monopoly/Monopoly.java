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

import java.util.ArrayList;

import monopoly.camera.CameraHandler;
import monopoly.logic.Board;
import monopoly.logic.Color;
import monopoly.logic.Player;
import monopoly.objects.ObjectRenderer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class Monopoly implements ApplicationListener, InputProcessor {
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private Board board;

	public void startGame() {
		
		// **HARDCODED**
		int numberOfPlayers = 6; // TODO: input for number of players
		// **HARDCODED**
		for (int i=0; i < numberOfPlayers; i++) 
		{
			players.add( new Player("player " + i, i, Color.values()[i]) );
		}
		
	}
	
	@Override
	public void create () {
		
		Gdx.input.setInputProcessor(this);
		
		board = new Board();
		
		startGame();

		
	}

	@Override
	public void render () 
	{		
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
