package monopoly.GUI;

import monopoly.Monopoly;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class MainMenu extends InGameGUI
{
	public MainMenu()
	{
		Gdx.app.log("", "Choose number of players (enter a number from 3-6): ");
	}
	
	public void effect()
	{
		if (Gdx.input.isKeyPressed(Keys.NUM_3))
		{
			Gdx.app.log("", "Você selecionou 3 jogadores");
			Monopoly.getSharedInstance().startGame(3);
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_4))
		{
			Gdx.app.log("", "Você selecionou 4 jogadores");
			Monopoly.getSharedInstance().startGame(4);
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_5))
		{
			Gdx.app.log("", "Você selecionou 5 jogadores");
			Monopoly.getSharedInstance().startGame(5);
		}
		else if (Gdx.input.isKeyPressed(Keys.NUM_6))
		{
			Gdx.app.log("", "Você selecionou 6 jogadores");
			Monopoly.getSharedInstance().startGame(6);
		}
	}
}
