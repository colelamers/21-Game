package twentyOne;
import diceGames.*;
import java.util.Random;


public class TwentyOne
{

	private int dealerDiceScore = 0;
	private int userDiceScore = 0;
	private int wager;
	private int points = 100; //Starting points is the users balance to gamble
	
	public void TwentyOne()
	{
		dealerDiceScore = 0;
		userDiceScore = 0;
		wager = 0;
		points = 100;
	}
	
	//This gets the wagered amount
	public void setWager(int wager)
	{
		this.wager = wager;
	}
	
	public int getWager()
	{
		return wager;
	}
	
	//this sets the points after the wager
	public void setPointsWager(int points)
	{
		this.points -= wager;
	}
	
	public int getPointsWager()
	{
		return points;
	}
	
	public void resetPoints(int points)
	{
		this.points = points;
	}
	
	public void resetPoints(int points, int wager)
	{
		this.points = points + wager;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public void addUserDiceScore(int userDiceScore)
	{
		this.userDiceScore += userDiceScore;
	}
	
	public void setUserDiceScore(int userDiceScore)
	{
		this.userDiceScore = userDiceScore;
	}
	
	public int getUserDiceScore()
	{
		return userDiceScore;
	}
	
	public void setDealerDiceScore(int dealerDiceScore)
	{
		this.dealerDiceScore = dealerDiceScore;
	}
	
	public void addDealerDiceScore(int dealerDiceScore)
	{
		this.dealerDiceScore += dealerDiceScore;
	}
	
	public int getDealerDiceScore()
	{
		return dealerDiceScore;
	}
	
	public void setWinPoints(int points, int wager)
	{
		this.points = points + wager * 2; 
	}
	
}
