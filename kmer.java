import java.io.*;

class kmer
{ // class kmer

	public static String seq;
	public static int[] intseq = new int[18];
	public static int[] counts = new int[256];

	public static void main(String args[])
	{ // main

		ReadSeq();
		Encode();
		Window();
		DeEncode();
	} // main

	public static void Encode()
	{ // encode
		for (int x = 0; x < seq.length(); x++)
		{ // string to integers
			if (seq.charAt(x) == 'A')
			{
				intseq[x] = 0;
			}
			if (seq.charAt(x) == 'T')
			{
				intseq[x] = 1;
			}
			if (seq.charAt(x) == 'G')
			{
				intseq[x] = 2;
			}
			if (seq.charAt(x) == 'C')
			{
				intseq[x] = 3;
			}
		} // string to integers
	//	for (int z = 0; z < 18; z++)
	//	{System.out.print(intseq[z]);}
	} // encode

	public static void Window()
	{ // window
		for (int c = 0; c < 256; c++)
		{ // initialize array to all 0's
			counts[c] = 0;
		} // initialize array to all 0's

		int value;
		for (int y=0; y < (seq.length() - 3); y++)
		{ // iterates over window
			value = (intseq[y]*64 + intseq[y+1]*16 + intseq[y+2]*4 + intseq[y+3]);
	//		System.out.println(value);
			counts[value] += 1;
		} // iterates over window

	} // window

	public static void DeEncode()
	{ // DeEncode
		int base;
		int num;
		for (int r = 0; r < 256; r++)
		{ // check array
			if (counts[r] > 0)
			{ // de-encode integers
				int holder = r;
				String four = "";
				for (int s = 0; s < 4; s++)
				{ // adds char to string
					base = (holder % 4);
					switch(base)
					{ // prints seq
						case 0:
						four = "A" + four;
						break;
						case 1:
						four = "T" + four;
						break;
						case 2:
						four = "G" + four;
						break;
						case 3:
						four = "C" + four;
						break;
					} // prints seq
					num = (holder - base);
					holder = (num / 4);
				} // adds char to string
				System.out.println(four + "   " + counts[r]);
			} // de-encode integers
		} // check array
	} // DeEncode

	public static void ReadSeq()
	{ // reads in DNA seq

	String s;

	try
	{ // try
		FileReader file = new FileReader("kmersample.txt");
		BufferedReader br = null;

		br = new BufferedReader(file);

		while((s=br.readLine()) != null)
		{
			seq = s;
		}
	} // try
	catch (IOException ex) {};

	System.out.println(seq);

	} // reads in DNA seq


} // class kmer
