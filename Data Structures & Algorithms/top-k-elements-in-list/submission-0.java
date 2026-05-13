class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        if(nums.length <= 2){
            if(k == 1) return new int[] {nums[0]};

            return nums;
        }

        Map<Integer, Integer> counterNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            counterNums.put(nums[i], counterNums.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] ranking = new List[nums.length + 1];

        for(int i = 0; i < ranking.length; i++){
            ranking[i] = new ArrayList<>();
        }

        for(var counts : counterNums.entrySet()){
            ranking[counts.getValue()].add(counts.getKey());
        }


        int[] output = new int[k];
        int index = 0;

        for(int i = nums.length - 1; i >= 0; i--){
            if(ranking[i].isEmpty()){
                continue;
            }

            for(int j = ranking[i].size() - 1; j >= 0; j--){
                output[index] = ranking[i].get(j);
                index++;

                if(index == k){
                    return output;
                }
            }
        }

        return output;

    }
}
