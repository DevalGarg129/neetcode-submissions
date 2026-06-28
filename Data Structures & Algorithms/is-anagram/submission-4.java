class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(n != m){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        //1. Adding the Elements of First String
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        //2. Adding the elements of Second String
        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)-1);
        }

        for(int freq: map.values()){
            if(freq != 0){
                return false;
            }
        }
        return true;
    }
}
