package monopoly.logic;

import java.io.IOException;

import monopoly.camera.CameraHandler;
import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;

import com.badlogic.gdx.math.Vector3;

public class Board
{
	private float borderLimit = 4.2f;
	
	InanimatedObject boardModel;
	InanimatedElement boardNode;
	
	private static Board sharedInstance;
	
	public static Board getSharedInstance()
	{
		if (sharedInstance == null)
		{
			sharedInstance = new Board();
		}
		return sharedInstance;
	}
	
	public Board()
	{
		try
		{
			boardModel = new InanimatedObject("board/board", "board/board3.png", false);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		boardNode = new InanimatedElement(boardModel);
	}

	public Vector3 getPositionFromSpace(int spaceStep)
	{
		
		
		if (spaceStep == 0)
		{
			return new Vector3(-borderLimit, borderLimit, 0);
		}
		else if	(spaceStep == 10)
		{
			return new Vector3(-borderLimit, -borderLimit, 0);
		}
		else if (spaceStep == 20)
		{
			return new Vector3(-borderLimit, borderLimit, 0);
		}
		else if (spaceStep == 30)
		{
			return new Vector3(borderLimit, borderLimit, 0);
		}
		
		else if (spaceStep < 10)
		{
			return new Vector3(borderLimit - spaceStep, -borderLimit, 0);
		}
		else if (spaceStep < 20)
		{
			return new Vector3(-borderLimit, -borderLimit + spaceStep, 0);
		}
		else if (spaceStep < 30)
		{
			return new Vector3(-borderLimit + spaceStep, borderLimit, 0);
		}
		else if (spaceStep < 40)
		{
			return new Vector3(borderLimit, borderLimit - spaceStep, 0);
		}
		return new Vector3(0, 0, 0);
	}
}
		
		// Initialize neighborhood spaces
		
