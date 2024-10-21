import java.math.BigDecimal;
import java.math.RoundingMode;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;
        Double tempDiv = Math.log(n) / Math.log(2);
        BigDecimal bd = new BigDecimal(tempDiv).setScale(14, RoundingMode.DOWN);
        tempDiv = bd.doubleValue();
        return tempDiv % 1 == 0 ? true : false;
    }
}