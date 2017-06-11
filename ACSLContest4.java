package ACSL;
import cs1.Keyboard;
@SuppressWarnings("unused")
public class ACSLContest4 {
	
	public static void main (String[] args){
		String[] binary = new String[16];
		for (int i = 0; i < binary.length; i++){
			binary[i] = Integer.toBinaryString(i);
			while (binary[i].length() < 4)
				binary[i] = "0" + binary[i];
		}
		System.out.println("Please enter the first input (no inputs should have commas): ");
		String mysteriousFirstLine = Keyboard.readString();
		
		String output = "";
		int num1, num2, num3, num4;
		String[] order = {"second", "third", "fourth", "fifth", "sixth"};
		
		for (int i = 0; i < 5; i++){
			System.out.println("Please enter the " + order[i] + " input:");
			if (i < 2){
				num1 = Keyboard.readInt(); num2 = Keyboard.readInt();
				output = Compare(binary[num1], binary[num2]);
				translateBool(output);
			}
			else{
				num1 = Keyboard.readInt(); num2 = Keyboard.readInt();
				num3 = Keyboard.readInt(); num4 = Keyboard.readInt();
				output = Compare(binary[num1], binary[num2], binary[num3], binary[num4]);
				translateBool(output);
			}
		}
	}
	
	public static String Compare(String num1, String num2, String num3, String num4) {
		return Compare(Compare(num1, num2), Compare(num3, num4));
	}

	public static String Compare(String num1, String num2){
		String result = ""; int differences = 0;
		for (int i = 0; i < 4; i++)
			if (num1.charAt(i) == num2.charAt(i))
				result += num1.charAt(i);
			else{
				result += "x"; differences++; }
		if (differences <= 1)	
			return result;
		return "NONE";
	}
	
	public static void translateBool(String result){
		if (result.equalsIgnoreCase("NONE")) {
			System.out.println("NONE"); return; }
		String output = "";
		String[][] letters = {{"A", "B", "C", "D"}, 
							  {"a", "b", "c", "d"}};
		for (int i = 0; i < 4; i++)
			if (result.charAt(i) == 'x'); //don't add anything
			else if (result.charAt(i) == '1')
				output += letters[0][i];
			else if (result.charAt(i) == '0')
				output += letters[1][i];
		
		System.out.println(result + ", " + output);
 	}
}
