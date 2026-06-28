class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            if(!set.contains(x)){
                set.add(x);
            }else{
                return true;
            }
        }
        return false;
    }
}