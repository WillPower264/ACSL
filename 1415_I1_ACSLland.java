package ACSL;
import cs1.Keyboard;

public class ACSLland {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++){
			char start = getChar(),
				   end = getChar(),
				   car = getChar(), 
				  road = getChar();
			double gasPrice = Keyboard.readDouble();
				
			int miles = getMiles(start, end);
			int mpg = getMPG(car);
			int speed = getSpeed(road);
			double hours = (double) miles / (double)speed;
			String time = getTime(hours);
			double cost = getPrice(miles, mpg, gasPrice);
			
			System.out.println(miles + ", " +  time + ", " + "$" + cost);
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
			case 'C': case 'c': startMiles += 120;
			case 'D': case 'd': startMiles += 320;
			case 'E': case 'e': startMiles += 250;
			case 'F': case 'f': startMiles += 80;
			default: break;
		}
		switch (end){
			case 'A': case 'a': endMiles += 450;
			case 'B': case 'b': endMiles += 140;
			case 'C': case 'c': endMiles += 120;
			case 'D': case 'd': endMiles += 320;
			case 'E': case 'e': endMiles += 250;
			case 'F': case 'f': endMiles += 80;
			default: break;
		}
		return startMiles - endMiles;
	}
	
	public static int getMPG(char car){
		switch(car){
			case 'C': case 'c': return 28;
			case 'M': case 'm': return 25;
			case 'F': case 'f': return 22;
			case 'V': case 'v': return 20;
			default: return 0;
		}		
	}
	
	public static int getSpeed(char road){
		switch(road){
			case 'I': case 'i': return 65;
			case 'H': case 'h': return 60;
			case 'M': case 'm': return 55;
			case 'S': case 's': return 45;
			default: return 0;
		}		
	}

	public static String getTime(double hours){
		String time = "";
		int minutes = (int)((hours % 1) * 60 + 0.5);
		if (hours > 10)
			time = (int)hours + ":" + minutes;
		else
			time = "0" + (int)hours + ":" + minutes;
		return time;
	}

	public static double getPrice(int miles, int mpg, double price){
		double gallons = (double)miles/ (double)mpg;
		double totalPrice = gallons * price;
		int temp = (int) (totalPrice * 100.0 + 0.5);
		totalPrice = temp / 100.00;
		return totalPrice;
	}
}
