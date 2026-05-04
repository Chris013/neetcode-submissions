class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<Integer>();
        
        for(int i : nums){

            if(uniqueNums.contains(i)){
                return true;
            }

            uniqueNums.add(i);
        }

        return false;
    }
}