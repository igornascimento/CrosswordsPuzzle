package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

	private ArrayList<String> words = new ArrayList<String>();
	
	public FileHandler(String source) throws IOException {
		
		FileReader file = new FileReader(source);
		BufferedReader buffer = new BufferedReader(file);
		String line = "";
		ArrayList<String> words = new ArrayList<String>();
		
		//reads the file until receives the null value (end of the file)
		while ((line = buffer.readLine()) != null) {
			this.words.add(line);
		}
	}
	
	public ArrayList<String> getWords(){
		return words;
	}
	
}
