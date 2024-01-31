
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		String newstr=str.substring(1);
		return newstr;
	}

	public static int levenshtein(String word1, String word2) {
		word1=word1.toLowerCase();
		word2=word2.toLowerCase();
		//iint counter=0;
		int a=word1.length();
		int b=word2.length();
		if(a==0) return b;
		if(b==0) return a;
		char heada = word1.charAt(0);
		char headb = word2.charAt(0);
		
		if(heada==headb)
		{
			String newword1 = tail(word1);
			String newword2 = tail(word2);
			return levenshtein(newword1, newword2);
		}
		else{
			int min=Math.min(levenshtein(tail(word1), word2), Math.min(levenshtein(word1, tail(word2)), levenshtein(tail(word1), tail(word2))));
			 return 1 + min;
		}
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for(int i=0; i<3000; i++)
		{
			String word = (String)in.readLine();
			dictionary[i]=word;
		}
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		for(int i=0; i<3000; i++)
		{
			if(levenshtein(word, dictionary[i])<=threshold)
			{
				return dictionary[i];
			}
		}
		return word;
	}

}
