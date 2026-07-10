class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length - 1;

        int res = 0;

        while(l < r){
            int left = heights[l];
            int right = heights[r];

            int area = Math.min(left, right) * (r-l);
            res = Math.max(res, area);

            if(left <= right){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
}
