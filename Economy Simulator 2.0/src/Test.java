import java.util.Random;

public class Test {
	

	public static void main(String[] args) {
		Random rad = new Random();
		
		for(int j = 0; j < 49; j++)
		{
			int i = rad.nextInt(25);
		System.out.print(i + " ");
		}

	}
}


