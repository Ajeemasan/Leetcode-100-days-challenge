class Solution {
    public int minInsertions(String s) {
        int insertions = 0, needed = 0;
        int i = 0;
        while (i < s.length()){
            if (s.charAt(i) == '('){
                if (needed % 2 == 1){
                    insertions++;
                    needed--;
                }
                needed += 2;
            }
            else{
                needed--;
                if (needed < 0){
                    insertions+=1;
                    needed += 2;
                }
            }
            i++;
        }
        return insertions + needed;
    }
}