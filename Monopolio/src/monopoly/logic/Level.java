package monopoly.logic;

import java.util.HashMap;

import monopoly.objects.AnimatedElement;
import monopoly.objects.AnimatedObject;
import monopoly.objects.InanimatedElement;
import monopoly.objects.ObjectRenderer;

public class Level
{
	private static Level sharedInstance;
	
	public HashMap <Integer, Creature> defenderDic = new HashMap <Integer, Creature>();
	public HashMap <Integer, Creature> enemyDic = new HashMap <Integer, Creature>();
	private int creatureID = 1;
	
	int phaseClock;
	
	public static Level getSharedInstance()
	{
		if (sharedInstance == null)
		{
			sharedInstance = new Level();
		}
		return sharedInstance;
	}
	
	public Level()
	{
			
	}
	
	public void update()
	{
		for (Creature creature : Level.getSharedInstance().enemyDic.values())
		{
			creature.act();
		}
		for (Creature creature : Level.getSharedInstance().defenderDic.values())
		{
			creature.act();
		}
	}
	
	private Defender tmpDefender;
	public void placeDefender(float x, float y, AnimatedObject aObj)
	{
		tmpDefender = new Defender(aObj);
		tmpDefender.position2D.set(x, y);
		tmpDefender.creatureID = creatureID;
		defenderDic.put(creatureID, tmpDefender);
		
		creatureID++;
	}
	
	private Enemy tmpEnemy;
	public void spawnEnemy(float x, float y, AnimatedObject aObj)
	{
		tmpEnemy = new Enemy(aObj);
		tmpEnemy.position2D.set(x, y);
		tmpEnemy.creatureID = creatureID;
		enemyDic.put(creatureID, tmpEnemy);
	
		creatureID++;
	}
	
	public void startBuildPhase()
	{
			
	}
	
	public void startDefensePhase()
	{
			
	}
	
	public void spawnWave()
	{
			
	}
	
	public void activateAllies()
	{
			
	}
	
	public void activateTowers()
	{
			
	}
	
	public void healUnits()
	{
			
	}
	
	public void victory()
	{
			
	}
	
	public void defeat()
	{
			
	}
}
