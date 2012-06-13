package monopoly.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

import monopoly.objects.AnimatedElement;
import monopoly.objects.AnimatedObject;

public class Creature extends AnimatedElement
{
	int team;
	Creature target;
	int creatureID;
	float size2D = 1f;
	Vector2 initialPosition = new Vector2();
	Vector2 position2D = new Vector2();
	

	int hitPoints = 100;
	int manaPoints = 100;
	int attackPoints = 1;
	int armorPoints = 3;
	float moveSpeed = .04f;
	float attackRange = 3f;
	float lineOfSight = 20f;
	
	
	
	public Creature(AnimatedObject srcObject)
	{
		super(srcObject);
		// TODO Auto-generated constructor stub
	}
	
	
	public void act() //Called each frame
	{
		if (target == null)
		{
			target = lookForTarget();
			march();
		}
		else
		{
			if (targetIsInRange())
			{
				attack();
			}
			else
			{
				moveTowardsTarget();
			}
		}
		
		position.set(position2D.x, position2D.y, position.z);
	}
	
	public void moveTowardsTarget()
	{
	
	}
	
	public void march()
	{
	
	}
	
	public Creature lookForTarget()
	{
		return null;
	}
	
	public boolean targetIsInRange()
	{
		return true;
	}
	
	public void attack()
	{
		
	}
	
	public void drop()
	{
		
	}
	
	public void die()
	{
		
	}
	
	public void useSpell()
	{
		
	}
}
