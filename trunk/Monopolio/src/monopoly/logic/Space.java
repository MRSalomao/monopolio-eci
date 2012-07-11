package monopoly.logic;

import com.badlogic.gdx.math.Vector3;

public abstract class Space
{
	public Vector3 centerPosition;
	public int spaceNumber;
	public SpaceType spaceType;
	public int ID;
	
	public Space(SpaceType type)
	{
		spaceType = type;
	}
	
	public abstract void effect(Player player);
	
	public void movePawnToHere(Pawn pawn)
	{
		
	}
}
