import java.util.Scanner;

/*
 * @author David Stokes
 * 
 * @version 11/18/18
 * 
 * description: This program can search though an array of books using a binary or linear search and find the book 
 * and calculate its cost. The program can also sort through an array of random numbers and order them using a selection sort or a bubble sort.
 * 
 * 
 * Pseudocode:
 * The program displays the menu.
 * 
 * the program then uses if statements to determine the users input and calls the method needed
 * 
 * If the user choose option one then the linear search is used in which it uses a for loop with an if statement to go through every index in the array and checks for equality.
 * 
 * if the user chooses option 2 then binary sort is used where the program will check the middle index of the array and then if the search value is less then it will check the middle of the left of the original middle
 * this program then continues this until the value is found.
 * 
 * Once the user chooses option 1 or 2 and the search is complete they are informed if the book id was found and the user is then asked how many books they want to purchase the associated price is multiplied by the number of books and the user is told.
 * 
 * if the user chooses three the bubble sort is used which takes an array of 10 random numbers between 0 and 500 and sorts them. 
 * the program checks if each index is bigger than the next and loops through the array until it reaches the end and then loops again but not checking the last index decrementing the overall search area by one each time until it is sorted.
 * 
 * if the user chooses 4 a selection sort is used to sort the rng'ed array and the getMin method finds the lowest value in the array and swaps it with the first index and then the method finds the smallest value ignoring the first index and swaps it with the second until the array is sorted/
 * 
 * All four options have a timer that starts on the call by checks the system time and then stoping the line after the method is called to find the execution time of the function
 * 
 * 
 */


public class Assignment_3 {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		int choice = 1;
		
