package game;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame{
	
	JButton option1;
	JButton option2;
	JButton option3;
	JLabel name;
	
	public Menu()
	{
		option1=new JButton("Play Game");
		option2=new JButton("View Instructions");
		option3=new JButton("Exit");
		name=new JLabel("HANGMAN");
		name.setFont(new Font("Serif",Font.PLAIN,24));
		setTitle("Hangman Game");
		setSize(300,200);
		setResizable(false);
		setVisible(true);
	}
	public void addComponent()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.1;
		c.anchor=c.CENTER;
		add(name,c);
		
		c.gridx=0;
		c.gridy=1;
		c.fill=c.HORIZONTAL;
		add(option1,c);
		
		c.gridx=0;
		c.gridy=2;
		c.fill=c.HORIZONTAL;
		add(option2,c);
		
		c.gridx=0;
		c.gridy=3;
		c.fill=c.HORIZONTAL;
		add(option3,c);
	}
}
