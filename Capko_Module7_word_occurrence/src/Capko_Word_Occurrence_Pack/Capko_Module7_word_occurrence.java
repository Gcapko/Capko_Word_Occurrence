package Capko_Word_Occurrence_Pack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
/**
 *Capko_Module7_word_occurrence
 *author Grayson Capko
* Date: 7/3/2021
* Program Name: Capko_Module7_word_occurrence
* Purpose: Take a file and sort the text by frequency. 
* @author Grayson Capko
*/


public class Capko_Module7_word_occurrence extends Application{
	  /*
	 * Write a text analyzer that reads a file and outputs statistics about that file. 
	 * It should output the word frequencies of all words in the file, sorted by the most
	 * frequently used word. The output should be a set of pairs, each pair containing
	 * a word and how many times it occurred in the file.
		Put a GUI on top of the word occurrences class. Try to follow the GUI guidelines 
		and practices that you learned about, so that the GUI is clean and usable.
	 */
		
		
		private GridPane grid = new GridPane();
		TableView<WordObject> table = new TableView<WordObject>();
		private static Map<String, WordCounter> map = new HashMap<String, WordCounter>();
	
	public static void main(String[] args) throws IOException {
		
		
		launch(args);
		
	}
	/**
	 * This calls the GUI. It has two buttons, Check calls the ReadFile method and Exit closes the 
	 * application. 
	 */
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		
		primaryStage.setTitle("Word Occurrence Application");
		
		
		Button check = new Button("Top 20 Words of McBeth");
		Button exit = new Button("Exit");
		
		grid.setPadding(new Insets(10, 10, 10, 10)); 
		grid.setHgap(5);
		grid.setVgap(5);
		grid.add(check, 0, 0);
		grid.add(exit, 0, 0);
		 GridPane.setHalignment(exit, HPos.RIGHT);
		 
		TableColumn<WordObject, String> wordCol = new TableColumn<>("Word");
		wordCol.setCellValueFactory(new PropertyValueFactory<>("word"));
		TableColumn<WordObject, Integer> countCol = new TableColumn<>("Count");
		countCol.setCellValueFactory(new PropertyValueFactory<>("count"));
		
		    
		
		check.setOnAction(e -> ReadFile());
		exit.setOnAction(e -> exitApp());
		

	   table.getColumns().add(wordCol);
	   table.getColumns().add(countCol);

	
		
	   grid.add(table,0,1);
		
	   Scene scene = new Scene(grid, 500, 600);
	   table.prefHeightProperty().bind(primaryStage.heightProperty());
       table.prefWidthProperty().bind(primaryStage.widthProperty());
       primaryStage.setScene(scene);
       primaryStage.show();
		
	}
	/**
	
 	Closes the Application

	 */
		public void exitApp() 
		{
			Platform.exit();
		}
		/**
		 * This reads the file and passes the text file to the countWordOccrrences method
		 * when it receives the list back it sorts the list using the highest wordCount first. 
		 * Its then returns the top 20 most frequently used words. 
		 */
		public void ReadFile() 
		
		{
			try
			{
				Capko_Module7_word_occurrence counter = new Capko_Module7_word_occurrence();
				//BufferedReader reader = new BufferedReader(new FileReader("WordOccurenceTestFile.txt"));
				BufferedReader reader = new BufferedReader(new FileReader("WordOccurenceTestFile.txt"));
				List<WordCounter> list = counter.countWordOccurrences(reader);
				
				Map<String, Integer> tree = new TreeMap<String, Integer>(Collections.reverseOrder());
				
				ArrayList<Integer> wordCount = new ArrayList<Integer>();
				
				for(WordCounter result : list)
				{
					tree.put(result.getWord(), result.getCount());
					wordCount.add(result.getCount());
				}
				
				Collections.sort(wordCount, Collections.reverseOrder());
				
				for(int j = 0; j < 20; j++) 
				{
					Set<Entry<String, Integer>> set = tree.entrySet();
					Iterator<Entry<String, Integer>> i = set.iterator();
					
					while(i.hasNext()) 
					{
						Entry<String, Integer> next = i.next();
						if(next.getValue().equals(wordCount.get(j)))
						{
							WordObject myObject = new WordObject (next.getKey(), next.getValue());
							
							table.getItems().add(myObject);
							
							i.remove();
						}
					}
				}
			}
			catch(Exception e)
			{
				System.err.format("Execption occured trying to read");
				e.printStackTrace();
			}
		}
	
		/** This method Receives a file and reads each line. Each line is then passed to the @evaluateLine method to be check. 
		 * 	After each word has been evaluated and counted, the word and count are added to an ArrayList. 
		 * @param reader
		 * @return list - This returns an array list that has the word and occurrence listed. 
		 * @exception Throws if fails. Print Stack.
		 */
		public List<WordCounter> countWordOccurrences(BufferedReader reader) throws Exception{
			
		
			String line;
			while ((line = reader.readLine())!= null)
					{
				evaluateLine(line, map);
					}
			List<WordCounter> list = new ArrayList<WordCounter>(map.values());
					return list;
		}
		/**
		 * This method reviews the line and and splits it into words and sets every word to lower case.
		 * This call increment count for the associated word object.
		 * @param line
		 * @param occurrences
		 */
		private void evaluateLine(String line, Map<String, WordCounter> occurrences) {
			
			String[] words = line.toLowerCase().split("\\s+");
			for(int i = 0; i< words.length; i++)
			{
				if(occurrences.containsKey(words[i])) 
				{
					occurrences.get(words[i]).incrementCount();
				}
				else 
				{
					WordCounter wordObject = new WordCounter(1, words[i]);
					occurrences.put(words[i], wordObject);
				}
			}
		}
}