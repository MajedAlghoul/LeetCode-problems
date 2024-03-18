class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list;
        Set<String> set = new HashSet<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int j = 10, i = 0; j <= s.length(); j++, i++) {
            map.put(s.substring(i, j), map.getOrDefault(s.substring(i, j), 0) + 1);
            if (map.getOrDefault(s.substring(i, j), 0) > 1) {
                set.add(s.substring(i, j));
            }
        }
        list = new LinkedList<>(set);
        return list;
    }
}