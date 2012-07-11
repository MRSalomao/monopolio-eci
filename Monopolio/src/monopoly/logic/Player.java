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
		
		this.showInformationMessageToUser("You rolled " + result1 + " and " + result2 + " .");
		
		sum += (result1 + result2);
		plays ++;
		
		if(plays == 3){
			isArrested = true;
			this.playerPawn.goToJail();
			this.showInformationMessageToUser("You are arrested!")
			return;
		}
		
		if(result1 == result2)
			rowDiceStep(plays, sum);
		
		this.playerPawn.move(sum);
			//--- realiza o efeito do espaço no qual se caiu
		
	}
	
	private void tentarSairDaPrisao() {
		int result1 = generator.nextInt(6) + 1;
		int result2 = generator.nextInt(6) + 1;
		this.showInformationMessageToUser("You rolled " + result1 + " and " + result2 + " .");
		
		leavePrisonAttempts++;
		
		if(result1 == result2){
			isArrested = false;
			leavePrisonAttempts = 0;
			this.showInformationMessageToUser("You are free!");
			this.playerPawn.move(result1 + result2);
		}
		
		if(leavePrisonAttempts == 3){
			if(playerCreditCard.money << 500)
				declareBankruptcy();
			else{
				isArrested = false;
				leavePrisonAttempts = 0;
				playerCreditCard.debit(500);
			}
		}
	}

	public void declareBankruptcy() {
		// TODO Auto-generated method stub
		
	}
	
	public void showInformationMessageToUser(String message)
	{
		//TODO show this message on GUI, to click OK
	}
}
