class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1, max = Arrays.stream(piles).max().getAsInt();
        int res = max;
        while(min<=max){
            int mid = min + (max-min)/2;
            long total = 0;
            for( int i : piles){
                total += Math.ceil((double) i/mid);
            }
            if(total <= h){
                res = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }
        return res;
    }
}
