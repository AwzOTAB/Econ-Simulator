import java.util.*;
public class CommoditiesPortfolio extends Portfolio {

	private double quan;
	private double randomNo;
	public CommoditiesPortfolio(String name, double quan) {
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
			if(rand >= 0.0 && rand <= 2.0)
			{
				break;
			}
		}
		rand -= 12;
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void rec() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 2.0 && rand <= 4.0)
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
			if(rand >= 12 && rand <= 14)
			{
				break;
			}
		}
		quan *= (1.0+(rand/100.0));
		randomNo = rand/100.0;
	}

	@Override
	public void stg() {
		double rand;
		while(true)
		{
			rand = getRand();
			if(rand >= 0 && rand <= 1.8)
			{
				break;
			}
		}
		rand -= 2.8;
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
