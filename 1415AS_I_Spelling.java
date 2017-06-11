package cs1;

public class Spelling {

	public static void main(String[] args) {
		for (int x= 0; x<5; x++)
		{
		System.out.println("Input a noun.");
		String noun = Keyboard.readString();
		if (noun.substring(noun.length()-1).equals("x")||
			noun.substring(noun.length()-1).equals("z") ||
			noun.substring(noun.length()-1).equals("s") ||
			noun.substring(noun.length()-2).equals("ch")||
			noun.substring(noun.length()-2).equals("sh")) {noun+="es";}
		else 
		{
			if ((noun.substring(noun.length()-1).equals("y"))) 
				{
					if (noun.substring(noun.length()-2).equals("ay") || 
							noun.substring(noun.length()-2).equals("ey") || 
							noun.substring(noun.length()-2).equals("iy") ||
							noun.substring(noun.length()-2).equals("oy") ||
							noun.substring(noun.length()-2).equals("uy")) noun+="s";
					else noun=noun.substring(0,noun.length()-1)+"ies";
				}
			else 
			{
				if (noun.substring(noun.length()-1).equals("f") ||noun.substring(noun.length()-2).equals("fe")) 
					{noun=noun.substring(0,noun.length()-2)+"ves";}
				else 
				{
					if ((noun.substring(noun.length()-1).equals("o"))) 
					{
						if (noun.substring(noun.length()-2).equals("ao") || 
								noun.substring(noun.length()-2).equals("eo") || 
								noun.substring(noun.length()-2).equals("io") ||
								noun.substring(noun.length()-2).equals("oo") ||
								noun.substring(noun.length()-2).equals("uo")) noun+="s";
						else noun=noun.substring(0,noun.length())+"es";
					}
					else 
					{
						noun+="s";
					}
				}
			}
		}
		System.out.println(noun);
	}
		
		
		for (int x = 0; x<5; x++)
		{
		System.out.println("Input root."); String root = Keyboard.readString();
		System.out.println("Input suffix."); String suffix = Keyboard.readString();
		String word = "";
		if ((root.substring(root.length()-1).equals("a") ||
			root.substring(root.length()-1).equals("e") ||
			root.substring(root.length()-1).equals("i") ||
			root.substring(root.length()-1).equals("o") ||
			root.substring(root.length()-1).equals("u"))) 
		{
			if (suffix.substring(0,1).equals("a") ||
					suffix.substring(0,1).equals("e") ||
					suffix.substring(0,1).equals("i") ||
					suffix.substring(0,1).equals("o") ||
					suffix.substring(0,1).equals("u")) word = root.substring(0,root.length()-1)+suffix;
			else word=root+suffix; 
		
		}
		else
		{
			if (root.substring(root.length()-1).equals("y")) 
			{
				if (suffix.substring(0,1).equals("i")) {word=root+suffix;}
				else word=root.substring(0,root.length()-1)+"i"+suffix;
			}
			else
			{
				if ((suffix.substring(0,1).equals("a") || 
					suffix.substring(0,1).equals("e")|| 
					suffix.substring(0,1).equals("i")|| 
					suffix.substring(0,1).equals("o")|| 
					suffix.substring(0,1).equals("u"))
					&&
					!(root.substring(root.length()-1).equals("a")||
					root.substring(root.length()-1).equals("e")||
					root.substring(root.length()-1).equals("i")||
					root.substring(root.length()-1).equals("o")||
					root.substring(root.length()-1).equals("u"))
					&&
					(root.substring(root.length()-2,root.length()-1).equals("a")||
					root.substring(root.length()-2,root.length()-1).equals("e")||
					root.substring(root.length()-2,root.length()-1).equals("i")||
					root.substring(root.length()-2,root.length()-1).equals("o")||
					root.substring(root.length()-2,root.length()-1).equals("u"))
					&&
					!(root.substring(root.length()-3,root.length()-2).equals("a")||
					root.substring(root.length()-3,root.length()-2).equals("e")||
					root.substring(root.length()-3,root.length()-2).equals("i")||
					root.substring(root.length()-3,root.length()-2).equals("o")||
					root.substring(root.length()-3,root.length()-2).equals("u"))
					) {word=root+root.substring(root.length()-1)+suffix;}
				else 
				{
				 word=root+suffix;
				}
				
			}
		}
		

			
		System.out.println(word);
	}
		
	}

}
