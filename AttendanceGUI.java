
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

 
public class AttendanceGUI{ 
    
    public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setSize(600,300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setResizable(false);
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    
		// width will store the width of the screen
		int width = (int)size.getWidth();
    
		// height will store the height of the screen
		int height = (int)size.getHeight();
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
	
		panel1.setPreferredSize(new Dimension(100,50));
		panel2.setPreferredSize(new Dimension(100,50));
		panel3.setPreferredSize(new Dimension(width/3,100));
		panel4.setPreferredSize(new Dimension(width/3,100));
		panel5.setPreferredSize(new Dimension(width/3,100));
	
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.green);
		panel3.setBackground(Color.yellow);
		panel4.setBackground(Color.magenta);
		//panel5.setBackground(Color.blue);
		
		frame.add(panel1,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.SOUTH);
		frame.add(panel3,BorderLayout.EAST);
		frame.add(panel4,BorderLayout.WEST);
		frame.add(panel5,BorderLayout.CENTER);
		
		TableDemo t = new TableDemo();
		
		//JScrollPane jp = new JScrollPane();
		//jp.add(t);
		panel5.add(t);
		//frame.pack();
		panel5.revalidate();
		panel5.repaint();
		
		
		
    }
}