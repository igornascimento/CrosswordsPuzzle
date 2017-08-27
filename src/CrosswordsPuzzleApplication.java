import java.io.IOException;
import java.util.ArrayList;

import utils.FileHandler;

public class CrosswordsPuzzleApplication {

	public static void main(String[] args) {
		
		try {
			
			ArrayList<String> words = new FileHandler("src/files/words.txt").getWords();
			
			for (String word : words) {
				System.out.println(word);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
