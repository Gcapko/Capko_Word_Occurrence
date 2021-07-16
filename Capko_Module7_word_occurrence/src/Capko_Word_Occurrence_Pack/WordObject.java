package Capko_Word_Occurrence_Pack;
/**
 * Creates a word object that uses a String Word and contains
 * its frequency in the integer count. 
 * @author gcapk
 *
 */
public class WordObject {
	
	private String word;
	private Integer count;
	
	public WordObject (String s, Integer i) {
		
		setCount(i);
		setWord(s);
	}
	/**
	 * Sets the count to the integer passed to it. 
	 * @param i
	 */
	public void setCount(Integer i) {
		count = i;
	}
	/**
	 * sets word parameter to String passed to it. 
	 * @param s
	 */
	public void setWord(String s) {
		word = s;
	}
	/**
	 * @return word Frequency
	 */
	public Integer getCount() {
		return count;
	}
	/**
	 * @return word
	 */
	public String getWord() {
		return word;
	}
}
