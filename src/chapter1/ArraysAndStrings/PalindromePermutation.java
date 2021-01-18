package chapter1.ArraysAndStrings;

public class PalindromePermutation {

    /**
     * Check if given string is a palindrome permutation
     * time: O(n)
     * space: O(n)
     */
    public boolean isPalindromePerm(String word) {
        int[] counts = new int[128];
        word = word.toLowerCase();

        for (int i = 0; i < word.length(); i++)
            if (word.charAt(i) != ' ')
                counts[word.charAt(i)]++; // if counts already has element -> do --;

        int result = 0;
        for(int i = 0; i < counts.length; i++) {
            if (result >= 2)
                return false;
            if (counts[i] > 0 && (counts[i] % 2) != 0)
                result++;
        }

        return true;
    }

    /**
     * Reduced version (not necessarily more optimal)
     */
    public boolean isPalindromeShort(String word) {
        int[] table = new int[(int) 'z' - (int) 'a' + 1];
        int countOdd = 0;

        for(int i = 0; i < word.length(); i++) {
            int current = (int) word.charAt(i) - 'a';
            if(current >= 0) {
                table[current]++;
                if((table[current] % 2) != 0) // not even
                    countOdd++;
                else
                    countOdd--;
            }
        }

        return countOdd <= 1;
    }

    /**
     *  ----------------------------- Modularized version -----------------------------------------
     */
    public boolean isPalindromeModularized(String word) {
        int[] table = buildCharFrequencyTable(word);
        return checkMaxOneOdd(table);
    }

    boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for(int count : table) {
            if(count % 2 == 1) {
                if(foundOdd)
                    return false;
                foundOdd = true;
            }
        }

        return true;
    }

    int getCharNumber(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int current = Character.getNumericValue(c);

        if(a <= current && z >= current)
            return current - a;

        return -1;
    }

    int[] buildCharFrequencyTable(String word) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];

        for(char c : word.toCharArray()) {
            int current = getCharNumber(c);
            if(current != -1)
                table[current]++;
        }

        return table;
    }
}
