class Solution {
    public String reverseVowels(String s) {
        StringBuilder result = new StringBuilder(s);
        int i = 0, j = result.length() - 1;
        while (j > i && j != i) {
            int first = 0, last = 0;
            if ((result.charAt(i) == 'a' || result.charAt(i) == 'A' || result.charAt(i) == 'u'
                    || result.charAt(i) == 'U' || result.charAt(i) == 'o' || result.charAt(i) == 'O'
                    || result.charAt(i) == 'i' || result.charAt(i) == 'I' || result.charAt(i) == 'e'
                    || result.charAt(i) == 'E')) {
                first = 1;
            }
            if ((result.charAt(j) == 'a' || result.charAt(j) == 'A' || result.charAt(j) == 'u'
                    || result.charAt(j) == 'U' || result.charAt(j) == 'o' || result.charAt(j) == 'O'
                    || result.charAt(j) == 'i' || result.charAt(j) == 'I' || result.charAt(j) == 'e'
                    || result.charAt(j) == 'E')) {
                last = 1;
            }
            if (first == 1 && last == 1) {
                result.setCharAt(i, result.charAt(j));
                result.setCharAt(j, s.charAt(i));
                i++;
                j--;
            } else if (first == 1) {
                j--;
            } else if (last == 1) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return result.toString();
    }
}