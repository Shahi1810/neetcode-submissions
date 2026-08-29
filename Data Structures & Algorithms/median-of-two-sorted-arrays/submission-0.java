class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //median = beech ke element(s)
        //odd number of elements = beech ka element possible
        //even number of elements = 2 beech ke elements = by 2 kardene ka
        //both arrays are by themselves(independent to each other) sorted
        //strategy(worst case):
        //use a list to store all, use two pointers to traverse through both the arrays
        //pointer 1 element stored in list when its <= pointer 2 element vice-e-versa 
        //for pointer 2, list mein aane ke baad no need to sort the list,
        //just go for the length of the list and then find the median
        //TC: o(n+m)
        //binary search:
        //nums1 = [1,3,4,5]
        //nums2 = [2,7,9]
        //all elements = [1,2,3,4,5,7,9]
        //median = 4.0
        //

        int m = nums1.length, n = nums2.length;

        if(m == 0 && n == 0) return -1.0;
        if(m == 0){
            return median(nums2);
        }else if(n==0){
            return median(nums1);
        }
        int[] merged = new int[n+m];
        int j = 0, k = 0, c = 0;
        while(j<nums1.length && k<nums2.length){
            if(nums1[j]<=nums2[k]){
                merged[c]=nums1[j];
                j++;
                c++;
            }else if(nums1[j]>nums2[k]){
                merged[c]=nums2[k];
                k++;
                c++;
            }
        }
        if(j==nums1.length){
            while(c<merged.length){
                merged[c]=nums2[k];
                c++;
                k++;
            }
        }else if(k==nums2.length){
            while(c<merged.length){
                merged[c]=nums1[j];
                c++;
                j++;
            }
        }
        return median(merged);

    }
    public double median(int[] arr){
        if(arr.length % 2 != 0){
            int middle = arr.length/2;
            return (double)arr[middle];
        }
        int l_mid = arr.length/2 - 1;
        int r_mid = arr.length/2;
        double median = (arr[r_mid] + arr[l_mid])/2.0;
        return median;
    }
}
