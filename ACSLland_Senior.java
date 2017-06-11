package ACSL;
import cs1.Keyboard;

public class ACSLland_Senior {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++){
			char start = getChar(),
				   end = getChar();
			int start1 = Keyboard.readInt();
			char ampm1 = getChar(),
			  junkChar = getChar();
			int start2 = Keyboard.readInt();
			char ampm2 = getChar();
			  junkChar = getChar();
			int   mph1 = Keyboard.readInt(), 
				  mph2 = Keyboard.readInt();
			
			junkChar = ' ';
			
			if (start1 == 12) start1 = 0;
			if (start2 == 12) start2 = 0;
			
			int miles = getMiles(start, end);
			int soloHours = getTime(start1, ampm1, start2, ampm2);
			if (!reorderTime(start1, ampm1, start2, ampm2)){
				int temp1 = mph1; mph1 = mph2; mph2 = temp1;}
				
			double combinedHours = getHours(miles, soloHours, mph1, mph2);
			formatHours(combinedHours);
			System.out.println(junkChar);
		}
	}
	
	public static char getChar(){
		char ch = ' ';
		while (ch == ' ')
			ch = Keyboard.readChar();
		return ch;
	}
	
	public static int getMiles (char start, char end){
		int startMiles = 0, endMiles = 0;
		
		switch (start){
			case 'A': case 'a': startMiles += 450;
			case 'B': case 'b': startMiles += 140;
			case 'C': case 'c': startMiles += 125;
			case 'D': case 'd': startMiles += 365;
			case 'E': case 'e': startMiles += 250;
			case 'F': case 'f': startMiles += 160;
			case 'G': case 'g': startMiles += 380;
			case 'H': case 'h': startMiles += 235;
			case 'J': case 'j': startMiles += 320;
			default: break;
		}
		switch (end){
			case 'A': case 'a': endMiles += 450;
			case 'B': case 'b': endMiles += 140;
			case 'C': case 'c': endMiles += 125;
			case 'D': case 'd': endMiles += 365;
			case 'E': case 'e': endMiles += 250;
			case 'F': case 'f': endMiles += 160;
			case 'G': case 'g': endMiles += 380;
			case 'H': case 'h': endMiles += 235;
			case 'J': case 'j': endMiles += 320;
				default: break;
		}
		return startMiles - endMiles;
	}
	
	public static boolean reorderTime (int start1, char ampm1, int start2, char ampm2){
		if ((ampm1 == 'p' || ampm1 == 'P') && (ampm2 == 'a' || ampm2 == 'A') &&
			 start1 < start2)
			return false;
		else if ((ampm1 == 'p' || ampm1 == 'P') && (ampm2 == 'a' || ampm2 == 'A') &&
		 		  start1 > start2)
			return true;
		else if ((ampm1 == 'a' || ampm1 == 'A') && (ampm2 == 'p' || ampm2 == 'P') &&
				  start1 < start2)
			return false;
		else if ((ampm1 == 'a' || ampm1 == 'A') && (ampm2 == 'p' || ampm2 == 'P') &&
				  start1 > start2)
			return true;
		if (start1 < start2)
			return true;
		else
			return false;
	}
	
	public static int getTime(int start1, char ampm1, int start2, char ampm2){
		if (ampm1 == ampm2)
			return Math.abs(start1 - start2);
		else if ((ampm1 == 'p' || ampm1 == 'P') && (ampm2 == 'a' || ampm2 == 'A') &&
			 start1 < start2)
			start1 += 12;
		else if ((ampm1 == 'p' || ampm1 == 'P') && (ampm2 == 'a' || ampm2 == 'A') &&
				 start1 > start2)
			start1 -= 12;
		else if ((ampm1 == 'a' || ampm1 == 'A') && (ampm2 == 'p' || ampm2 == 'P') &&
				 start1 < start2)
			start2 -= 12;
		else if ((ampm1 == 'a' || ampm1 == 'A') && (ampm2 == 'p' || ampm2 == 'P') &&
				 start1 > start2)
			start2 += 12;
		int hours = Math.abs(start1 - start2);
		if (hours > 12)
			hours -= 12;
		System.out.println(hours);
		return hours;	
	}		

	public static double getHours(int miles, int soloHours, int mph1, int mph2){
		miles -= soloHours * mph1;
		double combinedHours = (double) miles / (double) (mph1 + mph2);
		return soloHours + combinedHours;
	}

	public static void formatHours(double combinedHours){
		String hours = "";
		hours += (int)combinedHours;
		hours += ":";
		int minutes = (int)(combinedHours % 1 * 60 + 0.5);
		if (minutes < 10)
			hours += "0";
		hours += minutes; 
		System.out.println(hours);
	}
}