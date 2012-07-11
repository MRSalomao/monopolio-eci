package monopoly.logic;

import java.util.Iterator;

public class Neighbourhood extends Property
{
	private int rentValue;
	private int houseCostValue;
	private int hotelCostValue;
	private int numberOfHouses;
	private int mortgageValue;
	private Boolean hotelExists;
	private String colorValue;
	
	public Neighbourhood(String name, String cost, String color, 
			String houseCost, String hotelCost, String mortgage, String rent, String spaceNumberString)
	{
		super(PropertyType.Neighbourhood, Integer.parseInt(spaceNumberString));
		super.name = name;
		rentValue = Integer.parseInt(rent);
		houseCostValue = Integer.parseInt(houseCost);
		hotelCostValue = Integer.parseInt(hotelCost);
		mortgageValue = Integer.parseInt(mortgage);
		colorValue = color;
		hotelExists = false;
		numberOfHouses = 0;
		
	}
	
	public int getRentValue()
	{
		return rentValue;
	}
	
	public int getHouseCostValue()
	{
		return houseCostValue;
	}
	
	public int getHotelCostValue()
	{
		return hotelCostValue;
	}
	
	public boolean buildHouse(Player player) 
	{
		if (super.owner != player &&
			this.hotelExists &&
			player.playerCreditCard.money < this.houseCostValue)
		{
			return false;
		}
		
		for (int i=0; i<Board.getSharedInstance().spaces; )
		
	    while (itr.hasNext()) {
	    	Property element = (Property) itr.next();
	    	if(element.type != PropertyType.Neighbourhood){
	    		continue;
	    	}
	    	if ( ((Neighbourhood)element).colorValue == this.colorValue )
	    	{
	    		
	    	}
	    }
		
		
		player.playerCreditCard.debit(this.houseCostValue);
		this.numberOfHouses++;
		
		//TODO adicionar graficamente a casa
		return true;
	}
	
	public boolean buildHotel(Player player)
	{
		if (numberOfHouses == 4)
		{
			if(player.playerCreditCard.money > hotelCostValue)
			{
				player.playerCreditCard.debit(hotelCostValue);
				hotelExists = true;
				return true;
			}
			//TODO: remove houses on the board
			//TODO: place hotel on the board
		}
	}
	
	public void payRent(Player player)
	{
		super.payRent(player);
		
		if (super.owner != null)
		{
			if(player.playerCreditCard.money > rentValue){
				player.playerCreditCard.debit(rentValue);
				super.owner.playerCreditCard.credit(rentValue);
			}
			else
				player.declareBankruptcy();
		}
	}
}
