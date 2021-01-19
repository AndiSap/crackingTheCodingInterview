package chapter1.ArraysAndStrings;

public class OneAway {

    /**
     * Check if 2 given strings differ only in 1 character
     * time: O(n) of shorter string
     * space: O(1)
     */
    public boolean check(String word1, String word2) {
        // check length of words
        int minLength = word1.length();
        if(word1.length() > word2.length()) {
            minLength = word2.length();
        }

        if(Math.abs(word1.length() - word2.length()) > 1) // difference between both strings is greater than 1 char
            return false;

        int edits = 0, i = 0, j = 0;
        for(int idx = 0; idx < minLength; idx++) {
            // if chars are equal
            if(word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            } else {
                edits++;
                if(edits > 1)
                    return false;
                if(word1.length() < word2.length())
                    j++;
                else if(word1.length() > word2.length())
                    i++;
                else {
                    j++;
                    i++;
                }
            }
        }

        return true;
    }

    /**
     * Assumption: all lower case letters and only from 'a' - 'z'
     */
    public boolean checkWithHash(String word1, String word2) {
        int[] map = new int[26];

        for(int i = 0; i < word1.length(); i++)
            map[word1.charAt(i) - 'a']++;

        for(int i = 0; i < word2.length(); i++)
            map[word2.charAt(i) - 'a']--;

        int moreThanOne = 0;
        for(int element : map) {
            if (moreThanOne > 1 || moreThanOne < -1)
                return false;
            moreThanOne += element;
        }
        return true;
    }

    /**
     * ------------------------- modularized version ---------------------------------
     */
    public boolean oneEditAway(String first, String second) {
        if(first.length() == second.length())
            return oneEditReplace(first, second);
        else if(first.length() + 1 == second.length())
            return oneEditInsert(first, second);
        else if(first.length() - 1 == second.length())
            return oneEditInsert(second, first);
        else
            return false;
    }

    public boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(foundDifference)
                    return false;
            }

            foundDifference = true;
        }
        return true;
    }

    /* first string is always the longer string */
    public boolean oneEditInsert(String s1, String s2) {
        int idx1 = 0;
        int idx2 = 0;

        while(idx2 < s2.length() && idx1 < s1.length()) {
            if(s1.charAt(idx1) != s2.charAt(idx2)) {
                if(idx1 != idx2)
                    return false;

                idx2++;
            } else {
                idx1++;
                idx2++;
            }
        }
        return true;
    }

    /**
     * ---------------------- Compressed version of oneEditAway ---------------------------
     */
    public boolean oneEditAwayCompressed(String word1, String word2) {
        if(Math.abs(word1.length() - word2.length()) > 1)
            return false;

        String s1 = word1.length() < word2.length() ? word1 : word2; // save shorter string
        String s2 = word1.length() < word2.length() ? word2 : word1; // save longer string

        int idx1 = 0;
        int idx2 = 0;
        boolean foundDifference = false;

        while(idx2 < s2.length() && idx1 < s1.length()) {
            if(s1.charAt(idx1) != s2.charAt(idx2)) {
                if(foundDifference)
                    return false;

                foundDifference = true;
                if(s1.length() == s2.length())
                    idx1++; // increase index of shorter string
            }

            else {
                idx1++; // move index 1 if current character are the same
            }

            idx2++; // move index 2 every while iteration
        }

        return true;
    }
}
