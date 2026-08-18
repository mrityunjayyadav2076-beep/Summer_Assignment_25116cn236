class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       if(matrix == null|| matrix.length ==0|| matrix[0].length ==0){
        return false;
       } 
       int A = 0;
       int B =matrix[0].length-1;

       while(A<matrix.length && B>=0){
        if(matrix[A][B] == target){
            return true;
        }
        else if(matrix[A][B]>target){
            B--;
        }
        else{
            A++;
        }
       }
       return false;
    }
}