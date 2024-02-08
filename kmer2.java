import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

class kmer2
{ // class kmer

	static String seq = "";
	static Scanner input = new Scanner(System.in);
	static int length;

	public static void main(String args[])
	{ // main

		ReadSeq();
		windowsize();
		hashmap();
	} // main


	static void ReadSeq()
	{ // reads in DNA seq

	String s;

	try
	{ // try
		FileReader file = new FileReader("kmersample_Week14.txt");
		BufferedReader br = null;

		br = new BufferedReader(file);

		while((s=br.readLine()) != null)
		{
			seq += s;
		}
	} // try
	catch (IOException ex) {};

	System.out.println(seq);

	} // reads in DNA seq

	static int windowsize()
	{ // window size
		System.out.println("Enter a window length that is 6 or less");
		length = input.nextInt();
		return length;
	} // window size


	static void hashmap()
	{ // hashmap
		HashMap<String, Integer> kmers = new HashMap<String, Integer>();
		for (int x = 0; x < (seq.length() - length + 1); x++)
		{
			String current = seq.substring(x,(x + length));
			if(kmers.containsKey(current))
			{
				kmers.put(current, (kmers.get(current) + 1));
			}
			else
			{
				kmers.put(current, 1);
			}
		}
		for (String i : kmers.keySet())
		{
			System.out.println(i + " " + kmers.get(i));
		}
	} // hashmap


} // class kmer
