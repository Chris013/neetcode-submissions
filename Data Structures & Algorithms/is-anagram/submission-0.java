class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        char[] stringArray = s.toCharArray();

        Map<Character, Integer> chars = new HashMap<>();

        for(int i = 0; i < stringArray.length; i++){

            int count = chars.get(stringArray[i]) == null ? 0 : chars.get(stringArray[i]);
            chars.put(stringArray[i], count + 1);
        }

        stringArray = t.toCharArray();

        for(int i = 0; i < stringArray.length; i++){
            if(!chars.containsKey(stringArray[i])){
                return false;
            }

            int count = chars.get(stringArray[i]) - 1;

            if(count < 0){
                return false;
            }

            chars.put(stringArray[i], count);
        }

        return true;
    }
}
