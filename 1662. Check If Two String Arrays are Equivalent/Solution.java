public class Solution {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int arrLenght = word1.length > word2.length ? word1.length : word2.length;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < arrLenght; i++) {
            if (i < word1.length) {
                sb1.append(word1[i]);
            }
            if (i < word2.length) {
                sb2.append(word2[i]);
            }
        }

        return sb1.toString().equals(sb2.toString());
    }
}
