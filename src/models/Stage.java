package models;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

import utils.FileHandler;

public class Stage {

	private int width;
	private int height;
	private ArrayList<Word> crossWord = new ArrayList<>();
	private ListIterator<Word> itr = crossWord.listIterator();
	private ArrayList<String> rawWords = new ArrayList<>();
	private int biggestCrossPosition = 0;
	
	/**
	 * Translates the words file into coordinates object to mount the puzzle
	 * @param file
	 * @throws Exception
	 */
	public void loadMatrix(String file) throws Exception {
		
		// local list to get the file words
		try {
			rawWords = new FileHandler(file).getLines();
		} catch (IOException e) {
			throw new Exception("Cannot read the file.");
		}
		
		String biggest = this.getBigest();
		if (biggest != null) {
			// System.out.println(bigest);
			// once found the bigest, lets place it horizontally
			int[] coordPosition = new int[]{0, 0};
			int coordCrossPosition = 0;
			String[] coordOrientation = new String[]{"L", "R"};
			Word main = new Word(biggest, coordPosition, coordCrossPosition, coordOrientation);
			this.crossWord.add(main);
			
			// find the cross position and other details for each lasting words, 
			// until we have letters available in the horizontal word
			int letterCount = 0;
			for (String letter : main.getWord().split("")) {
				// System.out.println("first:"+letter);
				for (String word : rawWords) {
					// System.out.println("second:"+word);
					int subletterCount = 0;
					for (String subletter : word.split("")) {
						// System.out.println("third:"+subletter);
						if (letter.equals(subletter)) {
							// System.out.println(letter +":"+ subletter);
							coordPosition = new int[]{letterCount, subletterCount};
							coordCrossPosition = subletterCount;
							coordOrientation = new String[]{"T", "B"};
							this.crossWord.add( new Word(word, coordPosition, coordCrossPosition, coordOrientation) );
							
							// additionally, keeps the greater Y value
							// (real height of main word)
							if (subletterCount > this.biggestCrossPosition) {
								this.biggestCrossPosition = subletterCount;
							}
							
							break;
						}
						subletterCount++;
					}
				}
				letterCount++;
			}
			
			
			
		} else {
			throw new Exception("Cannot build the stage.");
		}
		
		
	}
	/**
	 * Gets the biggest word and remove it from the array
	 * @return String biggest
	 */
	private String getBigest() {
		int size = 0;
		String biggest = null;
		for (String wrd : rawWords) {
			if(wrd.length() > size) {
				biggest = wrd;
				size = wrd.length();
			}
		}
		rawWords.remove(biggest);
		this.width = size;
		return biggest;
		
	}
	
	/**
	 * Debug
	 */
	public void debug() {
		System.out.println();
		for (Word w : this.crossWord) {
			System.out.println( w.getWord()
								+ ": " + Arrays.toString(w.getOrientation()) 
								+ ", " + Arrays.toString(w.getStagePosition()) );
		}
	}
	
	/**
	 * Prints the puzzle
	 */
	public void printPuzzle() {
		// getting the first (main word)
		Word main = null;
		for (Word w : this.crossWord) {
			// just to ensure this is the main word
			if (w.getOrientation()[0].equals("L") && w.getOrientation()[1].equals("R")) {
				// getting the main word
				main = w;
				this.crossWord.remove(w);
				break;
			}
		}
		
		// iterating over each main letter
		int countMainLetter = 0;
		for (String letter : main.getWord().split("")) {
			// iterating over all the rest words
			for (Word w : this.crossWord) {
				// ensuring this is the transversal word
				if (w.getOrientation()[0].equals("T") && w.getOrientation()[0].equals("B")) {
					if (w.getStagePosition()[0] == countMainLetter) {
						int emptyBlocks = this.biggestCrossPosition - w.getStagePosition()[1];
						
						// prints the puzzle
						for (int i = this.biggestCrossPosition; i > (emptyBlocks + w.getStagePosition()[1]); i--) {
							while ()
						}
						
					} else {
						continue;
					}
				}
			}
			countMainLetter++;
		}
		
		System.out.println();
	}
	
	
}
