import java.util

.Scanner;

public class Test {

	public static void main(String[] args) {
		
		    Loading L=new Loading("LOADING");
		    Scanner s=new Scanner(System.in);
			int end=6*7;
			char c='.';
			int res;
			int key=1;
			String ch="";
			Game G=new Game();
			L.run();
			System.out.println("\n"
					+ "********************************************************\n"
					+ "********************************************************\n"
					+ "*******************WELCOME TO FOUR-UP GAME**************\n"
					+ "********************************************************\n"
					+ "********************************************************\n");
			// MENU of the game
			do {
			System.out.println(" 1-START          / press 1");
			System.out.println(" 2-READ RULES     / press 2");
			System.out.println(" 3-EXIT           / press 3");
			System.out.print(">>");
			res=s.nextInt();
			
			
			
			switch(res) {
			case 1: 
				System.out.println(G);
				while(end>0 && c=='.')
				{
					
					c=G.play();
					System.out.println(G);
					end--;
				}
				if (end==0)System.out.println("Game over no winner");
				else System.out.println("Game over the winner is: PLAYER "+G.getCrtPL().getPL());
				System.out.println("<<hope you enjoyed>>");
				key++;
				break;
			case 2: 
				System.out.println("Connect four of your checkers in a row while preventing your opponent from doing the same.\n"
						+ "But, look out --"
						+ " your opponent can sneak up on you and win the game!");
				System.out.println("press 0 to return to MENU");
				key=s.nextInt();
				break;
			case 3:
				System.out.println("GOODBYE!");
				key++;
				break;
			default:
				System.out.println("This number doesnt refer to anything !");
				
			} 
			}while(key==0);
			
			
			}
}
		
	


