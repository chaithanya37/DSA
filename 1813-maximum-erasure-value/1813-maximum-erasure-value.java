class Solution {
    public int maximumUniqueSubarray(int[] nums)
     {
        int r=0;
        int left=0;
        int max=0;
        int cur=0;
       
        Set<Integer> set=new HashSet<>();

        while(r<nums.length)
        {
       int l=nums[r];
         while(set.contains(l))
         {
            set.remove(nums[left]);

           cur=cur-nums[left];
            left++;
         }
         set.add(l);
         cur=cur+l;
        max=Math.max(max,cur);
         r++;
        }
        
       return max;

    }
}