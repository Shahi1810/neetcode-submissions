class Solution {
    public int maxArea(int[] heights) {
        int maxWater=0;
        for(int i=0;i<heights.length;i++){
            for(int j=i+1;j<heights.length;j++){
                int h=Math.min(heights[i],heights[j]);
                int w=j-i;
                maxWater=Math.max(maxWater,(h*w));
            }
        }
        return maxWater;
    }
}
