class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>(); 
        for(int num: nums)
        {
            if(num>0) pos.add(num);
            else neg.add(num);
        }
        int k=0;
        for(int i=0;i<pos.size();i++)
        {
            nums[k++]=pos.get(i);
            nums[k++]=neg.get(i);
        }
        return nums;
    }
}