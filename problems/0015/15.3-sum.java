import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            int targetSum = 0 - nums[i];
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == targetSum) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < targetSum) {
                    l++;
                } else {
                    r--;
                }
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }

        return res;
    }
}
