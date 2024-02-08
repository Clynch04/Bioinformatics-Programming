import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class GOL implements ActionListener
// class GOL
{ // GOL

	JFrame jfrm = new JFrame("Game of Life");
	JButton jbtn;
	static boolean[][] matrix = new boolean[20][20];
	myPanel panel = new myPanel();
	static boolean[][] matrix2 = new boolean[20][20];

	GOL()
	{ // constructor
		jfrm.setSize(700,500);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jbtn = new JButton("Step");
		jbtn.addActionListener(this);
		jfrm.add(jbtn,BorderLayout.WEST);
		jbtn = new JButton("Reset");
		jbtn.addActionListener(this);
		jfrm.add(jbtn,BorderLayout.EAST);
		for(int x = 0; x < 20; x++)
		{ // initialize matrix
			for(int y = 0; y < 20; y++)
			{
				matrix[x][y] = false;
			}
		} // initialize matrix
		matrix[8][8] = true;
		matrix[9][9] = true;
		matrix[10][9] = true;
		matrix[8][10] = true;
		matrix[9][10] = true;
		jfrm.add(panel,BorderLayout.CENTER);
		jfrm.setVisible(true);
	} // constructor

	public void actionPerformed(ActionEvent ae)
	{ // button events
		int alive;
		if(ae.getActionCommand().equals("Step"))
		{ // step button
			for(int x = 0; x < 20; x++)
			{ // matrix 2 row
				for(int y = 0; y < 20; y++)
				{ // matrix 2 col
					matrix2[x][y] = false;
					alive = 0;
					for(int row = -1; row < 2; row++)
					{
						for(int col = -1; col < 2; col++)
						{
							int nr = x + row;
							int nc = y + col;
							if(nr == -1)
							{
								nr = 19;
							}
							if(nr == 20)
							{
								nr = 0;
							}
							if(nc == -1)
							{
								nc = 19;
							}
							if(nc == 20)
							{
								nc = 0;
							}
							if(matrix[nr][nc] == true)
							{
								alive += 1;
							}
						}
					}

					if(matrix[x][y] == true)
					{ // alive cells
						alive -= 1;
						if(alive == 2)
						{
							matrix2[x][y] = true;
						}
						if(alive == 3)
						{
							matrix2[x][y] = true;
						}
					} // alive cells
					if(matrix[x][y] == false)
					{ // dead cells
						if(alive == 3)
						{
							matrix2[x][y] = true;
						}
					} // dead cells
				} // matrix 2 col
			} // matrix 2 row
			for(int x = 0; x < 20; x++)
			{
				for(int y = 0; y < 20; y++)
				{
					matrix[x][y] = matrix2[x][y];
				}
			}
			jfrm.revalidate();
			jfrm.repaint();
		} // step button
		if(ae.getActionCommand().equals("Reset"))
		{ // reset button
		//	jfrm.remove(panel);
		//	panel = new myPanel();
		//	jfrm.add(panel,BorderLayout.CENTER);
		//	jfrm.validate();
			for(int x = 0; x < 20; x++)
			{ // initialize matrix
				for(int y = 0; y < 20; y++)
				{
					matrix[x][y] = false;
				}
			} // initialize matrix
			matrix[8][8] = true;
			matrix[9][9] = true;
			matrix[10][9] = true;
			matrix[8][10] = true;
			matrix[9][10] = true;
			jfrm.revalidate();
			jfrm.repaint();
		} // reset button
	} // button events



	public static void main(String args[])
	{ // main
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() {new GOL();}
		});
	} // main

	class myPanel extends JPanel
	{ // panel
		public myPanel()
		{ // initialization
			setBorder(BorderFactory.createLineBorder(Color.black));
		} // initialization
		public Dimension getPreferredSize()
		{ // size
			return new Dimension(400,400);
		} // size
		protected void paintComponent(Graphics g)
		{ // drawing
			super.paintComponent(g);
			int pixels = 20;
			for(int x = 0; x < 20; x++)
			{ // create original panel
				for(int y = 0; y < 20; y++)
				{
					if(matrix[x][y] == true)
					{ // alive cell
						g.setColor(Color.white);
						g.fillRect(x*20,y*20,pixels,pixels);
						g.drawRect(x*20,y*20,pixels,pixels);
					} // alive cell
					else
					{ // dead cell
						g.setColor(Color.black);
						g.fillRect(x*20,y*20,pixels,pixels);
						g.drawRect(x*20,y*20,pixels,pixels);
					} // dead cell
				}
			} // create original panel

		} // drawing
	} // panel

} // GOL
