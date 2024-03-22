class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder answer = new StringBuilder();
        boolean swish = false;
        for (int i = 0, k = i; i < numRows; i++, k = i) {
            if (i == numRows - 1) {
                swish = true;
            } else {
                swish = false;
            }
            while (k < s.length()) {
                answer.append(s.charAt(k));
                if (swish) {
                    k += (((i + 1) * 2) - 2);
                    if (i != numRows - 1) {
                        swish = false;
                    }
                } else {
                    k += ((numRows - i) * 2) - 2;
                    if (i != 0) {
                        swish = true;
                    }
                }
            }
        }
        return answer.toString();
    }
}