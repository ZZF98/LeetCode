//第一题

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        //遍历
        for (int i = 0; i < nums.length; i++) {
            //判断是否存在另一个数
            int number = target - nums[i];
            if (map.containsKey(number)) {
                return new int[]{map.get(number), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] item = new Solution().twoSum(nums, target);
        for (int s : item) {
            System.out.println(s);
        }
    }
}

