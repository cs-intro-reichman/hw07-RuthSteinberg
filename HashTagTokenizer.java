

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
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

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean answer=false;
		for(int i=0; i<3000; i++)
		{
			if(dictionary[i].equals(word))
			{
				answer=true;
			}
		}
		return answer;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
		hashtag=hashtag.toLowerCase();
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			String newStr=hashtag.substring(0, i);

		if((existInDictionary(newStr, dictionary))==true)
		{
			System.out.println(newStr);
			hashtag=hashtag.substring(i);
			breakHashTag(hashtag, dictionary);
			break;
		}
		}
    }
}


