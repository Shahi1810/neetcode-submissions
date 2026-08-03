class Solution {
    public int[] dailyTemperatures(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[a.length];

        for(int i=0;i<a.length;i++){
            if(i==a.length-1){
                arr[i]=0;
                continue;
            }
            int temp = a[i];
            int index = i;
            while(index < a.length && temp >= a[index] ){
                st.push(a[index]);
                index++;
            }
            if(index == a.length){
                arr[i]=0;
                st.clear();
                continue;
            }
            if(temp < a[index]){
                arr[i] = st.size();
                st.clear();
                continue;
            }
        }
        return arr;
    }
}
