package monopoly.logic;

public class Property extends Space
{
	public String name;
	public int price;
	public Player owner;
	public PropertyType type;
	
	public Property(PropertyType propType, int spaceNumber)
	{
		super(SpaceType.Property, spaceNumber);
		this.type = propType;
	}

	@Override
	public void effect(Player player)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void buy(Player ownerPlayer)
	{
		if (owner == null && ownerPlayer.playerCreditCard.money >= price)
		{
			this.owner = ownerPlayer;
			owner.playerCreditCard.debit(price);
		}
	}
	
	public void payRent(Player player)
	{
		
	}
	
	public void recoverFromMortgage()
	{
		
	}
	
	public void mortgage()
	{
		
	}

}
