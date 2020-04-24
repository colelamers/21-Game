package diceGames;
import java.util.Random;


public class Die 
{
	
	private int sides;
	private int value;
	
	public Die(int numSides)
	{
		sides = numSides;
	}
	
	//determines probability of dice roll
	
	public void roll()
	{
		Random rand = new Random();
		value = rand.nextInt(sides) + 1;
	}
	
	public int getSides()
	{
		return sides;
	}
	
	public int getValue()
	{
		return value;
	}

}
