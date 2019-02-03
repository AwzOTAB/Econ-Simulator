import java.util.*;
public class Main {

		/**
		 * @param args
		 */	

		public static void main(String[] args) {
			System.out.println("Welcome to the Economy Simulator!");
			pressa();
			System.out.println("In this simulation, you will learn a BUNCH of useful, practical, ");
			System.out.println("and interesting economic facts that will also help you out in the real world.");
			String player = inputStr("Let's first start by entering your name: ");
			System.out.println(player + ", nice to meet you.");
			pressa();

			
			int turns = turnsCheck(player);
			double cash$ = cash$Check();

			System.out.println("Your principle is $" + cash$ + ", and this simulation will last for " + turns + " turns. Good luck and have fun!");	
			
			//creating Portfolios
			CashPortfolio $c = new CashPortfolio("Cash Portfolio", cash$);
			StocksPortfolio $s = new StocksPortfolio("Stocks Portfolio", 0);
			BondsPortfolio $b = new BondsPortfolio("Bonds Portfolio", 0);
			CommoditiesPortfolio $com = new CommoditiesPortfolio("Commodities Portfolio", 0);
			
			pressa();
			
			
			int phaseCounter = 0;
			String[] phase = {"Reflation","Recovery","Overheat","Stagflation"};
			String[] assetNames = {"Cash", "Stocks", "Bonds", "Commodities"};
			Portfolio[] assets = {$c, $s, $b, $com};
			//game begins
			System.out.println("");
			System.out.println("");
			for(int i = 0; i < turns; i++)
			{
				// printing getPhase();
				//intro to phases, and how many turns each phase lasts 
				System.out.println("---Turn " + (i + 1) + "---");
				System.out.println("The economy is currently in the " + phase[phaseCounter] + " phase");
				// Chances
				//You may manipulate your money by buying assets, investing in stocks, in bonds, or simply keep it as cash (choose)
				pressa();
				
				turnSpecificComments(i);
				
				
				
				while(true)
				{
					printAssets(assets);
					System.out.println("Would you like to invest (deposit) some money into a portfolio? If so, to where?");
					System.out.println("{1.Cash, 2.Stocks, 3.Bonds, 4.Commodities}");
					int depIndex = rangeCheck("(Enter the respective number to chose the destination of your deposit. If you choose to not change your investments, enter 0): ", 0, 4);
					
					if(depIndex != 0)
					{
						System.out.println("");
						System.out.println("Which portfolio will you withdraw that money from?");
						System.out.println("{1.Cash, 2.Stocks, 3.Bonds, 4.Commodities}");
						
						int withIndex;
						while(true)
						{
							withIndex = rangeCheck("(Enter the respective number to chose the destination of your withdrawal): ", 1, 4);
							if(assets[withIndex-1].get$() != 0)
							{
								break;
							}
							System.out.println("You have no money in that portfolio!");
						}
						
						int amount;
						while(true)
						{
							amount = inputInt("How much will you withdraw from your " + assets[withIndex-1].getName() + "?: ");
							if(assets[withIndex-1].get$() >= amount)
							{
								break;
							}
							System.out.println("Insufficient funds.");
						}
						
						System.out.println("You have withdrawn $" + amount + " from your " + assets[withIndex-1].getName() + " portfolio, and deposited that amount into your " + assets[depIndex-1].getName() + " portfolio.");
						assets[withIndex-1].withdraw$(amount);
						assets[depIndex-1].deposit$(amount);

						printAssets(assets);
						
						String a = inputStr("Would you like to make another transaction? (enter y for yes and n for no): ");
						while(true)
						{

							if(a.equals("y")||a.equals("n"))
							{
								break;
							}
							else
							{
								a = inputStr("Invalid input. Try again.");
							}
						}
						
						if(a.equals("n"))
						{
							System.out.println("No more transactions will be conducted.");
							//output array of investments
							break;
						}
						
					}
					
					else
					{
						System.out.println("You chose not to change your current investment plan.");
						//output array of investments
						break;
					}
					
				}
				
				//investments takes effect
				if(phaseCounter == 0)
				{
					for(int j = 0; j < 4; j++)
					{
						assets[j].ref();
					}

				}
				else if(phaseCounter == 1)
				{
					for(int j = 0; j < 4; j++)
					{
						assets[j].rec();
					}
				}
				else if(phaseCounter == 2)
				{
					for(int j = 0; j < 4; j++)
					{
						assets[j].ovr();
					}
				}
				else
				{
					for(int j = 0; j < 4; j++)
					{
						assets[j].stg();
					}
				}
				
				//phase change
				if(i >= 1 && (i%2 == 1||i == 1))
				{
					phaseCounter++;
				}
				if(phaseCounter == 4)
				{
					phaseCounter = 0;
				}
				
				pressa();
			}
			
		}
		
		
		public static void pressa() {
			Scanner s = new Scanner(System.in); 
			System.out.println("Press A to continue");
			String answer = s.next(); 
			System.out.println("");
			}
		
