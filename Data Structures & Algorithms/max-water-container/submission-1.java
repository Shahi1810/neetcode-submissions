class Solution {
    public int maxArea(int[] heights) {
        int maxWater=0, l=0, r=heights.length-1;
        
        while(l<r){
            int area = Math.min(heights[l], heights[r]) * (r-l);

            maxWater = Math.max(maxWater, area);
            if(heights[l] <= heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxWater;
    }
}
