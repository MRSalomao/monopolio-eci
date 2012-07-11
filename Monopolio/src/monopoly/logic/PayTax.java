package monopoly.logic;

public class PayTax extends Space
{
	private int tax;
	
	public PayTax(SpaceType type, int spaceNumber)
	{
		super(type, spaceNumber);
		tax = 1000;
	}

	@Override
	public void effect(Player player) 
	{
		player.playerCreditCard.credit(tax);
	}
}
