class Solution {
    public int maxArea(int[] heights) {
        int res = 0;

        for(int i = 0; i < heights.length; i++){
            for(int j = i + 1; j < heights.length; j++){

                int left = heights[i];
                int right = heights[j];

                int area = Math.min(left, right) * (j-i);
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
