class Solution {
    public int maxVowels(String s, int k) {
        int first = 0, last = k - 1, max = Integer.MIN_VALUE;
        int v = getNumberOfVowels(s.substring(0, k));
        if (v > max) {
            max = v;
        }
        int temp = v;
        while (last < s.length()) {
            last++;
            first++;
            if (s.charAt(first - 1) == 'a' || s.charAt(first - 1) == 'i' || s.charAt(first - 1) == 'o'
                    || s.charAt(first - 1) == 'u' || s.charAt(first - 1) == 'e') {
                temp--;
            }
            if ((last < s.length()
                    && (s.charAt(last) == 'a' || s.charAt(last) == 'i' || s.charAt(last) == 'o' || s.charAt(last) == 'u'
                            || s.charAt(last) == 'e'))) {
                temp++;
            }
            if (temp > max) {
                max = temp;
            }
            if (max == k) {
                return max;
            }
        }
        return max;
    }

    private int getNumberOfVowels(String substr) {/// "novowels" 1 "leetcode" k=3
        int counter = 0;
        for (int i = 0; i < substr.length(); i++) {
            if (substr.charAt(i) == 'a' || substr.charAt(i) == 'i' || substr.charAt(i) == 'o' || substr.charAt(i) == 'u'
                    || substr.charAt(i) == 'e') {
                counter++;
            }
        }
        return counter;
    }
}