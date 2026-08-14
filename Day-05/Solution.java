class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0, cur = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        while (i < s.length() && j < s.length()){
            if (i > j){
                j = i;
                continue;
            }
            if (!map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) < 2){
                if (!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j), 1);
                }
                else{
                    map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
                }
                cur++;
                j++;
            }
            else{
                l = Math.max(l, cur);
                cur--;
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }
        }
        l = Math.max(cur, l);
        return l;
    }
}