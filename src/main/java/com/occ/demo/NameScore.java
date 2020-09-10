/**
 * Create a command line utility that will compute a score for a list of first names.
 */
package com.occ.demo;

import java.io.IOException;
import java.util.List;

/**
 * @author Chris H
 *
 */
public class NameScore {
    private FileLoad fileLoad;
    private ScoreValue scoreValue;

	public NameScore(FileLoad fileLoad, ScoreValue scoreValue) {
		this.fileLoad =  fileLoad;
		this.scoreValue = scoreValue;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: NameScore inputFileName");
			System.exit(0);
		}
		
		String inFileName = args[0];
		NameScore nameScore = new NameScore(new FileLoad(), new NameValue());
		
		System.out.println("Score = " + nameScore.getScore(inFileName));
	}
	/**
	 * Compute name list score
	 * Assume names are in upper case only A ~ Z, no special character
	 * Name is surrounded by ""
	 * 
	 * @param fileName - input file
	 * 
	 * @return score
	 */
	public int getScore(String fileName) {
		int score = 0;

		try {
			List<String> nameList = fileLoad.parseNameFile(fileName);
			score = scoreValue.computeScore(nameList);
		} catch (IOException e) {
			System.out.println("An error occurred while calculating the name score.");
		}
		
		return score;
	}
}
