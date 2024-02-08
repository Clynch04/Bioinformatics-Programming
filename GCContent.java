import java.util.Scanner;

class GCContent
{ // GC Content calculator

	public static void main(String args[])
	{ // main
		while (true)
		{ // repeat program
			String seq = getDNAseq();
			seq = seq.toUpperCase();
			int seqlength = seq.length();
			float GCCounter = 0;
			float ATCounter = 0;
			if (seq.equals("STOP"))
			{ // Stops program
				return;
			} // Stops program
			for(int x=0; x < seq.length(); x++)
			{ // read through sequemce
				if ((seq.charAt(x)== 'G') || (seq.charAt(x)== 'C'))
				{ // GC Counter
					GCCounter += 1;
				} // GC Counter
				else if ((seq.charAt(x)== 'A') || (seq.charAt(x)== 'T')) 
				{ // AT Counter
					ATCounter += 1;
				} // AT Counter
				else
				{ // invalid sequence
					System.out.println("Invalid sequence.  Please only input the nucleotides A,C,T,G.");
				} // invalid sequence
			} // read through sequence
			System.out.println(seqlength + " bp");
			System.out.println((GCCounter / seqlength)* 100 + "% GC");
			System.out.println((ATCounter / seqlength)* 100 + "% AT");
		} // repeat program
	} // main

	static String getDNAseq()
	{ // get DNA sequence
		System.out.println("Enter your DNA sequence(A,C,T,G), or type STOP to end program.");
		Scanner input = new Scanner(System.in);
		String ATCG = input.nextLine();
		return ATCG;
	} // get DNA sequence

} // GC Content calculator
