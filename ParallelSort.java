import java.util.Scanner;
import java.io.*;

class ParallelSort
{  // ParallelSort

	// (**) global variables here
	public static int[] numbers = new int[10000];
	public static String[] strings = new String[10000];

	public static void main(String args[])
	{ // main

		System.out.println("Reading in numbers");
		ReadNumbers();
		System.out.println("Reading in strings");
		ReadStrings();
		// (**) sort the arrays in parallel
		for (int z = 0; z < 9999; z++)
		{ // first position
			int position = 0;
			int minimum = 100000;
			for (int y = z; y < 10000; y++)
			{ // goes through integers
				if (numbers[y] < minimum)
				{ // changes minimum value
					minimum = numbers[y];
					position = y;
				} // changes minimum value
			} // goes through integers
			int swap = numbers[z];
			numbers[z] = minimum;
			numbers[position] = swap;
			String swp = strings[z];
			strings[z] = strings[position];
			strings[position] = swp;
		} // first position
		for (int x = 0; x < 10000; x++)
		{ // prints each int and string
			System.out.println(numbers[x] + " " + strings[x]);
		} // prints each int and string
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

	public static void ReadStrings()
	{ // Read the strings in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("randstrings.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one string
				x++;
				if ((x % 100) == 0)
				{ System.out.print("."); }
				strings[x] = s;
			}  // read in one string
		} catch (IOException ex) {};

		System.out.println("Strings read!");

		// [**] test the code
		//	for (x=0; x<10000; x++)
		//	{ System.out.println(strings[x]); }

	} // Read the strings in from a file

}  // ParallelSort
