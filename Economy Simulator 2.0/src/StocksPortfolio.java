import java.util.*;
public class StocksPortfolio extends Portfolio {

	private double quan;
	private double randomNo;
	public StocksPortfolio(String name, int quan) {
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
			if(rand >= 0.0 && rand <= 3.0)
			{
				break;
			}
		}
		rand -= 6.0;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void rec() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 10.5 && rand <= 13.5)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;

	}

	public void ovr() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 3.5 && rand <= 5.5)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	public void stg() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 3.0)
			{
				break;
			}
		}
		rand -= 15.0;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
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