package com.interviewprep.leetcode.medium.LongestSubWithoutRepChars;

import java.util.HashMap;
import java.util.Map;

public class SecondApproach {

	public static void main(String[] args) {


		// String s = "abcabcbb";
		//	 String s = "ckilbkd";
		String s = "abba";
		//	String s = "dvdf";
		//	String s = "pwwkew";
		//	String s = "anviaj";
		SecondApproach sa = new SecondApproach();
		int len = sa.lengthOfLongestSubstring(s);

		System.out.println(len);
	}

	public int lengthOfLongestSubstring(String input) {

		// if input is empty then return 0
		if(input.equals("")) {

			return 0;
		}
		
		// Map that stores char and its latest occurrence
		Map<Character, Integer> charMap = new HashMap<>();
		int len = input.length();
		
		// right index 
		int right = 0;
		
		// left index
		int left = 0;
		
		// sub-string length
		int max = 0;
		
		// while right index is less that input length
		while (right < len ) {
			
			// if map contains current char
			if (charMap.containsKey(input.charAt(right)) ) {
				
				// then update left index
				if(charMap.get(input.charAt(right)) >= left) {
					
					left = charMap.get(input.charAt(right)) + 1;
				}
				
			} // end if
			
			// else if map doesn't contain current char
			charMap.put(input.charAt(right), right);
			
			// compare max with window length and update
			max = Math.max(max, right - left + 1);
			
			// increment right index
			right++;
			
		} // end while

		return max;
	}
	
}
