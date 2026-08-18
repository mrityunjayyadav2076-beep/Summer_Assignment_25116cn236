class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int min = 0;
        int max = n-1;

        while(min <= max){
            int mid = min+(max-min)/2;

            if(citations[mid]>=n-mid){
                max = mid-1;
            }
            else{
                min=mid+1;
            }
        }
        return n-min;
    }
}