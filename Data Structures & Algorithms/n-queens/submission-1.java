class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> subans = new ArrayList<>();
        backt(res, subans, n, 0);
        return res;
    }

    public void backt(List<List<String>> res, List<String> subans,int n, int row) {
        if (subans.size() == n) {
            res.add(new ArrayList<>(subans));
            return;
        }

        String proxy = ".".repeat(n);

        for (int i = 0; i < n; i++) {
            if (isSafe(subans, row, i, n)) {
                String str = proxy.substring(0, i) + "Q" + proxy.substring(i + 1);
                subans.add(str);
                backt(res, subans, n, row + 1);
                subans.remove(subans.size() - 1);
            }
        }
    }

    public boolean isSafe(List<String> subans, int row, int col, int n) {

        for (int prevRow = 0; prevRow < subans.size(); prevRow++) {
            if (subans.get(prevRow).charAt(col) == 'Q') {
                return false;
            }

            int prevCol = subans.get(prevRow).indexOf('Q');
            if (Math.abs(row - prevRow) == Math.abs(col - prevCol)) {
                return false;
            }
        }

        return true;
    }
}