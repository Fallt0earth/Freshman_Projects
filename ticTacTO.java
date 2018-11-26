import java.util.Scanner;

public class ticTacTO {
	
	static int x, y, choice = -1;
	static int turn = 0;
	static boolean blueWin = false, redWin = false;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] image = new int[3][3][3];
		
		int[][] key = new int[3][3];
		
		int a = 1;
		for (int i = 0; i < key.length; i++) {
			for ( int j = 0; j < key[0].length; j++) {
			key[i][j] = a++;
			}
			}
		
		
		reset(image);
		print(image);
		
		System.out.println("player one will be red and player 2 will be blue. The player will select a square by entering a 1, 2, 3 etc. I will display a key to use as referenece");
		while(blueWin != true && redWin != true) {
			
		turn(image);
		}
		
		if (blueWin) {
			System.out.println("Blue wins!!! red fucking sucks");
		}
		else {
			System.out.println("red wins!!! blue fucking sucks");
		}
		
	

	}
	
	public static void print(int[][][] array) {
		
		ImageBuilder imageBuilder = new ImageBuilder(array, 100);
		imageBuilder.show();
		
	}
	
	public static void reset(int[][][] image) {
		int a = 0;
		turn = 0;
		for (int i = 0; i < image.length; i++) {
			for ( int j = 0; j < image[0].length; j++) {
				for ( int k = 0; k < image[i][j].length; k++) {
					
					image[i][j][k] = a+=2;
					
				}
			}
		}
	}
	
	public static void selectionConvert(int[][][] image) {
		
	}

	
	
	
	public static boolean isBlank(int[][][] image) {
		
	int z = 2;
	int c = 1;
	int v = 0;
		choice();
		while (z < 26) {
		if 	(image[x][y][2] != 255 && image[x][y][0] != 255 ){
			return true;
		}
		
		z += 3;
		c += 3;
		v += 3;
		}
		return false;

}
	
	public static void choice() {
		x = 0; 
		y = 0;
		if (choice == 2) {
			y = 1;
		}
		else if (choice == 3) {
			y = 2;
		}
		else if (choice == 4) {
			x = 1;
			
		}
		else if (choice == 5) {
			x = 1;
			y = 1;
		}
		else if (choice == 6) {
			x = 1;
			y = 2;
		}
		else if (choice == 7) {
			x = 2;
			
		}
		else if (choice == 8) {
			x = 2;
			y = 1;
		}
		else if (choice == 9) {
			x = 2;
			y = 2;
		}
	}
	
	public static void turn(int[][][] image) {
		
		
		Scanner input = new Scanner(System.in);
		
		
		
		

		boolean test = false;
		while (test == false) {
			System.out.println("Please make a choice");
			System.out.print("\n 1 4 7 \n 2 5 8 \n 3 6 9");
			
			choice = input.nextInt();
			
			if (isBlank(image) && turn % 2 == 0) {
				image[x][y][2] = 0;
				image[x][y][1] = 0;
				image[x][y][0] = 255;
				turn++;
				test = true;
			}
			else if (isBlank(image) && turn % 2 == 1) {
				image[x][y][2] = 255;
				image[x][y][1] = 0;
				image[x][y][0] = 0;
				turn++;
				test = true;
			}
			else {
				System.out.println("That space is already taken. Please enter another space");
			}
		}
		print(image);
		checkWin(image);
		
	}
	
	public static void checkWin(int[][][] image) {
		
		if ( image[0][0][0] == 255 && image[1][0][0] == 255 && image[2][0][0] == 255) {
			redWin = true;
		}
		else if (image[0][1][0] == 255 && image[1][1][0] == 255 && image[2][1][0] == 255) {
			
		}
		else if (image[0][2][0] == 255 && image[1][2][0] == 255 && image[2][2][0] == 255) {
			
		}
		else if (image[0][0][0] == 255 && image[0][1][0] == 255 && image[0][2][0] == 255) {
			redWin = true;
		}
		else if (image[0][0][0] == 255 && image[0][1][0] == 255 && image[0][2][0] == 255) {
			redWin = true;
		}
		else if (image[1][0][0] == 255 && image[1][1][0] == 255 && image[1][2][0] == 255) {
			redWin = true;
		}
		else if (image[2][0][0] == 255 && image[2][1][0] == 255 && image[2][2][0] == 255) {
			redWin = true;
		}
		else if (image[0][0][0] == 255 && image[1][1][0] == 255 && image[2][2][0] == 255) {
			redWin = true;
		}
		else if (image[2][0][0] == 255 && image[1][1][0] == 255 && image[0][2][0] == 255) {
			redWin = true;
		}
		
		//blue win
		if ( image[0][0][2] == 255 && image[1][0][2] == 255 && image[2][0][2] == 255) {
			blueWin = true;
		}
		else if (image[0][1][2] == 255 && image[1][1][2] == 255 && image[2][1][2] == 255) {
			blueWin = true;
		}
		else if (image[0][2][2] == 255 && image[1][2][2] == 255 && image[2][2][2] == 255) {
			blueWin = true;
		}
		else if (image[0][0][2] == 255 && image[0][1][2] == 255 && image[0][2][2] == 255) {
			blueWin = true;
		}
		else if (image[0][0][2] == 255 && image[0][1][2] == 255 && image[0][2][2] == 255) {
			blueWin = true;
		}
		else if (image[1][0][2] == 255 && image[1][1][2] == 255 && image[1][2][2] == 255) {
			blueWin = true;
		}
		else if (image[2][0][2] == 255 && image[2][1][2] == 255 && image[2][2][2] == 255) {
			blueWin = true;
		}
		else if (image[0][0][2] == 255 && image[1][1][2] == 255 && image[2][2][2] == 255) {
			blueWin = true;
		}
		else if (image[2][0][2] == 255 && image[1][1][2] == 255 && image[0][2][2] == 255) {
			blueWin = true;
		}
		
		
		
		
		
	}
}
