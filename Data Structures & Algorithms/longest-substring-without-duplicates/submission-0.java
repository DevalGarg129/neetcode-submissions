class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1, j = -1;

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            // acquire
            while(i < n-1){
                f1 = true;
                i++;
                char ch = s.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);
                if(map.get(ch) == 2){
                    break;
                }else{
                    int len = i - j;
                    if(maxLength < len){
                        maxLength = len;
                    }
                }
            }

            //release
            while(j < i){
                f2 = true;
                j++;
                char ch = s.charAt(j);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 1){
                    break;
                }
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return maxLength;
    }
}
