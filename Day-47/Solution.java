class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = new TreeSet<>();
        helper(expression, set);
        return new ArrayList<>(set);
    }
    public void helper(String exp, Set<String> set){
        int r = exp.indexOf('}');
        if (r == -1){
            set.add(exp);
            return;
        }
        int l = exp.lastIndexOf('{', r);
        String prefix = exp.substring(0, l);
        String suffix = exp.substring(r+1);
        String[] options = exp.substring(l+1, r).split(",");

        for (String option : options){
            helper(prefix+option+suffix, set);
        }
    }
}