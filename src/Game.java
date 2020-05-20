/* The Game has 3 PLAYERS , after every round we swith the third player between X and O as the symbols 
 which represent the colored discs: RED and YELLOW, in the Real Game */

import java.util.Scanner;
public class Game {
	private char[][] Board;
	private Player crtPL=new Player(); // A player who takes the symbol X 
	Player x=new Player('X');
	Player o=new Player('O');
	Scanner sc=new Scanner(System.in);
	
	public Game()
	{
		Board=new char[6][7];

		for(int i=0;i<6;i++)
		{
			for(int j=0;j<7;j++)
			{
				Board[i][j]='*'; // Initialisation of the board with the character " * "
		
			}
		}
	}

	public Player getCrtPL() {
		return crtPL;
	}

	public void setCrtPL(Player crtPL) {
		this.crtPL = crtPL;
	}
	public String toString()
	{
            /* Framing of The Game's Board */
		String ch="";
		for(int i=0;i<21;i++) //First frame on the top
		{
			ch+="-";
		}
		ch+="\n";
		for(int i=0;i<6;i++)
		{
			ch+="|"; // Second Frame on the right 
			for(int j=0;j<7;j++)
			{
				ch+=Board[i][j];
				if(j!=6)ch+="  ";
			}
			ch+="|"; // Third one on the left 
			ch+="\n";
			
		}
		for(int i=0;i<21;i++)
		{
			ch+="-"; // Last one Below
		}
		return ch;
	}
	 // Method of playing The Game 
	
	public char play()
	{
		char cr=crtPL.getPL();
		int j=0;
		System.out.println("your turn player "+ crtPL.getPL());
		while(!choose(j)||Board[0][j-1]!='*')
		{
			System.out.println("choose a column between 1 & 7 :");
			j=sc.nextInt();
			if(Board[0][j-1]!='*')System.out.println("This column is full");
			
		}
		int i=5;
		boolean found=false;
		while(i>=0 && found==false )
		{
			//enpilage
			if(Board[i][j-1]=='*') {
			Board[i][j-1]=crtPL.getPL(); // We place the symbol of the current player in its place
			found=true; // The disc is successfully dropped in the right place on the board 
			}
			else i--;
		}
		//Victory conditions
		int a,b,s;
		int max=0;
		//vertically
		a=i;b=j-1;s=-1;
		while(a>=0 && Board[a][b]==cr) {a--;s++;}
		a=i;
		while(a<6 && Board[a][b]==cr) {a++;s++;}
		if(s > max) max= s;
		if(max>=4) return cr;
		
		//horizontally
		a=i;b=j-1;s=-1;
		while(b>=0 && Board[a][b]==cr) {b--;s++;}
		b=j-1;
		while(b<7 && Board[a][b]==cr) {b++;s++;}
		if(s > max) max= s;
		if(max>=4) return cr;
		
		//diagonal HG-BD
		a=i;b=j-1;s=-1;
		while(a>=0 && b>=0 && Board[a][b]==cr) {a--;b--;s++;}
		a=i;b=j-1;
		while(a<6 && b<7 && Board[a][b]==cr) {a++;b++;s++;}
		if(s>max)max=s;
		if(max>=4) return cr;
		
		
		//Diagonal HD-BG
		a=i;b=j-1;s=-1;
		while(a<6 && b>=0 && Board[a][b]==cr) {a++;b--;s++;}
		a=i;b=j-1;
		while(a>=0 && b<7 && Board[a][b]==cr) {a--;b++;s++;}
		if(s>max)max=s;
		if(max>=4) return cr;
		
		//Switching Players 
		
		if(getCrtPL().getPL()!='O')
		setCrtPL(o);
		else setCrtPL(x);
		
		
		return '.';		
	}
	// Method for choosing column to play 
	public boolean choose(int j)
	{
		if(j<1||j>7) return false;
		else
			{
			return true;
			}
	}

	
}
