class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int cx = x, mirror = 0, level = 10;
        while (x > 0) {
            int temp = x % 10;
            mirror = mirror * level + temp;
            x /= 10;
        }
        return cx == mirror ? true : false;
    }
}