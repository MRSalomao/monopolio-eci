package monopoly.logic;

import java.util.Random;

public class Player
{
	private Random generator = new Random();
	public String playerName;
	public int playerID;
	public Pawn playerPawn;
	public int numberOfSDPcards;
	public boolean isArrested;
	public int[][] lastResults;
	public PlayerCard playerCard;
	
	public Player(String name, int id, Color color)
	{
		this.playerName = name;
		this.playerID = id;
		this.numberOfSDPcards = 0;
		this.isArrested = false;
		this.lastResults = new int[3][2];
		playerPawn = new Pawn(color);
		playerCard = new PlayerCard();
	};
	
	/*
	public void rowDice(){
		//randomizando dados
		int result1 = (int)(Math.random() * 6) + 1;
		int result2 = (int)(Math.random() * 6) + 1;
		
		
		//--- avisar a GUI dos resultados dos dados2
		
		//atualizando a lista de últimos resultados
		this.lastResults[2][0] = this.lastResults[1][0];
		this.lastResults[2][1] = this.lastResults[1][1];
		this.lastResults[1][0] = this.lastResults[0][0];
		this.lastResults[1][1] = this.lastResults[0][1];
		this.lastResults[0][0] = result1;
		this.lastResults[0][1] = result2;
		
		//checando se o jogador vai para a cadeia por lançamentos repetidos
		if (lastResults[0][0] == lastResults[0][1]){
			if (lastResults[1][0] == lastResults[1][1]){
				if (lastResults[2][0] == lastResults[2][1]){
					
					//--- avisar a GUI que foi para cadeia
					
					this.playerPawn.goToJail();
					return;
				}
			}
		}
		
		//caso não tenha sido preso, mover espaços necessários
		this.playerPawn.move(result1 + result2);
		
	}*/
	
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
		
		System.out.print(result1);
		System.out.print(result2);
		
		sum += (result1 + result2);
		plays ++;
		
		if(plays == 3){
			this.playerPawn.goToJail();
			return;
		}
		
		if(result1 == result2){
			if(isArrested)
			{
				isArrested = false;
				this.playerPawn.move(sum);
			}
			else
				rowDiceStep(plays, sum);
		}
		
		if(isArrested)
		{
			if(plays == 3)
			{
				isArrested = false;
				playerCard.charge(500);
			}
			else
				rowDiceStep(plays, 0);
		}
		
		this.playerPawn.move(sum);
	}
	
	private void tentarSairDaPrisao() {
		// TODO Auto-generated method stub
		
	}
}
