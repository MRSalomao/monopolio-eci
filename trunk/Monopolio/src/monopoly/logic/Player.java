package monopoly.logic;

public class Player
{
	public String playerName;
	public int playerID;
	public Pawn playerPawn;
	public int numberOfFFJcards;
	public boolean isArrested;
	public int[][] lastResults;
	
	Player(String name, int id, Enum color){
		this.playerName = name;
		this.playerID = id;
		this.numberOfFFJcards = 0;
		this.isArrested = false;
		this.lastResults = new int[3][2];
		playerPawn = new Pawn(color);
	};
	
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
		
	}
	
}
