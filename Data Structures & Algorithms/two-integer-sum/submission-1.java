class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> missingNums = new HashMap<>();

        for(int i = 0; i < nums.length; i++){

            int j = target - nums[i];

            if(missingNums.containsKey(j)){
                int[] output = {missingNums.get(j), i};
                return output;
            }

            missingNums.put(nums[i], i);
        }

        return new int[]{0, 0};

    }
}
