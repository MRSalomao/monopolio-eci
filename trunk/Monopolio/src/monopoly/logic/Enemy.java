package monopoly.logic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

import monopoly.objects.AnimatedObject;

public class Enemy extends Creature
{

	public Enemy(AnimatedObject srcObject)
	{
		super(srcObject);
		// TODO Auto-generated constructor stub
	}
	
	Vector2 center1Attempt = new Vector2();
	Vector2 center2 = new Vector2();
	float distanceC1A_C2;
	float sumOfRadii;
	@Override
	public void moveTowardsTarget()
	{
		for (Creature creature2 : Level.getSharedInstance().defenderDic.values())
		{
			Gdx.app.log("enemy - "+creatureID, "my target's pos "+target.position2D);
			Gdx.app.log("enemy - "+creatureID, "my pos "+position2D);
			
			sumOfRadii = size2D + creature2.size2D;
			center2 = creature2.position2D;
			center1Attempt.set(position2D.cpy().add( (target.position2D.cpy().sub(position2D).nor().mul(moveSpeed) )));
			distanceC1A_C2 = center1Attempt.dst(center2);

			if (distanceC1A_C2 < sumOfRadii)
			{
				position2D = center1Attempt.cpy().add( center1Attempt.sub(center2).nor()
						.mul(1 - distanceC1A_C2 / sumOfRadii) );
			}
			else
			{
				position2D = center1Attempt;
			}
		}
	}
	
	@Override
	public Creature lookForTarget()
	{
		for (Creature defender : Level.getSharedInstance().defenderDic.values())
		{
			if (defender.position2D.dst(this.position2D) < lineOfSight)
			{
				return defender;
			}
		}
		return null;
	}
	
	@Override
	public boolean targetIsInRange()
	{
		if (target.position2D.dst(position2D) < attackRange)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public void attack()
	{
		if(System.currentTimeMillis() % 800 < 20)
		{
			target.hitPoints -= attackPoints;
			Gdx.app.log("as", ""+target.hitPoints);
		}
	}
	
	public void march()
	{
		position2D.x += moveSpeed;
	}
}
