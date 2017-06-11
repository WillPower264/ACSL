package cs1;

public class MofNDetection {

	public static void main(String[] args) {
		for (int x = 0; x < 10; x++){
			System.out.println("Please input the mask: ");
			String mask = Keyboard.readString();
			System.out.println("Please input the number of 1's: ");
			int numOnes = Keyboard.readInt();
			System.out.println("Please input the target number: ");
			int target = Keyboard.readInt();
			int[] arrayMask = new int[mask.length()], output = new int[mask.length()];
			for (int i = 0; i < mask.length(); i++)
				arrayMask[i] = mask.charAt(i) - '0';
			String str  = " ";
			boolean none = true;
			for (int i = 0; i < Math.pow(2, mask.length()); i++){
				str = Integer.toBinaryString(i);
				for (int j = output.length - 1, k = str.length() - 1; j >= 0; j--, k--)
					if (k >= 0)
						output[j] = str.charAt(k) - '0';
					else
						output[j] = 0;
				if (none)
					none = checkOutput(arrayMask, output, numOnes, target);
				else
					checkOutput(arrayMask, output, numOnes, target);
			}
			if (none)
				System.out.println("NONE");
			System.out.println();
			}
		}
		
	public static boolean checkOutput(int[] mask, int[] output, int numOnes, int target){
		int count = 0;
		for (int i = 0; i < output.length; i++)
			if (output[i] == 1)
				count++;
		if (count != numOnes) return true;
		
		int sum = 0;
		for (int i = 0; i < mask.length; i++){
			sum += mask[i] * output[i];
		}
		if (sum != target) return true;
		
		for (int i : output)
			System.out.print(i);
		System.out.print(" ");
		return false;
	}

}
