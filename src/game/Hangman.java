package game;
//import statements
import java.util.Scanner;
import java.util.Random;

public class Hangman {
	
	//Instance variable
	String word[]={"japan","qatar","syria","mongolia","bahrain","india"};
	public void showMenu()
	{
		int option;
		Scanner sc=new Scanner(System.in);
		System.out.println("----------Menu----------");
		System.out.println("1.Play Game");
		System.out.println("2.View Instructions");
		System.out.println("3.Exit Game");
		try{
			option=sc.nextInt();
		}
		catch(RuntimeException e){
			System.out.println("Please provide a valid numeric input");
		}
		System.out.println("\nChoose the option: ");
		option=sc.nextInt();
		//try-catch block
		option=0;
		try{
			option=sc.nextInt();
		}
		catch(RuntimeException e){
			System.out.println("Please provide a valid numeric input");
		}
		//switch case
		switch(option)
		{
		case 1:playGame();
			break;
		case 2:instructGame();
			break;
		case 3:exitGame();
			break;
		default:
			try{
				throw new MenuInputException();
			}
			catch(Exception e)
			{
				showMenu();
			}
		}
	}
	//Method definition
	public void playGame()
	{
		String guess,input;
		Scanner r=new Scanner(System.in);

		int len,i,count=0,rnd,flag=0;
		String choice,temp;
		System.out.println("Play game method is invoked");
		
		//playGame Functionality
		Random rd=new Random();
		Scanner in1=new Scanner(System.in);//generates a random no between -1 & 7 and assigns the same to variable rnd
		rnd=rd.nextInt(6);
		
		len=word[rnd].length();
		char[] newString=new char[len];
		StringBuffer wrgString=new StringBuffer();
		for(int j=0;j<len;j++)
		{
			System.out.println("_ ");
		}
		System.out.println();
		do
		{
			flag=0;
			System.out.println("\n\nEnter your guess: ");
			String ch=in1.nextLine().toLowerCase();
			//Implement user defined exception
			try{
				String ch1=input.nextLine().toLowerCase();
				if(ch1.length()!=1)
				{
					throw new WrongInputException();
				}
			count++;
			for(i=0;i<len;i++)
			{
				if(word[rnd].charAt(i)==ch.charAt(0))
				{
					newString[i]=word[rnd].charAt(i);
				}
			}
			if(flag==0)
			{
				flag=1;
				wrgString.append(ch + ",");
				System.out.println("\nMisses: " + wrgString);
			}
			System.out.println(newString);
			temp=new String(newString);
			
			if(word[rnd].equals(temp))
			{
				System.out.println("---------Congrats :) You Won---------");
				System.out.println("Do you want to play again(Y/N)");
				choice=in1.nextLine();
				if(choice.equalsIgnoreCase("y"))
				{
					playGame();
				}
				else
				{
					showMenu();
				}
			}
			}
			catch(WrongInputException e)
			{
				flag=1;
			}
		}while(flag!=0);
		
	}
	
	public void instructGame()
	{
		System.out.println("Instruction game method is invoked");
	}
	public void exitGame()
	{
		System.out.println("Exit game method is invoked");
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameWindow hg=new GameWindow();
		hg.addComponent();		
	}
}
