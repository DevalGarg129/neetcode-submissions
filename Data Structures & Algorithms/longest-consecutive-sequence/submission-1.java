class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        Arrays.sort(nums);

        int current = 1;
        int longest = 1;

        for(int i=1; i < nums.length; i++){
            //duplicate
            if(nums[i] == nums[i-1]){
                continue;
            }
            //consecutive number
            if(nums[i] == nums[i-1]+1){
                current++;
            }else{
                longest = Math.max(longest, current);
                current = 1;
            }
        }
        return Math.max(current, longest);
    }
}
