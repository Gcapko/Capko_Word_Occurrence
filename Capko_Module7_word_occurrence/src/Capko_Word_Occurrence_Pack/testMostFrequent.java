package Capko_Word_Occurrence_Pack;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class testMostFrequent {

	@Test
	void test() throws Exception {
		Capko_Module7_word_occurrence test = new Capko_Module7_word_occurrence();
		
		List<WordObject> answer = new ArrayList<WordObject>();
		
		WordObject a = new WordObject("the", 731);
		answer.add(a);
		WordObject b = new WordObject("to", 377);
		answer.add(b);
		WordObject c = new WordObject("of", 341);
		answer.add(c);
		WordObject d = new WordObject("i", 303);
		answer.add(d);
		WordObject e = new WordObject("a", 248);
		answer.add(e);
		WordObject f = new WordObject("macbeth", 241);
		answer.add(f);
		WordObject g = new WordObject("that", 212);
		answer.add(g);
		WordObject h = new WordObject("in", 201);
		answer.add(h);
		WordObject i = new WordObject("my", 192);
		answer.add(i);
		WordObject j = new WordObject("is", 180);
		answer.add(j);
		WordObject k = new WordObject("you", 153);
		answer.add(k);
		WordObject l = new WordObject("with", 152);
		answer.add(l);
		WordObject m = new WordObject("his", 143);
		answer.add(m);
		WordObject n = new WordObject(" ", 140);
		answer.add(n);
		WordObject o = new WordObject("not", 139);
		answer.add(o);
		WordObject p = new WordObject("be", 131);
		answer.add(p);
		WordObject q = new WordObject("have", 122);
		answer.add(q);
		WordObject r = new WordObject("your", 121);
		answer.add(r);
		WordObject s = new WordObject("it", 120);
		answer.add(s);
		
		
		BufferedReader reader = new BufferedReader(new FileReader("WordOccurenceTestFile.txt"));
		List<WordCounter> list = test.countWordOccurrences(reader);
			
		assertEquals( answer , list);
		
		
		
		
	}

}
