package monopoly.logic;

public class GoToPrison extends Space
{
	public GoToPrison(SpaceType type)
	{
		super(type);
	}
	
	@Override
	public void effect(Player player)
	{
		player.isArrested = true;
		player.playerPawn.goToJail();
	}
}