		public static int inputInt(String prompt)
		{
			System.out.println(prompt);
			Scanner s = new Scanner(System.in);
			int number = s.nextInt(); 
			return number;
		}

		public static String inputStr(String prompt)
		{
			Scanner s = new Scanner(System.in); 
			System.out.println(prompt);
			String answer = s.next(); 
			return answer;
		}
		
		
		public static int turnsCheck(String player)
		{
			int turns = 0;
			turns = inputInt("This simulation is turn-based. For how many turns do you want to simulate? (each turn lasts for approximately half a minute) :");
			while(true)
			{
				if(turns < 8)
				{
					System.out.println("It's recommended that you at least play for 8 turns. It's for your learning.");
					turns = inputInt("Try again: ");
				}
				else if(turns > 30)
				{
					System.out.println(player + ", you will have already learned almost every concept in this simulation by Turn 30.");
					turns = inputInt("Try again: ");
				}
				else
				{
					break;
				}
			}
			return turns;
		}
		public static int cash$Check()
		{
			int cash$ = 0;
			cash$ = inputInt("You will only have one Portfolio to start with, the Cash Portfolio. How much cash would you like to start the simulation with?:");
			while(true)
			{
				if(cash$ < 10000)
				{
					System.out.println("You're too conservative. Put at least ten thousand!");
					cash$ = inputInt("Try again: ");
				}
				else if(cash$ > 5000000)
				{
					System.out.println("Maximum principal is five million!");
					cash$ = inputInt("Try again: ");
				}
				else
				{
					break;
				}
			}
			return cash$;

		}
		
		public static int rangeCheck(String prompt, int min, int max)
		{
			int i;
			
			while(true)
			{
				i = inputInt(prompt);
				if(i < min||i > max)
				{
					System.out.println("Invalid input. Try again.");
				}
				else
				{
					break;
				}
			}
			return i;

		}
		
		public static void turnSpecificComments(int i)
		{
			if(i == 0)
			{
				System.out.println("Each turn will have a different phase. ");
				System.out.println("Different phases will have different effects on the investments you make. Be cautious! ");
				pressa();
			}
			
		}
		
		public static void printAssets(Portfolio[] assets)
		{
			System.out.println("Your current investment status and balance in each Portfolio: ");
			System.out.println("");
			for(int i = 0; i < 4; i++)
			{
				double x = Math.round(assets[i].get$() * 100.0) / 100.0;
				System.out.println("Balance in " + assets[i].getName() + ": $" + x);
			}
			pressa();
		}
		
		//public static void addZero(double x)
		{
			String str = "x";
			for(int i = 0; i < str.length(); i++)
			{
				if(str.charAt(i) == '.')
				{
					str += str.charAt(i+1);
				}
			}
			//EDITTT
		}
	}



