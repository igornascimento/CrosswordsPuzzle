import java.io.IOException;
import java.util.ArrayList;
import utils.FileHandler;

import models.Stage;

public class CrosswordsPuzzleApplication {

	private static Stage stage = new Stage();
	
	public static void main(String[] args) {
		
		try {
			stage.loadMatrix("src/files/words.txt");
			stage.printPuzzle();
			stage.debug();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
