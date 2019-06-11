package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {
		//check all rows
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
		//int r=0 ,c = 0,d =0;
		int count;
		for(int i = 0; i<3; i++)
 			{
			   count = 0;
 				for(int j = 0; j<3; j++)
 	 			{
 	 				if (tic[i][j] == 1 && count <3)
 	 				{
 	 					count+= 1;
 	 				}
 	 				
 	 			}
 				if (count == 3)
	 				{
	 					return 1;
	 				}
	 				else
	 					{
	 					continue;}
 			}
 			
  		for(int i = 0; i<3; i++)
 			{  count = 0;
 				for(int j = 0; j<3; j++)
 	 			{
 	 				if (tic[i][j] == 2 && count < 3)
 	 				{
 	 					count+= 1;
 	 				}
 	 				
	 			}
 				if (count == 3)
	 				{
	 					return 2;
	 				}
	 				else
 					{continue;}
 			}
			
 
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
 		for(int i = 0; i<3; i++)
 			{   count = 0;
 				for(int j = 0; j<3; j++)
 	 			{  
 	 				if (tic[j][i] == 1 && count < 3)
 	 				{
 	 					count += 1;
 	 				}
 	 				
 	 			}
 				if (count == 3)
	 				{
	 					return 1;
	 				}
	 			else
	 				{continue;}
 			}
 		for(int i = 0; i<3; i++)
 			{  count = 0;
 				for(int j = 0; j<3; j++)
 	 			{
 	 				if (tic[j][i] == 2 && count < 3)
 	 				{
 	 					count += 1;
 	 				}
 	 			}
 				if (count == 3)
	 				{
	 					return 2;
	 				}
	 				else
				{continue;}

 			}
 
	
		//check both diagonals 
 		{
 			count = 0;
 			for(int j = 0; j<3; j++)
	 			{
	 				if (tic[j][j] == 2)
	 				{
	 					count += 1;
	 				}
	 			}
					
 			if (count == 3)
				{
					return 2;
				}
            count = 0;
 		
 			for(int j = 0; j<3; j++)
	 			{
	 				if (tic[j][j] == 1)
	 				{
	 					count += 1;
	 				}
	 			}		
 			if (count == 3)
				{
					return 1;
				}
			 
			return 0;
 		}
		
		//write your code here !!!
		
		
		
		
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		//check if a2 is between 0 & 3
		//check if the selected box is empty ie, already not marked by other player
		//if all checks passed return true.
		int f, f1,f2; 
		if (a1 < 3 && a1 >= 0 )
		{
			f = 1;
		}
		else 
			f = 0;
		if (a2 < 3 && a2 >=0 )
		{
			f1 = 1;
		}
		else 
			f1 = 0;
		if(f == 1 && f1 == 1)
		{
		if (tic[a1][a2] == 0)
		{
			return true;
		}
		else 
			return false;
		}
		
		/*if (f == 1 && f2 == 1 && f1 ==1)
		{
			return true;
		}
		

		//Write your code here !!!
		
		*/
		return false;  
	}
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		 int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
				//sc.close();
			}
			else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
				//sc.close();
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}