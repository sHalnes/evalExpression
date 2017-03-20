package assignment1;

import java.util.Scanner;
import java.util.Stack;

/**
 * The program can evaluate simple arithmetic equations
 * UPDATED VERSION: now the solution support multi-digit input (up to 2 digits).
 * */

public class simpleExpressions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Type in an expression: ");
		String expression = in.nextLine();
		//to evaluate the expression I'm going to use two stacks: 
		// one for chars and one for integers
		Stack<Integer> st_int = new Stack<Integer>();
		Stack<Character> st_char = new Stack<Character>();
		// Since we use only "+" and "*" operations the variable for answer 
		// can be of primitive type int
		int answer = 0;
		do{
			for(int i = 0; i < expression.length(); i++){
				if(Character.isDigit(expression.charAt(i))){
					int x = Character.getNumericValue(expression.charAt(i));
					if(Character.isDigit(expression.charAt(i+1))){
							int y = Character.getNumericValue(expression.charAt(i+1));
							i++;
							int number = x*10 + y;
							st_int.push(number);
					}
					else{
						if(x != -1){
							st_int.push(x);
							}
					}
				}
				else{
					char ch = (char)(expression.charAt(i));
					if(ch != '='){
						st_char.push(ch);
						}
					else{
						char sign = st_char.pop();
						if(sign == '+'){
							answer = st_int.pop() + st_int.pop();
							st_int.push(answer);
						}
						else{
							answer = st_int.pop() * st_int.pop();
							st_int.push(answer);
						}
					}
					}

			}
			System.out.println(st_int.pop());
		}
		while(!st_char.isEmpty());
		
		in.close();
	}

}

