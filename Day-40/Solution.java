class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        for (int i = 0; i < n ; i++){
            int ind = s.charAt(i) - 'a';
            if (first[ind] == -1){
                first[ind] = i;
            }
            last[ind] = i;
        }
        List<String> ans = new ArrayList<>();
        int prevEnd = -1;
        for (int i =0; i < n ; i++){
            int ind = s.charAt(i) - 'a';
            if (i != first[ind]) continue;
            int newEnd = isValid(s, i, first, last);
            if (newEnd != -1){
                String temp = s.substring(i, newEnd + 1);
                if (i <= prevEnd){
                    ans.set(ans.size() -1, temp);
                }
                else{
                    ans.add(temp);
                }
                prevEnd = newEnd;
            }
        }
        return ans;
    }
    public int isValid(String s, int start, int[] first, int[] last){
        int end = last[s.charAt(start) - 'a'];
        for (int i = start; i <= end; i++){
            int ind = s.charAt(i) - 'a';
            if (first[ind] < start){
                return -1;
            }
            end = Math.max(end, last[ind]);
        }
        return end;
    }
}