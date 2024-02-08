import java.util.*;
import java.io.*;

class QueueStackTree
{  // class

	static int[] values = new int[20];
	static Queue<Integer> myqueue = new LinkedList<>();
	static Stack<Integer> mystack = new Stack<>();

	public static void main(String args[])
	{ // main

		GetNumbers();
		QueueStack();
	} // main

	static void GetNumbers()
	{ // Read the numbers in from a file

		String s;
		int x;

		try{

			FileReader file = new FileReader("StackQueueNumbers.txt");
			BufferedReader br = null;

			br = new BufferedReader(file);

			x = -1;

			while ((s = br.readLine()) != null)
			{  // read in one sequence
				x++;
				values[x] = Integer.parseInt(s);
			}  // read in one sequence
		} catch (IOException ex) {};

	} // Read the numbers in from a file

	static void QueueStack()
	{ // queue stack
		for(int y = 0; y < 20; y++)
		{
			mystack.push(values[y]);
			myqueue.add(values[y]);
		}
		System.out.println("Stack:");
		for(int z = 0; z < 20; z++)
		{
			System.out.println(mystack.peek());
			mystack.pop();

		}
		System.out.println("Queue:");
		for(int k = 0; k < 20; k++)
		{
			System.out.println(myqueue.peek());
			myqueue.remove();
		}
	} // queue stack
}  // class
