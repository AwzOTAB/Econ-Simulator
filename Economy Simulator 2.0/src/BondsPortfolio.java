import java.util.*;
public class BondsPortfolio extends Portfolio {

	private double quan;
	private double randomNo;
	public BondsPortfolio(String name, double quan) {
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
			if(rand >= 4.0 && rand <= 7.0)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void rec() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.5 && rand <= 3.5)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void ovr() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 1.6)
			{
				break;
			}
		}
		rand -= 4.3;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void stg() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0.0 && rand <= 1.5)
			{
				break;
			}	
		}
		rand -= 3;
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
