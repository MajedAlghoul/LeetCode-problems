import java.util.HashMap;
import java.util.Map;

class Solution {
    public String intToRoman(int num) {
        if (num <= 0)
            return "";
        int[] values = { 1000, 500, 100, 50, 10, 5, 1 };
        Map<Integer, String> convertRoman = new HashMap<Integer, String>();
        convertRoman.put(1, "I");
        convertRoman.put(5, "V");
        convertRoman.put(10, "X");
        convertRoman.put(50, "L");
        convertRoman.put(100, "C");
        convertRoman.put(500, "D");
        convertRoman.put(1000, "M");
        String numStr = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        int multiplier = numStr.length();
        int digit = Integer.parseInt(numStr.substring(0, 1));
        int multipliedDigit = (int) (digit * Math.pow(10, multiplier - 1));
        if (digit == 4 || digit == 9) {
            for (int j = 0; j < values.length; j++) {
                if (multipliedDigit >= values[j]) {
                    if (j == 1 || j == 3 || j == 5) {
                        sb.append(convertRoman.get(values[j + 1]));
                    } else {
                        sb.append(convertRoman.get(values[j]));
                    }
                    sb.append(convertRoman.get(values[j - 1]));
                    sb.append(intToRoman(num - multipliedDigit));
                    break;
                }
            }
        } else {
            for (int j = 0; j < values.length; j++) {
                if (multipliedDigit >= values[j]) {
                    sb.append(convertRoman.get(values[j]));
                    sb.append(intToRoman(num - values[j]));
                    break;
                }
            }
        }
        return sb.toString();
    }
}