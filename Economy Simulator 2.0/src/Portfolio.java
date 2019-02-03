import java.util.*;
public abstract class Portfolio {
	
	private String name;
	
	public Portfolio(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public static double getRand()
	{
		Random rad = new Random();
		double i = rad.nextInt(25);
		double j = rad.nextDouble();
		return i+j;
		
	}
	
	public abstract void ref();
	public abstract void rec();
	public abstract void ovr();
	public abstract void stg();
	public abstract void deposit$(double quan);
	public abstract void withdraw$(double quan);
	public abstract double get$();
	public abstract double getChange();
	
}