package monopoly.logic;

import java.util.Random;

public class Player
{
	private Random generator = new Random();
	public Color playerColor;
	public String playerName;
	public int playerID;
	public Pawn playerPawn;
	public int numberOfSDPcards;
	public boolean isArrested;
	public PlayerCreditCard playerCreditCard;
	private int leavePrisonAttempts = 0;
	
	public Player(String name, int id, Color color)
	{
		this.playerName = name;
		this.playerColor = color;
		this.playerID = id;
		this.numberOfSDPcards = 0;
		this.isArrested = false;
		playerPawn = new Pawn(color);
		playerCreditCard = new PlayerCreditCard();
	}

	public void rowDice(){
		int plays = 0;
		int sum = 0;
		
		if(isArrested)
			tentarSairDaPrisao();
		else
			rowDiceStep(plays, sum);
	}

	private void rowDiceStep(int plays, int sum){
		int result1 = generator.nextInt(6) + 1;
		int result2 = generator.nextInt(6) + 1;
		
		//--- envia resultados dos dados para a GUI
		
		sum += (result1 + result2);
		plays ++;
		
		if(plays == 3){
			isArrested = true;
			this.playerPawn.goToJail();
			return;
		}
		
		if(result1 == result2)
			rowDiceStep(plays, sum);
		
		this.playerPawn.move(sum);
		
	}
	
	privaPawn.te void tentarSairDaPrisao() {
		int result1 = generator.nextInt(6) + 1;
		int result2 = generator.nextInt(6) + 1;
		
		leavePrisonAttempts++;
		
		if(result1 == result2){
			isArrested = false;
			leavePrisonAttempts = 0;
			this.playerPawn.move(result1 + result2);
		}
		
		if(leavePrisonAttempts == 3){
			isArrested = false;
			leavePrisonAttempts = 0;
			playerCreditCard.Charge(500);
		}
	}
}
