package monopoly.logic;

import com.badlogic.gdx.math.Vector3;

public abstract class Space
{
	public int spaceNumber;
	public SpaceType spaceType;
	public int ID;
	
	private Vector3 centerPosition;
	
	public Space(SpaceType type, int spaceNumber)
	{
		this.spaceNumber = spaceNumber;
		spaceType = type;
		
		centerPosition = Board.getSharedInstance().getPositionFromSpace(spaceNumber);
	}
	
	public abstract void effect(Player player);
	
	public void movePawnToHere(Pawn pawn)
	{
		
	}
}
