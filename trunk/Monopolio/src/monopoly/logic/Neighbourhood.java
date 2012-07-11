package monopoly.logic;

public class Neighbourhood extends Property
{
	private int rent;
	private int houseCostValue;
	private int hotelCostValue;
	private int numberOfHouses;
	private Boolean hotelExists;
	private String color;
	
	public Neighbourhood(SpaceType type)
	{
		super(type);
	}
	
	public int getRentValue()
	{
		return rent;
	}
	
	public int getHouseCostValue()
	{
		return houseCostValue;
	}
	
	public int getHotelCostValue()
	{
		return houseCostValue;
	}
}
