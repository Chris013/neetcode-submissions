class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars); 
            
            if(!groupedAnagrams.containsKey(sorted)){
                List<String> strings = new ArrayList<>();
                strings.add(s);
                groupedAnagrams.put(sorted, strings);
                continue;
            }

            List<String> strings = groupedAnagrams.get(sorted);
            strings.add(s);
        }

        List<List<String>> output = new ArrayList<>(groupedAnagrams.values());

        return output;
    }
}
