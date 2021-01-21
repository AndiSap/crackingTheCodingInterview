package chapter1.ArraysAndStrings;

public class IsRotation {

    /**
     * Given string s1 and s2, write code to check if s2 ia a rotatoin of s1 using only one call to isSubstring
     * isSubstring is available and will return true if word is substring
     *
     * idea:
     * s1 = waterbottle = xy
     * s2 = erbottlewat = yx
     * -> x = wat and y = erbottle
     *
     * hence xyxy will always have yx as substring
     */
    public boolean isRotation(String word1, String word2) {
        if(word1.length() == word2.length() && word1.length() > 0) {
            String s1s1 = word1 + word1;
            return isSubstring(s1s1, word2);
        }
        return false;
    }

    public boolean isSubstring(String s1, String s2) {
        return isSubString(s1, s2, s1.length() -1, s2.length() -1);
    }

    public boolean isSubString(String s1, String s2, int i, int j) {
        if(j == 0)
            return s1.charAt(i) == s2.charAt(j);

        if(i == 0)
            return false;

        if(s1.charAt(i) == s2.charAt(j)) {
            return isSubString(s1, s2, i - 1, j - 1);
        } else {
            return isSubString(s1, s2, i - 1, s2.length() - 1);
        }
    }
}
