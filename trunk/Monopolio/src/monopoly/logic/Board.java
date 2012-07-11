package monopoly.logic;

import java.util.ArrayList;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

import monopoly.camera.CameraHandler;
import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

public class Board
{
	private float borderLimit = 4.1f;
	
	InanimatedObject boardModel;
	InanimatedElement boardNode;
	
	private static Board sharedInstance;
	
	public  ArrayList<Space> spaces = new ArrayList<Space>();
	
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
		loadModel();
		
		
		// Initializing board spaces
		File file = new File("data/neighborhood_data.txt");
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;
 
        try 
        {
            reader = new BufferedReader(new FileReader(file));
            String text = null;
 
            // repeat until all lines is read
            while ((text = reader.readLine()) != null) 
            {
            	// Excluding first line
            	if (!text.contains("#"))
            	{
            		String[] strArray  = text.split(" ");
            		Neighbourhood neighbour = new Neighbourhood(strArray[1], strArray[2], 
            												   strArray[3], strArray[4], strArray[5], strArray[6], strArray[7], strArray[0]);
            		spaces.add(neighbour);
            	}
            }
        } 
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                if (reader != null) {
                    reader.close();
                }
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
		 
	}
	
		
	private void loadModel()
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
	

	public Vector3 getPositionFromSpace(int spaceNumber)
	{
		float spaceStep = (spaceNumber % 10) * (borderLimit * 2.0f) / 10.0f;
		
		if (spaceNumber == 0)
		{
			return new Vector3(-borderLimit, borderLimit, 0);
		}
		else if	(spaceNumber == 10)
		{
			return new Vector3(borderLimit, borderLimit, 0);
		}
		else if (spaceNumber == 20)
		{
			return new Vector3(borderLimit, -borderLimit, 0);
		}
		else if (spaceNumber == 30)
		{
			return new Vector3(-borderLimit, -borderLimit, 0);
		}
		
		else if (spaceNumber < 10)
		{
			return new Vector3(-borderLimit + spaceStep, borderLimit, 0);
		}
		else if (spaceNumber < 20)
		{
			return new Vector3(borderLimit, borderLimit - spaceStep, 0);
		}
		else if (spaceNumber < 30)
		{
			return new Vector3(borderLimit - spaceStep, -borderLimit, 0);
		}
		else if (spaceNumber < 40)
		{
			return new Vector3(-borderLimit, -borderLimit + spaceStep, 0);
		}
		return new Vector3(0, 0, 0);
	}

}
		
		// Initialize neighborhood spaces
		
