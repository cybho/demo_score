/**
 * NameValue to calculate name value 
 */
package com.occ.demo;

import java.util.Comparator;
import java.util.List;

/**
 * @author Chris H
 *
 */
public class NameValue implements ScoreValue {
	final private char CHAR_A = 'A';
	final private char CHAR_Z = 'Z';

	/**
	 * Compute name list score
	 * Assume names are in alphabetically only A ~ Z
	 * lower case a ~ z will be converted to upper case
	 * Ignore other characters
	 *
	 * @param names - List of names
	 * 
	 * @return int - name score
	 */
	@Override
	public int computeScore(List<String> names) {
		int score = 0;

		names.sort(new SortbyName());

		int i = 1;
		for (String name : names) {
			int value = name.toUpperCase()
					.chars()
					.map(chr -> chr >= CHAR_A && chr <= CHAR_Z ? chr - CHAR_A + 1 : 0)
					.sum();
			score += value * i++;
		}

		return score;
	}

	/**
	 * Comparator for sorting by ignore cases
	 */
	class SortbyName implements Comparator<String> {
		// Used for sorting in ascending order of
		public int compare(String a, String b) {
			return a.compareToIgnoreCase(b);
		}
	}
}
