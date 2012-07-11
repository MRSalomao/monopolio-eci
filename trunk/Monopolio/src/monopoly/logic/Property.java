package monopoly.logic;

public class Property extends Space
{
	public String name;
	public int price;
	public int rent;
	private Player owner;
	
	public Property(SpaceType type)
	{
		super(type);
	}

	@Override
	public void effect(Player player)
	{
		// TODO Auto-generated method stub
		
	}
	
	public void buy(Player ownerPlayer)
	{
		if (ownerPlayer.playerCreditCard.money >= price)
		{
			this.owner = ownerPlayer;
			owner.playerCreditCard.debit(price);
		}
	}
	
	public void payRent(Player player)
	{
		if (owner != null)
		{
			if(player.playerCreditCard.money > rent){
				player.playerCreditCard.debit(rent);
				owner.playerCreditCard.credit(rent);
			}
			else
				player.declareBankruptcy();
		}
	}
	
	public void recoverFromMortgage()
	{
		
	}
	
	public void mortgage()
	{
		
	}

}
