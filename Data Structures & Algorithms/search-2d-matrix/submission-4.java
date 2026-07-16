class Solution {
    public boolean Bsearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int lowr = 0;
        int highr = matrix.length - 1;
        while(lowr <= highr){
            int midr = (lowr + highr)/2;
            if(target >= matrix[midr][0] && target <= matrix[midr][matrix[midr].length - 1]){
                return Bsearch(matrix[midr], target);
            }

            else if(target > matrix[midr][matrix[midr].length - 1]){
                lowr = midr + 1;
            }

            else{
                highr = midr - 1;
            }
        }

        return false;
    }
}