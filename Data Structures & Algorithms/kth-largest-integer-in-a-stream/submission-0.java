class KthLargest {

    private PriorityQueue<Integer> pq;
    private int c=0;
    public KthLargest(int k, int[] nums) {
        this.c=k;
        this.pq = new PriorityQueue<>(); 
        for(int i: nums){
            pq.add(i);
            //to keep at most k elements remove the smallest elements
            //iteratively.
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);
        //if size is more than k remove the smallest again
        if(pq.size() > c){
            pq.poll();
        }
        //now return the smallest in pq which is the kth largest
        return pq.peek();
    }
}
