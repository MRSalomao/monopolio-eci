package monopoly.logic;

public class GoToPrison extends Space
{
	public GoToPrison(SpaceType type, int spaceNumber)
	{
		super(type, spaceNumber);
	}
	
	@Override
	public void effect(Player player)
	{
		player.isArrested = true;
		player.playerPawn.goToJail();
	}
}
