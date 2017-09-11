package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

	private ArrayList<String> lines = new ArrayList<String>();
	
	public FileHandler(String source) throws IOException {
		
		FileReader file = new FileReader(source);
		BufferedReader buffer = new BufferedReader(file);
		
		//reads the file until receives the null value (end of the file)
		String line = "";
		while ((line = buffer.readLine()) != null) {
			this.lines.add(line);
		}
	}
	
	public ArrayList<String> getLines(){
		return lines;
	}
	
}