		//loop until user exits
		while (choice != 5) {
		System.out.println("Please enter a menu choice");
		System.out.println("1.                  Linear Search \r\n" + 
				"2.                  Binary Search \r\n" + 
				"3.                  Bubble Sort \r\n" + 
				"4.                  Selection Sort \r\n" + 
				"5.                  Quit \r\n" + 
				"");
		
		choice = input.nextInt();
	
		//does not create arrays unless they will be used
		if (choice == 1 || choice == 2) {
		//10 in array
		String[] bookTitle = {"Starting out with Java", "Java Programming", "Software Structures", "Design and Analysis of Algorithms",
				"Computer Graphics", "Artifical Intelligence: A Modern Approach", "Probaility and Statistics", "Cognitive Science",
				"Modern Information Retrieval", "Speech and Language Processing" };
		
		//10 in array
		int[] bookID = {1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999};
		
		//10 in array
		double[] bookPrice = {112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75};
		

		
		if (choice == 1) {
			//print book menu
			display(bookTitle, bookID, bookPrice);
			
			
			System.out.println("Please enter the book ID you would like to purchase");
			//get user book
			int userID = input.nextInt();
			
			System.out.println("Please enter the number of copies you want to buy");
			
			int copies = input.nextInt();
			//timer start
			long start = System.nanoTime();
			
			int booksIndex = linearSearch(userID, bookID);   
			
			//stop time
			long stop = System.nanoTime();
			double total = (stop - start) / 1000000000.0;
			System.out.printf("The function execution took  %.8f seconds\n", total);
			
			//if book id is valid
			if (booksIndex != -1) {
			//display outputs
			System.out.println("Book ID: " + bookID[booksIndex]);
			
			System.out.println("Book Title: " + bookTitle[booksIndex]);
			
			System.out.println("Number of books bought " + copies);
			
			System.out.println("Total Cost: " + copies * bookPrice[booksIndex]);
			}
			else {
				System.out.println("That book ID does not exist.");
			}
			
			
		}
		else if (choice == 2) {
			//print book menu
			display(bookTitle, bookID, bookPrice);
			
			System.out.println("Please enter the book ID you would like to purchase");
			
			int userID = input.nextInt();
			
			System.out.println("Please enter the number of copies you want to buy");
			
			int copies = input.nextInt();
			//start timer
			long start = System.nanoTime();
			
			int booksIndex = binarySearch(userID, bookID, bookID.length);
			//end timer and display
			long stop = System.nanoTime();
			double total = (stop - start) / 1000000000.0;
			System.out.printf("The function execution took  %.8f seconds\n", total);
			
			//if book id is  valid
			if (booksIndex != -1) {
			
				//display output
			System.out.println("Book ID: " + bookID[booksIndex]);
			
			System.out.println("Book Title: " + bookTitle[booksIndex]);
			
			System.out.println("Number of books bought " + copies);
			
			System.out.println("Total Cost: " + copies * bookPrice[booksIndex]);
			}
			else {
				System.out.println("That book ID does not exist.");
			}
		}
			
			
			
			
		
		}
		else if (choice == 3) {
			//random array is generated and store
			int[] numbers = genArray();
			//start timer
			long start = System.nanoTime();
			
			//bubble sort
			bubbleSort(numbers);
			
			//stop timer and display
			long stop = System.nanoTime();
			double total = (stop - start) / 1000000000.0;
			System.out.printf("The function execution took  %.8f seconds\n", total);
			
			
			//print sorted array
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
			
		}
		else if (choice == 4) {
			//random array is generated and stored
			int[] numbers = genArray();
			//start timer
			long start = System.nanoTime();
			//selection sort
			selectionSort(numbers);
			//stop timer and display
			long stop = System.nanoTime();
			double total = (stop - start) / 1000000000.0;
			System.out.printf("The function execution took  %.8f seconds\n", total);
			
			//diplay sorted array
			for (int i = 0; i < numbers.length; i++) {
				System.out.println(numbers[i]);
			}
			
		}
		//user exits break from loop
		else if (choice == 5) {
			System.out.println("Goodbye Stefan");
			break;
		}
		else {
			System.out.println("Please enter a valid menu choice.");
		}
		
		
		
		}
		
		

	}
	
	public static void display(String[] bookTitle, int[] bookID, double[] bookPrice) {
		//print array
		
		//print the menu using for loop and tabs
		System.out.println("Book Titles " + "\t\t\t" + "book ID" + "\t\t\t" + "Book Price");
		for (int i = 0; i < bookTitle.length; i++) {
			System.out.println(bookID[i] + "\t\t\t" + bookTitle[i] + "\t\t\t" + bookPrice[i]);
			}
			
			

		}
	
	
	public static int linearSearch(int ID, int[] bookID) {
		int i;
		//check every value in the array for equality to the user input search parameter
		for (i = 0; i < bookID.length; i++) {
			if (ID == bookID[i]) {
				return i;
			}
			
		}
		//book id was not found
		return -1;
		
		
	}
	
	public static int binarySearch(int ID, int[] bookID, int elementLength) {
		int first = 0, last = elementLength;
		int middle;
		//loop through
		for (int i = 0; i < elementLength; i++) {
			middle = (first + last) / 2;
			if (ID == bookID[middle]) {
				return middle;
				
			}
			else if (ID > bookID[middle]) {
				//makes new search bounds
				first = middle;
			}
			else if (ID < bookID[middle]) {
				//makes new search bounds
				last = middle;
			}
		}
		return -1;
	}
	
	
	public static int[] genArray() {
		int[] array = new int[10];
		
		//for each element in the array set it equal to a random number between 1 to 500
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random()* (500)) + 1;
		}
		return array;
	}
	
	public static void bubbleSort(int[] numbers) {
	
		int i;
		
		
		//a decreases by one each run until it reaches zero
			for ( int a = numbers.length - 1; a > -1; a--) {
				//each loop of the parent loop the 
				for (i = 0; i < a; i++) {
					if (numbers[i] > numbers[i + 1]) {
						swap(i, i + 1, numbers);
						
					}
				}
			}
	
	}
	
	public static void selectionSort(int[] numbers) {
		
		//loop through array
		for (int a = 0; a < numbers.length - 1; a++) {
			//swap index with lowest
			swap(a, (getMin(a, numbers)), numbers);	
				}
			}
			
		
	
	public static int getMin(int a, int[] numbers) {
		int i;
		int index = 0;
		//no numbers will be greater than 500
		int lowest = 502;
		//loop through array
		for (i = a; i < numbers.length; i++) {
			
			//if index checked is lower make it lowest and store index
			if (numbers[i] < lowest) {
				lowest = numbers[i];
				index = i;
				
			}
			
			
		}
		return index;
	}
	

		
	
	
	public static void swap(int a, int b, int[] array) {
		//swaps values of array
		int temp = array[a];
		 array[a] = array[b]; 
		 array[b] = temp;
		
	}
	

	}


