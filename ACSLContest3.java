package ACSL;
import cs1.Keyboard;

public class ACSLContest3 {
	
	public static int[] BORDERNUMS;
	public static void main(String[] args) {
		for (int j = 0; j < 5; j++){
			System.out.println("Please enter locations separated only by a space (no commas): ");
			int[] holes = new int[8];
			int position = 0;
			for (int i = 0; i < 9; i++){
				int temp = Keyboard.readInt();
				if (i == 0)	holes[i] = temp;
				else if (i == 1) position = temp;
				else if (temp == 0) break;
				else holes[i-1] = temp; }
			fillBorder(position);
			int upLength = up(position, holes), downLength = down(position, holes), leftLength = left(position, holes), rightLength = right(position, holes);
			int upLeftLength = upLeft(position, holes), upRightLength = upRight(position, holes), downLeftLength = downLeft(position, holes), downRightLength = downRight(position, holes);
			longest(position, upLength, downLength, leftLength, rightLength, upLeftLength, upRightLength, downLeftLength, downRightLength);
		}
	}
	public static void fillBorder(int position){
		int up = position; while (up < 43) up += 7;
		int down = position; while (down > 7) down -= 7;
		int left = position; while (left % 7 != 1 ) left--;
		int right = position; while (right % 7 != 0) right++;
		int upLeft = position; while (upLeft < 43 && upLeft % 7 != 1) upLeft += 6;
		int upRight = position; while (upRight < 43 && upRight % 7 != 0) upRight += 8;
		int downLeft = position; while (downLeft > 7 && downLeft % 7 != 1) downLeft -= 8;
		int downRight = position; while (downRight > 7 && downRight % 7 != 0) downRight -= 6;
		BORDERNUMS = new int[] {up, down, left, right, upLeft, upRight, downLeft, downRight};
	}
	public static int up(int position, int[] holes){
		for (int i = position, counter = 0;; i += 7, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[0]) return counter;	}
	}
	public static int down(int position, int[] holes){
		for (int i = position, counter = 0;; i -= 7, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[1]) return counter;	}
	}
	public static int left(int position, int[] holes){
		for (int i = position, counter = 0;; i--, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[2]) return counter;	}
	}
	public static int right(int position, int[] holes){
		for (int i = position, counter = 0;; i++, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[3]) return counter;	}
	}
	public static int upLeft(int position, int[] holes){
		for (int i = position, counter = 0;; i += 6, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[4]) return counter;	}
	}
	public static int upRight(int position, int[] holes){
		for (int i = position, counter = 0;; i += 8, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[5]) return counter;	}
	}
	public static int downLeft(int position, int[] holes){
		for (int i = position, counter = 0;; i -= 8, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[6]) return counter;	}
	}
	public static int downRight(int position, int[] holes){
		for (int i = position, counter = 0;; i -= 6, counter++){
			for (int j = 0; j < 8; j++)
				if (i == holes[j]) return counter-1;
			if (i == BORDERNUMS[7]) return counter;	}
	}
	public static void longest(int position, int up, int down, int left, int right, int upLeft, int upRight, int downLeft, int downRight){
		int greatest = up, index = 0;
		if (down > greatest){ greatest = down; index = 1;}
		if (left > greatest){ greatest = left; index = 2;}
		if (right > greatest){ greatest = right; index = 3;}
		if (upLeft > greatest){ greatest = upLeft; index = 4;}
		if (upRight > greatest){ greatest = upRight; index = 5;}
		if (downLeft > greatest){ greatest = downLeft; index = 6;}
		if (downRight > greatest){ greatest = downRight; index = 7;}
		printList(position, greatest, index);
	}
	public static void printList(int position, int greatest, int index){
		if (greatest == 0){ System.out.println("NONE"); return; }
		for (int i = 0; i < greatest; i++){
			if (i != 0) System.out.print(", ");
			switch (index){
				case 0: System.out.print(position += 7); break;	//up
				case 1: System.out.print(position -= 7); break;	//down
				case 2: System.out.print(position -= 1); break;	//left
				case 3: System.out.print(position += 1); break;	//right
				case 4: System.out.print(position += 6); break;	//upLeft
				case 5: System.out.print(position += 8); break;	//upRight
				case 6: System.out.print(position -= 8); break;	//downLeft
				case 7: System.out.print(position -= 6); break;	//downRight
			}
		} System.out.println(); System.out.println();
	}
}