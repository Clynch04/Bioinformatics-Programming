import java.util.Scanner;
import java.io.*;

class SortMe
{  // SortMe

	// (**) global variables here
	public static int[] numbers = new int[10000];

	public static void main(String args[])
	{ // main

		System.out.println("Reading in numbers");
		ReadNumbers();

		// (**) write a method to sort the numbers using one of the five from lecture
		for (int z = 0; z < 9999; z++)
		{ // first position
			int position = 0;
			int minimum = 100000;
			for (int y = z; y < 10000; y++)
			{ // goes through array
				if (numbers[y] < minimum)
				{ // changes minimum value
					minimum = numbers[y];
					position = y;
				} // changes minimum value
			} // goes through array
			int swap = numbers[z];
			numbers[z] = minimum;
			numbers[position] = swap;
		} // first position
		for (int x = 0; x < 10000; x++)
		{ // Goes through each number
			if (numbers[x] < 10)
			{
				System.out.print("    " + numbers[x] + " ");
			}
			if ((numbers[x] < 100) && (numbers[x] > 9))
			{
				System.out.print("   " + numbers[x] + " ");
			}
			if ((numbers[x] < 1000) && (numbers[x] > 99))
			{
				System.out.print("  " + numbers[x] + " ");
			}
			if ((numbers[x] < 10000) && (numbers[x] > 999))
			{
				System.out.print(" " + numbers[x] + " ");
			}
			if (numbers[x] > 9999)
			{
				System.out.print(numbers[x] + " ");
			}
		} // Goes thorugh each number
	} // main

	public static void ReadNumbers()
	{ // Read the numbers in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randnumbers.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one sequence
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				numbers[x] = Integer.parseInt(s);
			}  // read in one sequence
		} catch (IOException ex) {};

		System.out.println("Numbers read!");

		// [**] test the code
		//	for (x=0; x<10000; x++)
		//	{ System.out.println(numbers[x]); }

	} // Read the numbers in from a file

}  // SortMe
