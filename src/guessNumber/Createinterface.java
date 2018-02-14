package guessNumber;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.event.*;
import javax.swing.*;


public class Createinterface extends JFrame  {
	public int k = 0;
	public String str;
	public String labelstr;
	public int guessnumber = 0;
	public int count = 0; 
	randomNumberset ran = new randomNumberset();
	public int number = ran.Numberset;
	guess g = new guess();
	JTextField input[] = new JTextField[10];  
	JButton button[] = new JButton[10];
	JLabel label[] = new JLabel[10];
	JLabel setting = new JLabel("Please enter four integer to guess number");
    JLabel condition = new JLabel(" ");
    JButton restart = new JButton("restart");
    
	
    
    public void Createinterface() {
		restart();
		setting.setBounds(20, 20, 250, 30);
	    condition.setBounds(100,500 ,80,30);
	    restart.setBounds(300, 20, 150, 30);

		for(int i=0; i<10; i++) {
			input[i] = new JTextField(10);
			input[i].setBounds(20, 50 + 40 * i, 80, 30);
			JTextField t=input[i];

			input[i].addKeyListener(new KeyListener() {	
				public void keyTyped(KeyEvent e) { 
				// TODO Auto-generated method stub 
					String s =t.getText(); 
				if(s.length() >= 4) e.consume(); 
			
			};
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

	
			});
		    label[i] = new JLabel(" ");
		    label[i].setBounds(220, 50 + 40 * i, 80, 30);
		    button[i] = new JButton("Guess");
		    button[i].setBounds(120, 50 + 40 * i, 80, 30);
	        button[i].setActionCommand("b" + i);
	        
	        button[i].addActionListener(new ActionListener() {	

	        public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button[count] || e.getSource() == input[count]) {
					button[count].setEnabled(false);
					try {
					String strguess = input[count].getText();

					guessnumber = Integer.valueOf(strguess);
					String newstring = g.guess(number, guessnumber);
					label[count].setText(newstring);
					count++;
					guesstrue(g.count_A);
					guessfalse(count);}
					catch(Exception m) {
						condition.setText("Error");
						for(int j=0;j<10;j++) {
							button[j].setEnabled(false);
						}
						
					}
						}
	        		}
	        	});
			}

		JFrame f = new JFrame("Guess Number Game");
		Container cp = f.getContentPane();
		cp.setLayout(null); 
		for(int i=0; i<10; i++) {
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			f.add(condition);
			f.add(input[i]);
			f.add(label[i]);
			f.add(button[i]);
			f.add(restart);
			f.add(setting);
		
			}
		f.setBounds(500, 500, 500,600);
		f.setVisible(true);
		}




    public void guesstrue(int countA) {
		if(countA == 4) {
			for(int k=count; k<10; k++) {
				button[k].setEnabled(false);
				condition.setText("你猜對了!");
			}
		}
	}	
	
	public void guessfalse(int count) {
		if(count > 9) {
			condition.setText("沒猜對再加油");
		}
	}
	
	public void restart() {
			restart.addActionListener(new ActionListener() {	
	        public void actionPerformed(ActionEvent e) {
	        	if(e.getSource() == restart) {
	        		for(int i=0; i<10; i++) {
	        			input[i].setText(" ");
	        			label[i].setText(" ");
	        			count = 0;
	    				button[i].setEnabled(true);
	        		}
	        	}
	        	
	        }
	});
}

}


    

