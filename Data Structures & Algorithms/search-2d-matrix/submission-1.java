class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] row : matrix){
            if(target >= row[0] && target <= row[row.length - 1]){
                int low = 0; 
                int high = row.length - 1;
                while(low <= high){
                    int i = (low + high)/2;
                    if (row[i] == target){
                        return true;
                    }
                    else if(target > row[i]){
                        low = i + 1;
                    }
                    else{
                        high = i - 1;
                    }
                }
            }
        }
        return false;
    }
}
