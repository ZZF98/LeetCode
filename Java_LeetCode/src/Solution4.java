//第四题
/*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

        你可以假设 nums1 和 nums2 不会同时为空。

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5*/

/**
 * @ClassName: Solution4
 * @Auther: zzf
 * @Date: 2019/11/27 23:21
 * @Description:
 */
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //获取数组长度
        int n1 = nums1.length;
        int n2 = nums2.length;
        //如果数组1大于数组2则交换位置（使中位数在左边）
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);
        //获取中位数的位置
        int k = (n1 + n2 + 1) / 2;
        int left = 0;
        int right = n1;
        while (left < right) {
            int m1 = left + (right - left) / 2;
            int m2 = k - m1;
            if (nums1[m1] < nums2[m2 - 1])
                left = m1 + 1;
            else
                right = m1;
        }
        int m1 = left;
        int m2 = k - left;
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : nums1[m1 - 1],
                m2 <= 0 ? Integer.MIN_VALUE : nums2[m2 - 1]);
        if ((n1 + n2) % 2 == 1)
            return c1;
        int c2 = Math.min(m1 >= n1 ? Integer.MAX_VALUE : nums1[m1],
                m2 >= n2 ? Integer.MAX_VALUE : nums2[m2]);
        return (c1 + c2) * 0.5;

    }

    public static void main(String[] args) {
        System.out.println(new Solution4().findMedianSortedArrays(new int[]{2, 3, 6, 8, 9}, new int[]{1, 4, 8, 9}));
    }
}

