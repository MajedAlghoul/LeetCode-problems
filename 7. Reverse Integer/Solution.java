class Solution {
    public int reverse(int x) {
        int mirror = 0, level = 10;
        boolean flop = false;
        if (x < 0) {
            flop = true;
            x *= -1;
        }
        System.out.println(level);
        while (x > 0) {
            int temp = x % 10;
            if (flop) {
                temp *= -1;
            }
            try {
                mirror = Math.multiplyExact(mirror, level);
                mirror = Math.addExact(mirror, temp);
            } catch (ArithmeticException e) {
                return 0;
            }
            x /= 10;
        }
        return mirror;
    }
}
