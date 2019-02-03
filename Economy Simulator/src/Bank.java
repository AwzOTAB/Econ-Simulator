import java.util.*;
public abstract class Bank {
	
	private String name;
	private int quan;
	
	public Bank(String name, int quan)
	{
		this.name = name;
		this.quan = quan;
	}
	
	public void deposit$(int quan)
	{
		this.quan += quan;
	}
	public void withdraw$(int quan)
	{
		this.quan -= quan;
	}
	public int get$()
	{
		return this.quan;
	}
	
	public abstract void ref();
	public abstract void rec();
	public abstract void ovr();
	public abstract void stg();
	
}