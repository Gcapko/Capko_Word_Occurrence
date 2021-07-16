package Capko_Word_Occurrence_Pack;
/**
 * WordCounter Class
 * @author gcapk
 */
public class WordCounter {
	private int count;
	private String word;
	
	/**
	 * A WordCounter Object
	 * @param word - Word from file
	 * @param count - Frequency of Word
	 */
	public WordCounter(int count, String word) {
		super();
		this.count = count;
		this.word = word;
	}
	/**
	 * 
	 * @return words Frequency
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @return Word
	 */
	public String getWord() {
		return word;
	}
	/**
	 * Takes the frequency and adds one 
	 */
	public void incrementCount() {
		count += 1;
	}
	/**
	 * @param count sets the frequency of the word object
	 */
	public void setCount(int count) {
		
		this.count = count;
	}
	/**
	 * Prints count and word of WordCounter Object
	 */
	@Override
	public String toString() {
		return count + " " + word;
	}
}
