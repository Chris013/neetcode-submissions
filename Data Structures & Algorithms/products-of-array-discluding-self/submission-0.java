class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] output = new int[nums.length];

        //array mit arraylists, index wird rausgelöscht der rest aufsummiert
        for(int i = 0; i < nums.length; i++){
            ArrayList<Integer> numbers =  Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
            numbers.remove(i);
            output[i] = numbers.stream().reduce(1, (a, b) -> a * b);
        }

        return output;
    }
}  
