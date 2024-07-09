package com.interviewprep.leetcode.medium.LongestSubWithoutRepChars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThirdApproach {

	public static void main(String[] args) {

		String s = "abcabcbb";
		
		ThirdApproach ta = new ThirdApproach();
		int len = ta.lengthOfLongestSubstring(s);
		
		System.out.println(len);

	}
	
	public int lengthOfLongestSubstring(String input) {

		// if input is empty then return 0
		if(input.equals("")) {

			return 0;
		}
		
		// declare int array with length to store all ASCII chars
		int[] charIndex = new int[128];
		
		// initialize with -1
		Arrays.fill(charIndex, -1);

		int len = input.length();

		// right index 
		int right = 0;

		// left index
		int left = 0;

		// sub-string length
		int max = 0;

		// while right index is less that input length
		while (right < len ) {

			if (charIndex[input.charAt(right)] >= left) {

				 left = charIndex[input.charAt(right)] + 1;			

			} // end if

			charIndex[input.charAt(right)] = right;
            max = Math.max(max, right - left + 1);

			// increment right index
			right++;

		} // end while

		return max;
	}

}
