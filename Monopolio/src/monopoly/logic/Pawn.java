package monopoly.logic;

import java.io.IOException;

import monopoly.objects.InanimatedElement;
import monopoly.objects.InanimatedObject;

public class Pawn
{
	public int currentSpace;
	InanimatedObject pawnModel;
	InanimatedElement pawnNode;
	
	public Pawn(Color color)
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
		
		currentSpace = 0;
		
		pawnNode.position.set(Board.getSharedInstance().getPositionFromSpace(currentSpace));
	}
	
	public void goToJail(){
		
	}
	
	public void move(int numOfSpaces){
		
	}
}
