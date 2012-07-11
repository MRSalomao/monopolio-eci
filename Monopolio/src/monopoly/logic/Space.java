package monopoly.logic;

import com.badlogic.gdx.math.Vector3;

public abstract class Space
{
	public Vector3 centerPosition;
	public int spaceNumber;
	public SpaceType spaceType;
	
	public abstract void effect(Player player);
	
	public void movePawnToHere(Pawn pawn)
	{
		
	}
}
