package monopoly.logic;

import java.io.IOException;

import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;

public class Pawn
{
	InanimatedObject pawnModel;
	InanimatedElement pawnNode;
	
	Pawn(Color color)
	{
		try
		{
			pawnModel = new InanimatedObject("pawn/pawn", "pawn/pawn_" + color.toString() + ".png", false);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		pawnNode = new InanimatedElement(pawnModel);
		
		
	}
	
	public void goToJail(){
		
	}
	
	public void move(int numOfSpaces){
		
	}
}
