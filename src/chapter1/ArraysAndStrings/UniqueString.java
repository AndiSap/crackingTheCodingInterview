package chapter1.ArraysAndStrings;

public class UniqueString {

    /**
     * Checks if given string has all unique characters
     * Assumptions: only letters from a - z
     *
     * time: O(n)
     * space: O(word.length())
     */
    public boolean isUnique(String word) {
        boolean[] wasSeen = new boolean[26]; // could also use HashSet instead

        for(int i = 0; i < word.length(); i++) {
            int currentElement = word.charAt(i) - 'a';
            if(wasSeen[currentElement])
                return false;

            wasSeen[currentElement] = true;
        }

        return true;
    }
}
