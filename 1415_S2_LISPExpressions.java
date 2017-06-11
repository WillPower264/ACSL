package ACSL;
import cs1.Keyboard;

public class ACSLContest2 {

	public static void main(String[] args) {
		expression1();
		expression2();
		expression3();
		expression4();
		expression5();
	}
	
	public static void expression1(){
		String input = Keyboard.readString(), result = ")";
		boolean begin = false, lastChar = true;
		for (int i = 0; input.charAt(i) != ')'; i++){
			if (input.charAt(i) == '('){
				begin = true; i++;}
			if (begin){
				while (input.charAt(i) == ' ') i++;
				if (lastChar){
					result = input.charAt(i) + result;
					lastChar = false; }
				else
					result = input.charAt(i) + " " + result;
			}
		}
		result = "'(" + result;
		System.out.println(result);
	}

	public static void expression2(){
		String input = Keyboard.readString(), output = "'(";
		boolean begin = false, change = false, done = false, firstList = true;
		int counter; char temp;
		
		for (int i = 0; !done; i++){
			if (input.charAt(i) == '('){
				begin = true; i++;}
			counter = 1; temp = ' '; change = false; //reset values
			if (begin){
				while (!change){
					while (input.charAt(i) == ' ') i--;
					temp = input.charAt(i);
					if (input.charAt(i + 1) == ')'){
						done = true; break; }
					i += 2;
					if (input.charAt(i) == temp)
						counter++;
					else
						change = true;
				}
				if (firstList){
					output += "(" + counter + " " + temp + ")";
					firstList = false;
				}
				else
					output += " (" + counter + " " + temp + ")";
				
			}
		}
		output += ")";
		System.out.println(output);	
	}

	public static void expression3(){
		String input = Keyboard.readString(), output = "'(";
		boolean begin = false, change = false, done = false, firstList = true;
		int counter; char temp;
		
		for (int i = 0; !done; i++){
			if (input.charAt(i) == '('){
				begin = true; i++;}
			counter = 1; temp = ' '; change = false; //reset values
			if (begin){
				while (!change){
					while (input.charAt(i) == ' ') i--;
					temp = input.charAt(i);
					if (input.charAt(i + 1) == ')'){
						done = true; break; }
					i += 2;
					if (input.charAt(i) == temp)
						counter++;
					else
						change = true;
				}
				if (firstList){
					if (counter == 1)
						output += temp;
					else
						output += "(" + counter + " " + temp + ")";
					firstList = false;}
				else
					if (counter == 1)
					output += " " + temp;
					else
					output += " (" + counter + " " + temp + ")";
			}
		}
		output += ")";
		System.out.println(output);	
	}

	public static void expression4(){
		String input = Keyboard.readString(), output = "'";
		int number = input.charAt(input.length() - 2) - '0', counter = 0;
		boolean begin = false;
		
		
		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '('){
				begin = true; counter++;
				if (counter % number != 0)
					output += input.charAt(i); 
				i++;
			}
			if (begin){
				if (counter % number != 0)
					output += input.charAt(i);
			}
		}
		output += number + ")";
		System.out.println(output);
	}

	public static void expression5(){
		String input = Keyboard.readString(), output = "";
		int number = input.charAt(input.length() - 2) - '0', counter = -1;
		
		for (int i = 0; i < input.length(); i++){
			if (input.charAt(i) == '(')
				counter++;
			if (counter == number && input.charAt(i) == ')'){
				output += input.charAt(i) + ") '("; i++;
			}
			else
				output += input.charAt(i);
		}
		System.out.println(output);
	}
}

