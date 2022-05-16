package net.unknownuser.boxes;

import java.util.List;

/**
 * A helper class designed for printing various box designs
 */
public abstract class Boxes {
	
	/**
	 * Puts the given strings in a single box.
	 * 
	 * @param strings The strings inside of the box.
	 * @return The box with the strings in it.
	 */
	public static String createBox(String... strings) {
		StringBuilder sb = new StringBuilder();
		int maxLength = getMaxStringLength(strings);
		
		sb.append("┌" + "─".repeat(maxLength + 2) + "┐\n");
		for(String str : strings) {
			sb.append("│ " + str + " ".repeat(maxLength - str.length()) + " │\n");
		}
		sb.append("└" + "─".repeat(maxLength + 2) + "┘");
		
		return sb.toString();
		
	}
	
	/**
	 * Puts the given strings in a single box.
	 * 
	 * @param strings The strings inside of the box.
	 * @return The box with the strings in it.
	 */
	public static String createBox(List<String> list) {
		return createBox(list.toArray(new String[list.size()]));
	}
	
	/**
	 * Creates multiple boxes horizontally connected next to each other
	 * 
	 * @param list The strings to be put in the boxes.
	 * @return The box of strings.
	 */
	public static String createHorizontalMultiBox(String... list) {
		StringBuilder sb = new StringBuilder();
		
		sb.append("┌" + "─".repeat(list[0].length() + 2));
		for(int i = 1; i < list.length; i++) {
			sb.append("┬" + "─".repeat(list[i].length() + 2));
		}
		sb.append("┐\n│ ");
		for(String str : list) {
			sb.append(str + " │ ");
		}
		sb.append("\n└" + "─".repeat(list[0].length() + 2));
		for(int i = 1; i < list.length; i++) {
			sb.append("┴" + "─".repeat(list[i].length() + 2));
		}
		sb.append("┘");
		
		return sb.toString();
	}
	
	/**
	 * Creates multiple boxes horizontally connected next to each other
	 * 
	 * @param list The string array containing the strings to be put in the boxes.
	 * @return The box of strings.
	 */
	public static String createHorizontalMultiBox(List<String> list) {
		return createHorizontalMultiBox(list.toArray(new String[list.size()]));
	}
	
	/**
	 * Creates multiple boxes vertically connected next to each other
	 * 
	 * @param list The string array containing the strings to be put in the boxes.
	 * @return The box of strings.
	 */
	public static String createVerticalMultiBox(String... list) {
		StringBuilder sb = new StringBuilder();
		
		int maxLength = getMaxStringLength(list) + 2;
		
		sb.append("┌" + "─".repeat(maxLength) + "┐\n");
		
		boolean firstRun = true;
		for(String str : list) {
			if(!firstRun)
				sb.append("\n");
			sb.append("│ " + str + " ".repeat(maxLength - str.length() - 2) + " │\n");
			sb.append("├" + "─".repeat(maxLength) + "┤");
			firstRun = false;
		}
		sb.append("\r└" + "─".repeat(maxLength) + "┘");
		
		return sb.toString();
	}
	
	/**
	 * Creates multiple boxes vertically connected next to each other
	 * 
	 * @param list The string array containing the strings to be put in the boxes.
	 * @return The box of strings.
	 */
	public static String createVerticalMultiBox(List<String> list) {
		return createVerticalMultiBox(list.toArray(new String[list.size()]));
	}
	
	/**
	 * Calculate the longest string in the array.
	 * 
	 * @param strings The strings of which the longest should be found.
	 * @return The length of the longest string.
	 */
	private static int getMaxStringLength(String... strings) {
		int maxLength = 0;
		for(String str : strings) {
			if(maxLength < str.length()) {
				maxLength = str.length();
			}
		}
		return maxLength;
	}
}