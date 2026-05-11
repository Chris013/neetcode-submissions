class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            
            String s = strs[i];
            char[] chars = s.toCharArray();
            int[] asciiNums = new int[26];

            for(int j = 0; j < chars.length; j++){
                int asciiNum = (int) chars[j] - 97;

                asciiNums[asciiNum] = asciiNums[asciiNum] + 1;
            }

            StringBuilder sb = new StringBuilder();

            for (int num : asciiNums) {
                sb.append(num).append("#");
            }

            String result = sb.toString();
            
            if(!groupedAnagrams.containsKey(result)){
                List<String> strings = new ArrayList<>();
                strings.add(s);
                groupedAnagrams.put(result, strings);
                continue;
            }

            List<String> strings = groupedAnagrams.get(result);
            strings.add(s);
        }

        List<List<String>> output = new ArrayList<>();
        for(var keyVal : groupedAnagrams.entrySet()){
            output.add(keyVal.getValue());
        }

        return output;
    }
}
