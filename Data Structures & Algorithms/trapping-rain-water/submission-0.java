class Solution {
    public int trap(int[] height) {
        
        int leftMax = height[0], rightMax = height[height.length-1], l=0, r=height.length-1, res=0;
        
        while(l<r){
            if(leftMax <= rightMax){
                l+=1;
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
            }else{
                r-=1;
                rightMax = Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
            }
        }
        return res;
    }
}
