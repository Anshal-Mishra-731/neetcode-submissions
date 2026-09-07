class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); 
        String subst = "";
        int nl = 0;
        int nr = 0;
        backt(res, subst, n, 0, 0);
        return res;
    }

    public void backt(List<String> res, String subst, int n, int nl, int nr){
        if(subst.length() == 2*n){
            res.add(subst);
            return;
        }
        
        if(nl < n){
            subst += "(";
            backt(res, subst, n, nl + 1, nr);
            subst = subst.substring(0, subst.length() - 1);
        }

        if(nl > nr){
            subst += ")";
            backt(res, subst, n, nl, nr + 1);
            subst = subst.substring(0, subst.length() - 1);
        }
    }
}
