package cs1;

public class RoundingTheBases {

	public static void main(String[] args) {
		for(int x=0; x<10; x++) {
			
		System.out.println("Input the number."); double num = Keyboard.readDouble();
		System.out.println("input the base. "); int base = Keyboard.readInt();
		System.out.println("input the place."); int place = Keyboard.readInt();
		num=round(num, base, place);
		//String answer = ""; answer=format(num, base, place);
		System.out.println(num);
	}
	}

	public static double round (double num, int base, int place)
	{
		String snum = ""+num;
		int dec = snum.indexOf(".");
		int look = dec+place+1;
		if (snum.charAt(look)/base>=0.5) {snum=snum.substring(0,look-1)+((snum.charAt(look-1) - '0')+1);}
		return Double.parseDouble(snum);
	}
	
	public static String format (double num, int base, int place)
	{ 
		
		
		
		String snum = "" + num;
		place += snum.indexOf(".");
		int max = base-1;
		if (Integer.parseInt((snum.substring(place)))>=max) {snum = snum.substring(0,place-1) + (snum.charAt(place-1)+1-'0') + "0";}
		return snum;
	}
}
	
	
	


