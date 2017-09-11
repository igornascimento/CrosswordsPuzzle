package models;

public class Word {

	private String word;
	private int[] stagePosition = {0, 0};
	private String[] orientation = {null, null};
	private int crossPosition = 0;
	
	public Word(String string, int[] stagePosition, int crossPosition, String[] orientation) {
		this.word = string;
		this.stagePosition = stagePosition;
		this.crossPosition = crossPosition;
		this.orientation = orientation;
	}

	public int[] getStagePosition() {
		return stagePosition;
	}

	public String[] getOrientation() {
		return orientation;
	}

	public int getCrossPosition() {
		return crossPosition;
	}

	public String getWord() {
		return this.word;
	}

	public int length() {
		return this.word.length();
	}
	
}
