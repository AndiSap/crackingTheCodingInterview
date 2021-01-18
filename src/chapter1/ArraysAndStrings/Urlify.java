package chapter1.ArraysAndStrings;

public class Urlify {

    /**
     * replaces all spaces in string with %20
     * Assumption: char array has enough empty spaces at end & no 2 consecutive spaces
     */
    public char[] urlifyWord(char[] word, int trueLength) {
        int numOfSpaces = numOfSpaces(word, trueLength);
        for(int i = trueLength - 1; i >= 0; i--) {
            if(word[i] == ' ') {
                word[i + 2 * numOfSpaces - 2] = '%';
                word[i + 2 * numOfSpaces - 1] = '2';
                word[i + 2 * numOfSpaces] = '0';
                numOfSpaces--;
            } else {
                word[i + 2 * numOfSpaces] = word[i];
            }
        }
        return word;
    }

    /**
     * Returns number of spaces in original word
     */
    public int numOfSpaces(char[] word, int length) {
        int number = 0;
        for(int i = 0; i < length; i++)
            if(word[i] == ' ')
                number++;

        return number;
    }

    /**
     * Optimal solution using pointer to end of urlified word
     */
    public char[] optimalUrlify(char[] word, int length) {
        int numOfSpaces = numOfSpaces(word, length);
        int modifiedIdx = (length - 1) + (numOfSpaces * 2);

        /* add escape character if word has more spaces at the end than needed */
        if(modifiedIdx + 1 < word.length) word[modifiedIdx + 1] = '\0';
        for(int index = length - 1; index >= 0; index--) {
            if(word[index] == ' ') {
                word[modifiedIdx - 2] = '%';
                word[modifiedIdx - 1] = '2';
                word[modifiedIdx] = '0';
                modifiedIdx -= 3;
            } else {
                word[modifiedIdx] = word[index];
                modifiedIdx--;
            }
        }

        return word;
    }
}
