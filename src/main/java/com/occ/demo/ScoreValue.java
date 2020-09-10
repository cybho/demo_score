package com.occ.demo;

import java.util.List;

/**
 * @author Chris H
 *
 */
public interface ScoreValue {
	/**
	 * Compute score for a list of names.
	 *
	 * @param names - List of names
	 * 
	 * @return int - name score
	 */
	int computeScore(List<String> names);
}
