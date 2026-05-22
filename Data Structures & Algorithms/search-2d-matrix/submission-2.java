class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int lowr = 0;
        int highr = matrix.length - 1;
        while(lowr <= highr){
            int midr = (lowr + highr)/2;

            if(target >= matrix[midr][0] && target <= matrix[midr][matrix[midr].length - 1]){
                int low = 0;
                int high = matrix[midr].length - 1;
                while(low <= high){
                    int i = (low + high)/2;
                    if(matrix[midr][i] == target){
                        return true;
                    }
                    else if(target > matrix[midr][i]){
                        low = i + 1;
                    }
                    else{
                        high = i - 1;
                    }
                }
                return false;
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