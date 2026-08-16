class Solution {
    public int findDuplicate(int[] nums) {
       int toise = nums[0];
       int hare = nums[0];
       do{
        toise = nums[toise];
        hare = nums[nums[hare]];
       } while (toise != hare);

       toise = nums[0];
       while(toise != hare){
        toise = nums[toise];
        hare = nums[hare];
       }
       return toise;
    }
}