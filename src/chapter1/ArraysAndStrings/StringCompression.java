package chapter1.ArraysAndStrings;

public class StringCompression {

    /**
     * Perform basic string compression using the counts of repeated characters
     * time: O(n) -> O(n^2) if string concatenation is used instead of string builder
     * space: O(n)
     */
    public String compress(String word) {
//        String compressed = "";
        StringBuilder compressed = new StringBuilder(word.length());
        int count = 1;

        for(int i = 0; i < word.length(); i++) {
            if((i+1) < word.length() && word.charAt(i) == word.charAt(i + 1))
                count++;
            else {
//                compressed += word.charAt(i) + count;
                compressed.append(word.charAt(i));
                compressed.append(count);
                count = 1;
            }
        }

        return (compressed.length() < word.length() ? compressed.toString() : word);
    }
}
