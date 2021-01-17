package chapter1.ArraysAndStrings;

public class CheckPermutation {

    /**
     * Checks if 2 strings are permutations of each other
     * Naive solution: sort both strings and compare them -> O(nlogn)
     *
     * time: O(n) or O(m) (depending on which one is bigger)
     * space: O(n+m)
     */
    public boolean check(String word1, String word2) {
        int[] charSet1 = new int[128];
        int[] charSet2 = new int[128];

        for(int i = 0; i < word1.length(); i++)
            charSet1[word1.charAt(i)]++;

        for(int j = 0; j < word2.length(); j++)
            charSet2[word2.charAt(j)]++;

        for(int k = 0; k < charSet1.length; k++)
            if(charSet1[k] != charSet2[k])
                return false;

        return true;
    }

    /**
     * optimized version of check permutations
     * time: O(n) or O(m) (depending on which one is bigger)
     * space: O(n) or O(m) (depending on which one is bigger)
     */
    public boolean optimizedCheck(String word1, String word2) {
        int[] charSet = new int[128];

        for(int i = 0; i < word1.length(); i++)
            charSet[word1.charAt(i)]++;

        for(int i = 0; i < word2.length(); i++) {
            charSet[word2.charAt(i)]--;
            if(charSet[word2.charAt(i)] < 0) // second word has character first word does not have
                return false;
        }

        return true;
    }
}
