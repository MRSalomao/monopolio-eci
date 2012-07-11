package monopoly.logic;

public class Property extends Space
{
	public String name;
	public int price;
	public int ID;
	private Player owner;
	
	public Property(SpaceType type)
	{
		super.spaceType = type;
		
	}

	@Override
	public void effect(Player player)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePawnToHere(Pawn pawn)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void buy()
	{
		
	}
	
	public void payRent()
	{
		
	}
	
	public void recoverFromMortgage()
	{
		
	}
	
	public void mortgage()
	{
		
	}

}
