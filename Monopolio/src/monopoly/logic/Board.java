package monopoly.logic;

import java.io.IOException;

import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;

import com.badlogic.gdx.math.Vector3;

public class Board
{
	InanimatedObject boardModel;
	InanimatedElement boardNode;
	
	public Board()
	{
		try
		{
			boardModel = new InanimatedObject("board", "board3.png", false);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		boardNode = new InanimatedElement(boardModel);
	}

	public Vector3 getPositionFromSpace(int spaceNumber)
	{
		if (spaceNumber < 10)
		{
			return new Vector3(4.5f - spaceNumber, -4.5f, 0);
		}
		else if (spaceNumber < 20)
		{
			return new Vector3(-4.5f, -4.5f + spaceNumber, 0);
		}
		else if (spaceNumber < 30)
		{
			return new Vector3(-4.5f + spaceNumber, 4.5f, 0);
		}
		else if (spaceNumber < 40)
		{
			return new Vector3(4.5f, 4.5f - spaceNumber, 0);
		}
		return new Vector3(0, 0, 0);
	}
}
