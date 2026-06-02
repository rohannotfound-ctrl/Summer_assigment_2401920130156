class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int r=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[r-1]){
                nums[r]=nums[i];
                r++;
            }
        }
        return r;
        
    }
}