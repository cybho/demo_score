/**
 * FileLoad to load list of names
 */
package com.occ.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Chris H
 *
 */
public class FileLoad {
	final private String COMMA_SEPARATOR = ",";
	
	/**
	 * Parses the file contents into a List of names.
	 * Names are separated by comma
	 *
	 * @param fileName - input URI
	 * 
	 * @return nameList - List of names
	 * 
	 * @throws IOException
	 */
	public List<String> parseNameFile(String fileName) throws IOException {
		List<String> nameList = new ArrayList<>();
		
		try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
			for (String line : (Iterable<String>) lines::iterator ) {
				// The names file will contain a single line of quoted, comma-separated names
				nameList.addAll(Arrays.asList(line.split(COMMA_SEPARATOR)));
			}
		} catch (IOException ioe) {
			// Exception
			ioe.printStackTrace();
			throw ioe;
		} 
		
		return nameList;
	}
}
