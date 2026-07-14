class Solution {
    public void nextPermutation(int[] nums) {
      // Step 1: Find breakpoint
      int n=nums.length;
    int index = -1;

    for (int i = n - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            index = i;
            break;
        }
    }

    // Already the largest permutation
    if (index == -1) {
        reverse(nums, 0, n - 1);
        return;
    }

    // Step 2: Find smallest element greater than pivot
    for (int i = n - 1; i > index; i--) {
        if (nums[i] > nums[index]) {
            swap(nums, i, index);
            break;
        }
    }

    // Step 3: Reverse the suffix
    reverse(nums, index + 1, n - 1);
}

private void reverse(int[] nums, int left, int right) {

    while (left < right) {
        swap(nums, left, right);
        left++;
        right--;
    }
}

private void swap(int[] nums, int i, int j) {

    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}
}