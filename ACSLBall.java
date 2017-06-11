package cs1;

public class ACSLBall {

	public static void main(String[] args) {
		String[] names = new String[10];
		int[][] data = new int[10][5];
		int[] scores = new int[10];
		for (int i = 0; i < 10; i++){
			System.out.println("Please enter a line of data: ");
			String str = Keyboard.readString();
			names[i] = str.substring(0, str.indexOf(" "));
			str = str.substring(str.indexOf(" ") + 1);
			for (int j = 0; j < str.length() - 2; j++)
				data[i][j] = str.charAt(i) - '0';
			if (str.charAt(4) > 60)
				data[i][4] = str.charAt(4) - 'A' + 10;
			int sum = 0;
			sum += data[i][0] * 1;
			sum += data[i][1] * 2;
			sum += data[i][2] * 3;
			sum += data[i][3] * 4;
			scores[i] = sum;
		}
		outputMean(scores);
		outputMedian(scores);
		outputHighest(scores, 0, names);
		outputHighest(scores, 5, names);
		outputWinner(scores);
		outputHighPercent(data, names);
		outputLowPercent(data, names);
		outputMostZone(2, data, names);
		outputMostZone(1, data, names);
		
		
	}
	
	public static void outputMean (int[] scores){
		int tot = 0;
		for (int i : scores)
			tot += i;
		System.out.println("The mean of all player points scored is " + tot);
	}
	
	public static void outputMedian (int[] temp){
		int [] scores = new int[temp.length];
		for (int i = 0; i < temp.length; i++)
			scores[i] = temp[i];
		for (int i = 0; i < 4; i++){
			deleteSmallest(scores);
			deleteLargest(scores);
		}
		int tot = 0;
		for (int i = 0; i < scores.length; i++)
			if (scores[i] != 9999) tot += scores[i];
		System.out.println("The median of all player points scored is " + (0.5 * tot));
	}
	public static void deleteSmallest (int[] scores){
		int sVal = scores[0], sInd = 0;
		for (int i = 1; i < scores.length; i++)
			if (scores[sInd] > scores[i]){
				sVal = scores[i];
				sInd = i;
			}
		scores[sInd] = 9999;
	}
	public static void deleteLargest (int[] scores){
		int lVal = scores[0], lInd = 0;
		for (int i = 1; i < scores.length; i++)
			if (scores[i] == 9999);
			else if (scores[lInd] < scores[i]){
				lVal = scores[i];
				lInd = i;
			}
		scores[lInd] = 9999;
	}
	
	public static void outputHighest(int[] scores, int team, String[] names){
		int highScore = 0, highIndex = team;
		for (int i = team + 1; i < team + 4; i++){
			if (scores[highIndex] < scores[i])
				highScore = scores[i];
		}
		System.out.println("The highest scorer on Team X is " + names[highIndex]);
	}
	public static void outputWinner (int[] scores){
		int team1 = 0, team2 = 0;
		for (int i = 0; i < 5; i++)
			team1 += scores[i];
		for (int i = 5; i < 10; i++)
			team2 += scores[i];
		if (team1 > team2)
			System.out.println(team1 + ", " + team2);
		else
			System.out.println(team2 + ", " + team1);
	}
	public static void outputHighPercent (int[][] data, String[] names){
		double[] percents = new double[5];
		int highIndex = 0;
		double percent, highPercent = 0;
		for (int i = 0; i < 5; i++){
			int total = 0;
			for (int j = 0; j < 4; j++)
				total += data[i][j];
			percents[i] = (double)(total) / data[i][5];
		}
		double highest = percents[0];
		for (int i = 1; i < 5; i++)
			if (percents[highIndex] < percents[i]){
				highIndex = i;
				highest = percents[i];
			}
		System.out.println(names[highIndex]);
	}
	public static void outputLowPercent (int[][] data, String[] names){
		double[] percents = new double[5];
		int lowIndex = 0;
		double percent, highPercent = 0;
		for (int i = 5; i < 10; i++){
			int total = 0;
			for (int j = 0; j < 4; j++)
				total += data[i][j];
			percents[i] = (double)(total) / data[i][5];
		}
		double lowest = percents[0];
		for (int i = 1; i < 5; i++)
			if (percents[lowIndex] > percents[i]){
				lowIndex = i;
				lowest = percents[i];
			}
		System.out.println(names[lowIndex]);
	}
	public static void outputMostZone(int zone, int[][] data, String[] names){
		int most = data[0][zone - 1], highIndex = 0;
		for (int i = 1; i < 10; i++){
			if (data[highIndex][zone-1] < data[i][zone -1]){
				most = data[i][zone -1];
				highIndex = i;
			}
		}
		System.out.println(names[highIndex]);
	}
}
