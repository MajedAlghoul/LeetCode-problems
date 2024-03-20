class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxs = 0, limit = 0, counter = 0;
        HashMap<Character, Integer> subs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (subs.containsKey(s.charAt(i)) && subs.get(s.charAt(i)) >= limit) {
                counter = i - subs.get(s.charAt(i));
                counter--;
                limit = subs.get(s.charAt(i));
            }
            subs.put(s.charAt(i), i);
            counter++;
            maxs = Math.max(maxs, counter);
        }
        maxs = Math.max(maxs, counter);
        return maxs;
    }
}