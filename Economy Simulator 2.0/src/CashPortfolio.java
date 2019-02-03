import java.util.*;

public class CashPortfolio extends Portfolio {

	private double quan;
	private double randomNo;
	public CashPortfolio(String name, double quan) {
		super(name);
		this.quan = quan;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ref() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 0.5)
			{
				break;
			}
		}
		rand -= 0.5;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void rec() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 2.0)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	/**
	 * This method modifies the balance of an object (portfolio) of this class depending on the phase of the economy
	 * @param $  the portfolio that is being modified 
	 */
	public void ovr() {
		double rand;
		while(true)
		{
			//gets a random number within a specified range
			rand = getRand();
			if(rand >= 0.0 && rand <= 0.6)
			{
				break;
			}
		}
		//adjusts number and converts it to a percentage value (including the principal) 
		rand -= 0.2;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void stg() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 1.0)
			{
				break;
			}
		}
		rand -= 0.5;
		quan *= (1.0+(rand/100.0));
	}
	public void deposit$(double a)
    {
        quan += a;
    }

	public void withdraw$(double a)
	{
        quan -= a;
    }
	
	public double get$()
	{
		return quan;
	}
	
	public double getChange()
	{
		return randomNo;
	}

}
