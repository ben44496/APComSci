













public class StringWithCount implements Comparable<StringWithCount> {

	private String word;// the String that I am keeping track of
	private int count;// the number of times that the String has occurred
	private static int compareType = 0;// 0 if alpha, 1 = count, 2 for length

	@Override
	public boolean equals(Object other) {
		
		try {
			return this.word.equals(((StringWithCount)other).word);
		}
		catch(Exception e) {
			return false;
		}

		//return false;
	}
	
	
	public StringWithCount(String string) {
		this(string, 1);
	}

	
	

	public StringWithCount(String string, int i) {
		this.word=string;
		count = i;
	}


	/**
	 * The compareTo method will be a little more complex than the other
	 * compareTo methods that we wrote.  Sometimes we want to compare 
	 * these alphabetically, like when we are processing a source of text,
	 * sometimes we want to compare by frequency, which Strings were most
	 * or least common, sometimes we want to compare by length.  How can
	 * we build in such a mechanism?
	 */
	@Override
	public int compareTo(StringWithCount other) {
		if(compareType == 1)
			return this.count - other.count;
		if(compareType == 2)
			return this.word.length() - other.word.length();

		return this.word.compareTo(other.word);
	}


	@Override
	public String toString() {
		return word +" : "+count;
	}
	public static void compareByLength() {
		compareType = 2;
	}
	public static void compareByAlpha() {
		compareType = 0;
	}
	public static void compareByFrequency() {
		compareType = 1;
	}

	public int getCount(){
		return count;
	}
	public String getWord(){
		return word;
	}
	public void increment(){
		this.count++;
	}
}
