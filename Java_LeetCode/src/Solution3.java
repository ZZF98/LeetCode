//第三题
/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

        示例 1:

        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        示例 2:

        输入: "bbbbb"
        输出: 1
        解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        示例 3:

        输入: "pwwkew"
        输出: 3
        解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
             请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。*/

/**
 * @ClassName: Solution3
 * @Auther: zzf
 * @Date: 2019/11/26 20:59
 * @Description:
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        //最大长度
        int maxLength = 0;
        //转字节数组
        char[] chars = s.toCharArray();
        //用来存储下标的地址
        int index = 0;
        for (int j = 0; j < chars.length; j++) {
            for (int innerIndex = index; innerIndex < j; innerIndex++) {
                if (chars[innerIndex] == chars[j]) {
                    //判断最大子串
                    maxLength = Math.max(maxLength, j - index);
                    //指向当前坐标的下一个（因为当前坐标与j相同，所以下次从下一个节点开始）
                    index = innerIndex + 1;
                    break;
                }
            }
        }
        //最后比较一次，字符数-下标与目前 最大长度
        return Math.max(chars.length - index, maxLength);
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}
