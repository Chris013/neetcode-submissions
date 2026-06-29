class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxSeq = 0;

        int currSeq = 1;

        Arrays.sort(nums);

        int lastNum = 0;

        for(int i = 0; i < nums.length; i++){

            if(i == 0){
                lastNum = nums[i];
            }

            if(nums[i] == lastNum){
                continue;
            }else if(nums[i] == lastNum + 1){
                currSeq++;
                lastNum = nums[i];
            }else{
                if(currSeq > maxSeq){
                    maxSeq = currSeq;
                }

                currSeq = 1;
                lastNum = nums[i];
            }
        }

        if(maxSeq < currSeq){
            return currSeq;
        }else{
            return maxSeq;
        }
    }
}
