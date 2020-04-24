package twentyOne;
import diceGames.*;
import java.util.Scanner;

public class TwentyOneDemo
{
	public static void main(String[] args)
	{
		Die userDie = new Die(6);
		Die dealerDie = new Die(6);
		TwentyOne twoOne = new TwentyOne();
		Scanner scanner = new Scanner(System.in);

		int round = 0;

		System.out.println("Welcome to 21: 6 Sided Dice Version."
				+ "\nYour starting points are " + twoOne.getPoints() + ".");

		while (true)
			{
				if(twoOne.getPoints() == 0 && round == 0)
					{
						System.out.println("You're all out of points. Game over.");
						break;
					}
				//round if sequence check to verify if it's a period to wager points
				if(round == 0)
					{
						System.out.println("\nCurrent Points: " + twoOne.getPoints()
								+ "\nHow much would you like to wager?");
						twoOne.setWager(Integer.valueOf(scanner.nextInt()));

						//do while to check that the wager amount is not greater than their points
						while (twoOne.getWager() > twoOne.getPoints()) 
							{
								System.out.println("You cannot wager more than you have. Please enter a valid amount.");
								twoOne.setWager(Integer.valueOf(scanner.nextInt()));
							}
						twoOne.setPointsWager(twoOne.getWager());
					}
				

				System.out.println("\nRoll (0) or Hold (1)?");

				int hold = Integer.valueOf(scanner.nextInt());

				//Checks to verify if user holds and dealer rolls, or if both will roll

				if(hold == 0)
					{
						userDie.roll();
						dealerDie.roll();
						twoOne.addUserDiceScore(userDie.getValue()); //assigns user diceroll value
						twoOne.addDealerDiceScore(dealerDie.getValue()); //assigns dealers diceroll value
						round++;	
						System.out.printf("\n%-10s%-10s%-5s%-10s", "=====", "Round ", String.valueOf(round), "=====");

						System.out.printf("%-5s%-5s", "\nYour Score: ", twoOne.getUserDiceScore());
						System.out.printf("%-5s%-5s", "Dealer's Score: ", twoOne.getDealerDiceScore());
						System.out.printf("%-5s%-5s", "Your Points: ", twoOne.getPoints());			
						}
				else 
					{
						dealerDie.roll();
						twoOne.addDealerDiceScore(dealerDie.getValue()); //only assings the dealer a new diceroll value
						round++;
						System.out.printf("\n%-10s%-10s%-5s%-10s", "=====", "Round ", String.valueOf(round), "=====");

						System.out.printf("%-5s%-5s", "\nYour Score: ", twoOne.getUserDiceScore());
						System.out.printf("%-5s%-5s", "Dealer's Score: ", twoOne.getDealerDiceScore());
					}



				//Boolean verification. This determines the status of the game after each roll.
				if(
						(twoOne.getUserDiceScore() == 21 && twoOne.getDealerDiceScore() == 21)
						||
						((twoOne.getUserDiceScore() > twoOne.getDealerDiceScore())
								&&
								(twoOne.getUserDiceScore() > 21)
								&& 
								(twoOne.getDealerDiceScore() > 21)
								)
						||
						((twoOne.getUserDiceScore() < twoOne.getDealerDiceScore())
								&&
								(twoOne.getUserDiceScore() > 21)
								&& 
								(twoOne.getDealerDiceScore() > 21)
								)
						)
					{
						System.out.println("\nIt's a tie. Setting new round.");
						round = 0;
						twoOne.resetPoints(twoOne.getPoints(), twoOne.getWager());
						twoOne.setUserDiceScore(0); //assigns user diceroll value
						twoOne.setDealerDiceScore(0); //assigns dealers diceroll value
						continue;
					}

				else if (
						((twoOne.getUserDiceScore() < twoOne.getDealerDiceScore())
								&&
								(twoOne.getUserDiceScore() <= 21)
								&& 
								(twoOne.getDealerDiceScore() > 21)
								)
						||
						(
								(twoOne.getUserDiceScore() == 21)
								&& 
								(twoOne.getDealerDiceScore() != 21)
								)
						)
					{
						System.out.println("\nYou win!");
						twoOne.setWinPoints(twoOne.getPoints(), twoOne.getWager());
						twoOne.setWager(0);
						round = 0;
						twoOne.setUserDiceScore(0); //assigns user diceroll value
						twoOne.setDealerDiceScore(0); //assigns dealers diceroll value
						continue;

					}								
				else if (
						((twoOne.getUserDiceScore() > twoOne.getDealerDiceScore())
								&&
								(twoOne.getUserDiceScore() > 21)
								&& 
								(twoOne.getDealerDiceScore() <= 21)
								)
						||
						(
								(twoOne.getUserDiceScore() != 21)
								&& 
								(twoOne.getDealerDiceScore() == 21)
								)
						)
						
					{
						System.out.println("\nYou Lose");
						//No adjustment to points because they'll not be returned
						//Wager is altered
						twoOne.setWager(0);//resets the wager
						round = 0; 
						twoOne.setUserDiceScore(0); //resets user diceroll score
						twoOne.setDealerDiceScore(0); //resets dealers diceroll score
						continue;
					}
				else 
					{
						round = 1;//keeps the round at 1
						continue;
					}

			}
	}

}
