import java.util.Scanner;

class ProtDom
{ // Protein domain finder

	// (**) insert global variables here if needed

	static Scanner input = new Scanner(System.in);
	static String[] domain = new String[10];
	static int numdomains = 0;
	static boolean validity;
	static int x = 0;
	static String protseq = new String(getProseq());

	public static void main(String args[])
	{ // main

	//	getProseq();
		getdomain();
	//	validdomain();
		checkvalidity();

	} // main

	// (**) insert other methods here as needed
	static String getProseq()
	{ // get protein sequence
		System.out.println("Enter your protein sequence");
		String prot = input.nextLine();
		prot = prot.toUpperCase();
	//	System.out.println(prot);
		return prot;
	} // get protein sequence

	static String[] getdomain()
	{ // get domains
		System.out.println("Enter your domains. Type STOP when finished.");
		for (int x=0; x < 10; x++)
		{ // reading domains
			String c = input.nextLine();
			c = c.toUpperCase();
			if (!(c.equals("STOP")))
			{ // add domains to array
				domain[x] = c;
				numdomains++;
	//			System.out.println(c);
			} // add domains to array
			else
			{ // stop
				return domain;
			} // stop
		} // reading domains
		return domain;
	} // get domains
	static boolean validdomain()
	{ // valid domain
		validity = true;
		for (int y=0; y < domain[x].length(); y++)
		{ // go through each char
				if (domain[x].charAt(y)== 'A')
				{
				}
				else if (domain[x].charAt(y)== 'C')
				{
				}
				else if (domain[x].charAt(y)== 'D')
				{
				}
				else if (domain[x].charAt(y)== 'E')
				{
				}
				else if (domain[x].charAt(y)== 'F')
				{
				}
				else if (domain[x].charAt(y)== 'G')
				{
				}
				else if (domain[x].charAt(y)== 'H')
				{
				}
				else if (domain[x].charAt(y)== 'I')
				{
				}
				else if (domain[x].charAt(y)== 'K')
				{
				}
				else if (domain[x].charAt(y)== 'L')
				{
				}
				else if (domain[x].charAt(y)== 'M')
				{
				}
				else if (domain[x].charAt(y)== 'N')
				{
				}
				else if (domain[x].charAt(y)== 'P')
				{
				}
				else if (domain[x].charAt(y)== 'Q')
				{
				}
				else if (domain[x].charAt(y)== 'R')
				{
				}
				else if (domain[x].charAt(y)== 'S')
				{
				}
				else if (domain[x].charAt(y)== 'T')
				{
				}
				else if (domain[x].charAt(y)== 'V')
				{
				}
				else if (domain[x].charAt(y)== 'W')
				{
				}
				else if (domain[x].charAt(y)== 'Y')
				{
				}
				else
				{ // invalid
					validity = false;
				} // invalid
		} // go through each char
		x++;
		return validity;
	} // valid domain

	static String[] checkvalidity()
	{ // check validity
		for (int x=0; x < numdomains; x++)
		{ // go through each domain
			validdomain();
			if (validity == true)
			{ // valid
		//		System.out.println(domain[x]);
		//		System.out.println(protseq);
			//	searchdomain();
				for (int z=0; z < (protseq.length() - domain[x].length() + 1); z++)
				{ // go through protein seq
					if (protseq.substring(z,(z + (domain[x].length()))).equals(domain[x]))
					{ // searches for domain
						System.out.println(domain[x] + " " + (z+1));
					} // searches for domain
				} // go through protein seq
			} // valid
			if (validity == false)
			{ // invalid
				System.out.println(domain[x] + " Invalid Amino Acid");
			} // invalid
		} // go through each domain
		return domain;
	} // check validity

	static String[] searchdomain()
	{ // search domain
		for (int z=0; z < (protseq.length() - domain[x].length() + 1); z++)
		{ // go through protein seq
			if (protseq.substring(z,(z + (domain[x].length()))) == domain[x])
			{ // searches for domain
				System.out.println(domain[x] + " " + (z+1));
			} // searches for domain
		} // go through protein seq
		return domain;
	} // search domain

} // Protein domain finder

