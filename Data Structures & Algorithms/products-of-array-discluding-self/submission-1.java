class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suff = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] ans = new int[n];
        suff[n-1]=1;
        pref[0]=1;

        for(int i=1;i<n;i++){
            pref[i] = pref[i-1]*nums[i-1];
        }

        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
            ans[i]=pref[i]*suff[i];
        }
        return ans;
    }
}  
