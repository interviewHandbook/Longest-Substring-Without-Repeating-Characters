package com.interviewprep.leetcode.medium.LongestSubWithoutRepChars;

import java.util.HashMap;
import java.util.Map;

public class FirstApproach {

	public static void main(String[] args) {

		// String s = "abcabcbb";
		//	 String s = "ckilbkd";
		//	String s = "dvdf";
		//	String s = "pwwkew";
		String s = "anviaj";

		FirstApproach fa = new FirstApproach();
		int len =  fa.lengthOfLongestSubstring(s);		 

		System.out.println(len);
	}
	
	
	public int lengthOfLongestSubstring(String input) {
		
		// if input is empty then return 0
		if(input.equals("")) {

			return 0;
		}
		
		int maxx = 1;
		
		// index from where we need to re-start the for loop
		int reStartIdx = 0;
		
		// this is where we'll store the sub-strings
		String curStr = "";
		
		int count = 1;
		
		// iterate till last input char
		for(int i=0; i<input.length(); i++) {
			
			// read the current char
			char nextChar = input.charAt(i);
			
			// if curStr doesn't contain this char
			if(curStr.indexOf(nextChar) == -1) { 
				
				// append to curStr
				curStr = curStr + input.charAt(i);
				
				// update count with sub-string length
				count = curStr.length();
				
				// compare with a max variable and update
				if(count > maxx) {
					
					// this ensures that maxx always contains our answer
					maxx = count;

				}
			}
			
			// if curStr contains this char
			else if (curStr.indexOf(nextChar) != -1) {
				
				// re-initialize the curStr to empty string
				curStr = "";
				
				// update the for loop index with new index and go back in the loop 
				i=reStartIdx;
				
				// update re-start index for next time
				reStartIdx++;

			}
		}

		return maxx;
	}

}
